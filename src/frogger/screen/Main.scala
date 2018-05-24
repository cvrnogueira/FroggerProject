package frogger.screen


import java.io.IOException

import frogger.screen.frame.elements.UI.frameHelpers.ImageViewConstant
import frogger.screen.frame.elements.car.DefineCarSpawns
import frogger.screen.frame.elements.frog.Frog
import frogger.screen.frame.elements.gameHelpers.alerts.Alerts
import frogger.screen.frame.elements.gameHelpers.labels.LivesRemaingLabel
import frogger.screen.frame.elements.gameHelpers.managers.{MusicManager, globalManager}
import frogger.screen.frame.elements.movementTreatment.{KeyEvents, OnUpdate}
import frogger.screen.frame.elements.player.{Player, PlayerStatus}
import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.control.{DialogEvent, Label}
import javafx.scene.image.{Image, ImageView}
import javafx.scene.layout.AnchorPane
import javafx.scene.{Group, Node, Parent, Scene}
import javafx.stage.Stage

import scala.collection.mutable

object Main {
  def main(args: Array[String]) {
    Application.launch(classOf[Main], args: _*)
  }
}

class Main extends Application {

  var stage: Stage = _
  var root: Parent = _
  private val livesRemaining = new Label()
  private val anchor = new AnchorPane()
  var timer: AnimationTimer = _
  var frogRoad: Group = new Group()
  var cars: mutable.ListBuffer[Node] = new mutable.ListBuffer[Node]
  var frog: Node = _

  @throws[Exception]
  override def start(primaryStage: Stage): Unit = {
    globalManager.restartCarPositionsList()
    MusicManager.playMusic(PlayerStatus.STILL_ON_GAME)
    root = getParentContent
    LivesRemaingLabel.livesRemainingPanel(anchor, livesRemaining)
    frog = Frog.initializeFrog()
    DefineCarSpawns.addCars(cars)
    frogRoad = new Group(frog, cars.head, cars(1), cars(2), cars(3), cars(4), cars(5), root, livesRemaining)
    setZindexOfSprites()
    setStageAndScene(primaryStage, frogRoad)
    animationTimer()
  }

  private def animationTimer(): Unit = {
    timer = (_: Long) => {
      KeyEvents.frogPositionOnClick(frog)
      OnUpdate.winnerCheck(frog, timer)
      if (OnUpdate.checkCollisionReturnPlayerState(cars, frog, stage).compareTo(PlayerStatus.LOSER) == 0) startAgain()
    }
    timer.start()
  }

  private def setZindexOfSprites(): Unit = {
    frog.toFront()
    cars.map(car => car.toFront)
  }

  private def startAgain(): Unit = {
    timer.stop()
    Player.lostLive()
    try {
      Alerts.infoAlert().setOnHidden((evt: DialogEvent) => {
        def event(evt: DialogEvent): Unit = {
          try
            start(stage)
          catch {
            case e: Exception =>
              e.printStackTrace()
          }
        }

        event(evt)
      })
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }

  @throws[IOException]
  private def getParentContent: Parent = {
    FXMLLoader.load(getClass.getResource("mainscreen.fxml"))
  }

  private def setStageAndScene(primaryStage: Stage, frogRoad: Group): Unit = {
    this.stage = primaryStage
    stage.setTitle("Frogger - MLP")
    val scene = new Scene(frogRoad, globalManager.W, globalManager.H)
    stage.setScene(scene)
    stage.setResizable(false)
    KeyEvents.setKeyEvents(scene)
    stage.show()
  }


}

package frogger.screen


import java.io.IOException

import frogger.screen.frame.elements.UI.frameHelpers.ImageViewConstant
import frogger.screen.frame.elements.car.{DefineCarSpawns, RedCar, YellowCar}
import frogger.screen.frame.elements.frog.Frog
import frogger.screen.frame.elements.gameHelpers.collision.Collisions
import frogger.screen.frame.elements.gameHelpers.{Alerts, LivesRemaingLabel, MusicManager, PositionAndImageVariables}
import frogger.screen.frame.elements.player.{Player, PlayerStatus}
import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.scene.control.{Alert, DialogEvent, Label}
import javafx.scene.image.{Image, ImageView}
import javafx.scene.input.KeyEvent
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
  var personageImage: Image = _
  var personage: Node = _
  private val livesRemaining = new Label()
  private val anchor = new AnchorPane()
  var timer: AnimationTimer = _
  var frogRoad: Group = new Group()
  var cars: mutable.ListBuffer[Node] = new mutable.ListBuffer[Node]
  var frog: Node = _

  @throws[Exception]
  override def start(primaryStage: Stage): Unit = {
    PositionAndImageVariables.restartCarPositionsList()
    MusicManager.playMusic(PlayerStatus.STILL_ON_GAME)
    root = getParentContent
    LivesRemaingLabel.livesRemainingPanel(anchor, livesRemaining)
    setPersonageImage()
    Frog.moveFrog(PositionAndImageVariables.W / 2, PositionAndImageVariables.H - 100, frog)
    addCars()
    frogRoad = new Group(frog, cars.head, cars(1), cars(2), cars(3), cars(4), cars(5), root, livesRemaining)
    setZindexOfSprites()
    setStageAndScene(primaryStage, frogRoad)
    animationTimer()
  }

  private def addCars(): Unit = {
    cars.+=(new DefineCarSpawns(new YellowCar).getSpawnCar())
    cars.+=(new DefineCarSpawns(new RedCar).getSpawnCar())
    cars.+=(new DefineCarSpawns(new YellowCar).getSpawnCar())
    cars.+=(new DefineCarSpawns(new RedCar).getSpawnCar())
    cars.+=(new DefineCarSpawns(new YellowCar).getSpawnCar())
    cars.+=(new DefineCarSpawns(new RedCar).getSpawnCar())
  }

  def posYOperationDelta(op: (Double, Int) => Double): (Double) = {
    op(frog.getTranslateY, PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA)
  }

  def posXOperationDelta(op: (Double, Int) => Double): (Double) = {
    op(frog.getTranslateX, PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA)
  }

  private def animationTimer(): Unit = {
    timer = (_: Long) => {
      val dx = 0
      val dy = 0
      if (PositionAndImageVariables.goUp) frog.setTranslateY(posYOperationDelta(_ - _))
      if (PositionAndImageVariables.goDown) frog.setTranslateY(posYOperationDelta(_ + _))
      if (PositionAndImageVariables.goRigth) frog.setTranslateX(posXOperationDelta(_ + _))
      if (PositionAndImageVariables.goLeft) frog.setTranslateX(posXOperationDelta(_ - _))
      Frog.setLastKeyPressedToFalse()
      if (!Frog.moveFrog(dx, dy, frog)) {
        timer.stop()
        MusicManager.playMusic(PlayerStatus.WINNER)
        Alerts.winnerAlert
      }
      if (Collisions.onUpdate(cars, frog, stage).compareTo(PlayerStatus.LOSER) == 0) startAgain()
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
    if (PositionAndImageVariables.livesRemaing <= 0) {
      MusicManager.playMusic(PlayerStatus.LOSER)
      Alerts.loseAlert()
    }
    else try {
      val alert = new Alert(Alert.AlertType.INFORMATION, "Você ainda tem " + PositionAndImageVariables.livesRemaing + " vidas")
      alert.setTitle(null)
      alert.setHeaderText(null)
      alert.setOnHidden((evt: DialogEvent) => {
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
      alert.show()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }

  private def setPersonageImage() = {
    personageImage = new Image(PositionAndImageVariables.FROG_UP)
    ImageViewConstant.frogImg = new ImageView(personageImage)
    personage = ImageViewConstant.frogImg
    frog = personage
  }

  @throws[IOException]
  private def getParentContent: Parent = {
    FXMLLoader.load(getClass.getResource("mainscreen.fxml"))
  }

  private def setStageAndScene(primaryStage: Stage, frogRoad: Group): Unit = {
    this.stage = primaryStage
    stage.setTitle("Frogger - MLP")
    val scene = new Scene(frogRoad, PositionAndImageVariables.W, PositionAndImageVariables.H)
    stage.setScene(scene)
    stage.setResizable(false)
    setKeyEvents(scene)
    stage.show()
  }

  private def setKeyEvents(scene: Scene): Unit = {
    scene.setOnKeyPressed(new EventHandler[KeyEvent]() {
      override def handle(event: KeyEvent): Unit = {
        Frog.switchFrog(event.getCode)
      }
    })
    scene.setOnKeyReleased(new EventHandler[KeyEvent]() {
      override def handle(event: KeyEvent): Unit = {
        Frog.switchFrogPositionAndImage(event.getCode)
      }
    })
  }

}

package frogger.screen


import java.io.IOException
import java.util

import com.sun.javafx.geom.BaseBounds
import com.sun.javafx.geom.transform.BaseTransform
import com.sun.javafx.jmx.{MXNodeAlgorithm, MXNodeAlgorithmContext}
import com.sun.javafx.sg.prism.NGNode
import frogger.screen.frame.elements.car.{DefineCarSpawns, RedCar, YellowCar}
import frogger.screen.frame.elements.frameHelpers.ImageViewConstant
import frogger.screen.frame.elements.frog.Frog
import frogger.screen.frame.elements.gameHelpers.collision.Collisions
import frogger.screen.frame.elements.gameHelpers.{LivesRemaingLabel, MusicManager, PositionAndImageVariables}
import frogger.screen.frame.elements.player.{Player, PlayerStatus}
import javafx.animation.AnimationTimer
import javafx.application.{Application, Platform}
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

  var stage: Stage = null
  var root: Parent = null
  var personageImage: Image = null
  var personage: Node = null
  private val livesRemaining = new Label()
  private val anchor = new AnchorPane()
  var timer: AnimationTimer = null
  var frogRoad: Group = new Group()
  var frog:Frog = new Frog()
  var cars: mutable.ListBuffer[Node] = new mutable.ListBuffer[Node]

  @throws[Exception]
  override def start(primaryStage: Stage): Unit = {
    PositionAndImageVariables.restartCarPositionsList()
    MusicManager.playMusic(PlayerStatus.STILL_ON_GAME)
    root = getParentContent
    LivesRemaingLabel.livesRemainingPanel(anchor, livesRemaining)
     frog = setPersonageImage
    frog.moveFrog(PositionAndImageVariables.W / 2, PositionAndImageVariables.H - 100)
    cars.+=(new DefineCarSpawns(new YellowCar).getSpawnCar)
    cars.+=(new DefineCarSpawns(new RedCar).getSpawnCar)
    cars.+=(new DefineCarSpawns(new YellowCar).getSpawnCar)
    cars.+=(new DefineCarSpawns(new RedCar).getSpawnCar)
    cars.+=(new DefineCarSpawns(new YellowCar).getSpawnCar)
    cars.+=(new DefineCarSpawns(new RedCar).getSpawnCar)
    frogRoad = new Group(frog.getFrog, cars(0), cars(1), cars(2), cars(3), cars(4), cars(5), root, livesRemaining)
    setZindexOfSprites()
    setStageAndScene(primaryStage, frogRoad)
    animationTimer()
  }

  private def animationTimer(): Unit = {
    timer = new AnimationTimer() {
      override def handle(now: Long): Unit = {
        val dx = 0
        val dy = 0
        if (PositionAndImageVariables.goUp) frog.getFrog.setTranslateY(frog.getFrog.getTranslateY - PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA)
        if (PositionAndImageVariables.goDown) frog.getFrog.setTranslateY(frog.getFrog.getTranslateY + PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA)
        if (PositionAndImageVariables.goRigth) frog.getFrog.setTranslateX(frog.getFrog.getTranslateX + PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA)
        if (PositionAndImageVariables.goLeft) frog.getFrog.setTranslateX(frog.getFrog.getTranslateX - PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA)
        frog.setLastKeyPressedToFalse()
        if (!frog.moveFrog(dx, dy)) {
          timer.stop()
          MusicManager.playMusic(PlayerStatus.WINNER)
          val alert = new Alert(Alert.AlertType.INFORMATION, "Você ganhou o jogo!")
          alert.setTitle(null)
          alert.setHeaderText(null)
          alert.setOnHidden((evt: DialogEvent) => Platform.exit())
          alert.show()
        }
        if (Collisions.onUpdate(cars, frog, stage).compareTo(PlayerStatus.LOSER) == 0) startAgain()
      }
    }
    timer.start()
  }

  private def setZindexOfSprites(): Unit = {
    frog.getFrog.toFront()
    cars(0).toFront()
    cars(1).toFront()
    cars(2).toFront()
    cars(3).toFront()
    cars(4).toFront()
    cars(5).toFront()
  }

  private def startAgain(): Unit = {
    timer.stop()
    Player.lostLive()
    if (PositionAndImageVariables.livesRemaing <= 0) {
      MusicManager.playMusic(PlayerStatus.LOSER)
      val alert = new Alert(Alert.AlertType.INFORMATION, "Você perdeu o jogo!")
      alert.setTitle(null)
      alert.setHeaderText(null)
      alert.setOnHidden((evt: DialogEvent) => Platform.exit())
      alert.show()
    }
    else try {
      val alert = new Alert(Alert.AlertType.INFORMATION, "Você ainda tem " + PositionAndImageVariables.livesRemaing + " vidas")
      alert.setTitle(null)
      alert.setHeaderText(null)
      alert.setOnHidden((evt: DialogEvent) => {
        def foo(evt: DialogEvent) = {
          try
            start(stage)
          catch {
            case e: Exception =>
              e.printStackTrace()
          }
        }

        foo(evt)
      })
      alert.show()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }

  private def setPersonageImage = {
    personageImage = new Image(PositionAndImageVariables.FROG_UP)
    ImageViewConstant.frogImg = new ImageView(personageImage)
    personage = ImageViewConstant.frogImg
    new Frog(personage)
  }

  @throws[IOException]
  private def getParentContent : Parent ={
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
        frog.switchFrog(event.getCode)
      }
    })
    scene.setOnKeyReleased(new EventHandler[KeyEvent]() {
      override def handle(event: KeyEvent): Unit = {
        frog.switchFrogPositionAndImage(event.getCode)
      }
    })
  }

}

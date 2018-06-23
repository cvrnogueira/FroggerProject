package frogger.screen.frame.elements.gameHelpers.managers

import javafx.scene.Node

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object globalManager {

  val KEYBOARD_MOVEMENT_DELTA = 12

  val W: Double = 1260

  val H: Double = 640

  val FROG_UP: String = "frogger/screen/frame/elements/frog/assets/frog-up.png"

  val FROG_DOWN: String = "frogger/screen/frame/elements/frog/assets/frog-down.png"

  val FROG_LEFT: String = "frogger/screen/frame/elements/frog/assets/frog-left.png"

  val FROG_RIGHT: String = "frogger/screen/frame/elements/frog/assets/frog-right.png"

  val YELLOW_CAR: String = "frogger/screen/frame/elements/car/assets/yellowCar2.png"

  val RED_CAR: String = "frogger/screen/frame/elements/car/assets/redCar.png"

  var goUp: Boolean = false

  var goDown: Boolean = false

  var goRigth: Boolean = false

  var goLeft: Boolean = false

  var livesRemaing = 3

  var UP_MARGIN = 50

  var indice: Double = 0

  def reestartIndice(): Unit ={
     indice = 0;
  }

  def getCarPosition():  ListBuffer[Node] ={
    carPositions
  }
  var carPositions: ListBuffer[Node] = restartCarPositionsList()

  def restartCarPositionsList(): mutable.ListBuffer[Node] = {
    new mutable.ListBuffer[Node]()
  }

  def reestartLivesRemaining(): Unit ={
    if(livesRemaing < 0) livesRemaing = 3
  }

}

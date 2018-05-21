package frogger.screen.frame.gameHelpers

import frogger.screen.frame.elements.car.Car
import frogger.screen.frame.elements.generics.GenericList

object PositionAndImageVariables {

  val KEYBOARD_MOVEMENT_DELTA = 12

  val W: Double = 1260

  val H: Double = 640

  val FROG_UP: String = "frogger/screen/frame/elements/frog/assets/frog-up.png"

  val FROG_DOWN: String = "frogger/screen/frame/elements/frog/assets/frog-down.png"

  val FROG_LEFT: String = "frogger/screen/frame/elements/frog/assets/frog-left.png"

  val FROG_RIGHT: String = "frogger/screen/frame/elements/frog/assets/frog-right.png"

  var goUp: Boolean = false

  var goDown: Boolean = false

  var goRigth: Boolean = false

  var goLeft: Boolean = false

  var livesRemaing = 3

  var UP_MARGIN = 50

  //var carPositions = mutable.MutableList[Double]()
  var carPositions = new GenericList[Car]

  def restartCarPositionsList(): Unit = {
    //carPositions = mutable.MutableList[Double]()
    carPositions.restart()
  }

  def reestartLivesRemaining(): Unit ={
    if(livesRemaing < 0) livesRemaing = 3;
  }

}

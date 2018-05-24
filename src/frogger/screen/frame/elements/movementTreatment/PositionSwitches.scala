package frogger.screen.frame.elements.movementTreatment

import frogger.screen.frame.elements.UI.frameHelpers.ImageViewConstant
import frogger.screen.frame.elements.gameHelpers.managers.globalManager
import javafx.scene.image.Image
import javafx.scene.input.KeyCode

trait PositionSwitches {

  def switchPosition(keyCode: KeyCode): Unit = keyCode match {
    case KeyCode.UP => globalManager.goUp = false
    case KeyCode.DOWN => globalManager.goDown = false
    case KeyCode.LEFT => globalManager.goLeft = false
    case KeyCode.RIGHT => globalManager.goRigth = false
    case x => false
  }

  def switchPositionAndImage(keyCode: KeyCode): Unit = keyCode match {
    case KeyCode.UP =>
      globalManager.goUp = true
      ImageViewConstant.frogImg.setImage(new Image(globalManager.FROG_UP))
    case KeyCode.DOWN =>
      globalManager.goDown = true
      ImageViewConstant.frogImg.setImage(new Image(globalManager.FROG_DOWN))
    case KeyCode.LEFT
    =>
      globalManager.goLeft = true
      ImageViewConstant.frogImg.setImage(new Image(globalManager.FROG_LEFT))
    case KeyCode.RIGHT
    =>
      globalManager.goRigth = true
      ImageViewConstant.frogImg.setImage(new Image(globalManager.FROG_RIGHT))
    case x =>
  }

  def setFalseToLastKeyActive(): Unit ={
    if (globalManager.goUp) {
      globalManager.goUp = false
    }
    if (globalManager.goDown) {
      globalManager.goDown = false
    }
    if (globalManager.goRigth) {
      globalManager.goRigth = false
    }
    if (globalManager.goLeft) {
      globalManager.goLeft = false
    }
  }
}

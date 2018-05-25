package frogger.screen.frame.elements.movementTreatment

import frogger.screen.frame.elements.firstOrderFunctions.FirstOrderFunctions
import frogger.screen.frame.elements.frog.Frog
import frogger.screen.frame.elements.gameHelpers.managers.globalManager
import frogger.screen.frame.elements.highOrderFunctions.HighOrderFunctions
import javafx.event.EventHandler
import javafx.scene.{Node, Scene}
import javafx.scene.input.KeyEvent

object KeyEvents {

  def frogPositionOnClick(frog : Node): Unit ={
    if (globalManager.goUp) frog.setTranslateY(HighOrderFunctions.posYOperationDelta(frog,_ - _))
    if (globalManager.goDown) frog.setTranslateY(HighOrderFunctions.posYOperationDelta(frog,_ + _))
    if (globalManager.goRigth) frog.setTranslateX(HighOrderFunctions.posXOperationDelta(frog,_ + _))
    if (globalManager.goLeft) frog.setTranslateX(HighOrderFunctions.posXOperationDelta(frog,_ - _))
    Frog.setLastKeyPressedToFalse()
  }
   def setKeyEvents(scene: Scene): Unit = {
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
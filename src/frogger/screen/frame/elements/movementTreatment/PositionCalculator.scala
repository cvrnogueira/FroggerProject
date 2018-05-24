package frogger.screen.frame.elements.movementTreatment

import frogger.screen.frame.elements.firstOrderFunctions.FirstOrderFunctions
import frogger.screen.frame.elements.gameHelpers.managers.globalManager
import frogger.screen.frame.elements.highOrderFunctions.HighOrderFunctions
import javafx.scene.Node
import javafx.scene.input.KeyCode

object PositionCalculator extends PositionSwitches {

  def moveFrog(frog: Node, dx: Int,dy: Int){
    if (dx == 0 && dy == 0) return
    val x: Double = HighOrderFunctions.sum(HighOrderFunctions.id, FirstOrderFunctions.width(frog), frog.getLayoutX, dx)
    val y: Double = HighOrderFunctions.sum(HighOrderFunctions.id, FirstOrderFunctions.heigh(frog), frog.getLayoutY, dy)
    moveFrog(frog, x)(y)
  }
  def moveFrog(frog: Node, x: Double): Double => Unit = (y :Double)=>{
    val cx = FirstOrderFunctions.width(frog)
    val cy = FirstOrderFunctions.heigh(frog)
    if (x - cx >= 0 && x + cx <= globalManager.W && y - cy >= 0 && y + cy <= globalManager.H) {
      frog.relocate(x - cx, y - cy)
    }
  }
  def switchDirection(keyCode: KeyCode) : Unit = {
    switchPosition(keyCode)
  }
  def switchDirectionAndImage(keyCode: KeyCode) : Unit = {
    switchPositionAndImage(keyCode)
  }
}

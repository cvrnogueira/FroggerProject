package frogger.screen.frame.gameHelpers

import javafx.scene.Node
import javafx.scene.input.KeyCode

object PositionCalculator extends PositionSwitches {

  def moveFrog(frog: Node, dx: Int, dy: Int): Unit = {
    if (dx == 0 && dy == 0) return
    val cx: Double = frog.getBoundsInLocal.getWidth / 2
    val cy: Double = frog.getBoundsInLocal.getHeight / 2
    val x: Double = cx + frog.getLayoutX + dx
    val y: Double = cy + frog.getLayoutY + dy
    moveFrog(frog, x, y)
  }

  def moveFrog(frog: Node, x: Double, y: Double): Unit = {
    val cx: Double = frog.getBoundsInLocal.getWidth / 2
    val cy: Double = frog.getBoundsInLocal.getHeight / 2
    if (x - cx >= 0 && x + cx <= PositionAndImageVariables.W && y - cy >= 0 && y + cy <= PositionAndImageVariables.H) {
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

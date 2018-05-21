package frogger.screen.frame.gameHelpers

import javafx.scene.Node
import javafx.scene.input.KeyCode

object PositionCalculator extends PositionSwitches {

  def moveFrog(frog: Node, dx: Int,dy: Int){
    if (dx == 0 && dy == 0) return
    val x: Double = sum(id, width(frog), frog.getLayoutX, dx)
    val y: Double = sum(id, heigth(frog), frog.getLayoutY, dy)
    moveFrog(frog, x)(y)
  }
  val width: Node => Double = (frog: Node) => frog.getBoundsInLocal.getWidth / 2
  val heigth: Node => Double = (frog: Node) =>  frog.getBoundsInLocal.getHeight / 2

  def moveFrog(frog: Node, x: Double): Double => Unit = (y :Double)=>{
    val cx = width(frog)
    val cy = heigth(frog)
    if (x - cx >= 0 && x + cx <= PositionAndImageVariables.W && y - cy >= 0 && y + cy <= PositionAndImageVariables.H) {
      frog.relocate(x - cx, y - cy)
    }
  }
//high order function
  def id(x: Double): Double = x
  def sum(f: Double => Double, a: Double, b: Double, c:Double): Double =
     f(a) + sum(f, a , b,c)

  def switchDirection(keyCode: KeyCode) : Unit = {
    switchPosition(keyCode)
  }
  def switchDirectionAndImage(keyCode: KeyCode) : Unit = {
    switchPositionAndImage(keyCode)
  }
}

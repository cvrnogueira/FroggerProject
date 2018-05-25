package frogger.screen.frame.elements.highOrderFunctions

import frogger.screen.frame.elements.gameHelpers.managers.globalManager
import javafx.scene.Node

object HighOrderFunctions {

  def id(x: Double): Double = x
  def sum(f: Double => Double, a: Double, b: Double, c:Double): Double =
    f(a) + sum(f, a , b,c)

  def posYOperationDelta(frog: Node, op: (Double, Int) => Double): (Double) = {
    op(frog.getTranslateY, globalManager.KEYBOARD_MOVEMENT_DELTA)
  }

  def posXOperationDelta(frog: Node, op: (Double, Int) => Double): (Double) = {
    op(frog.getTranslateX, globalManager.KEYBOARD_MOVEMENT_DELTA)
  }
}

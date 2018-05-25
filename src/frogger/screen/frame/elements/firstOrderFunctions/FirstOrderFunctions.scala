package frogger.screen.frame.elements.firstOrderFunctions

import frogger.screen.frame.elements.gameHelpers.managers.globalManager
import javafx.scene.Node

object FirstOrderFunctions {

  val subtractIntegerValues: (Int, Int) => Int = (x: Int, y: Int) => x - y
  val subtractDoubleValues: (Double, Double) => Int = (x: Double, y: Double) => (x - y).toInt
  val subtract64: Double => Double = (x: Double) => x - 64
  val width: Node => Double = (frog: Node) => frog.getBoundsInLocal.getWidth / 2
  val heigh: Node => Double = (frog: Node) =>  frog.getBoundsInLocal.getHeight / 2
}

package frogger.screen.frame.elements.car

import frogger.screen.frame.elements.frameHelpers.TexturedElement
import frogger.screen.frame.gameHelpers.PositionAndImageVariables

import scala.collection.mutable


abstract class Car extends TexturedElement(49, 24) {

  def setTextureOfCar() {}

  def setTranslateY(): Double = {
    val start = subtractDoubleValues(PositionAndImageVariables.H, 200)
    val end: Int = PositionAndImageVariables.UP_MARGIN
    val interval = subtractIntegerValues(start,end)
    val r1 = subtractIntegerValues(start, (new scala.util.Random).nextInt(interval))
    val finalPosition = getPos(PositionAndImageVariables.carPositions.elements)
    PositionAndImageVariables.carPositions.add(this) //+= finalPosition
    setTranslateY(finalPosition)
    finalPosition
  }

  val subtractIntegerValues = (x: Int, y: Int) => x - y
  val subtractDoubleValues = (x: Double, y: Double) => (x - y).toInt

  val subtract64 = (x:Double) => x-64;

  def getPos(list: mutable.MutableList[Car]): Double = {
    if (list.isEmpty) { 402 }
    else {
      subtract64(list.last.localToScene(list.last.getBoundsInLocal).getMinY)
    }
  }
}

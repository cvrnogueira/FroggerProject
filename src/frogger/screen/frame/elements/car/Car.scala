package frogger.screen.frame.elements.car

import frogger.screen.frame.elements.UI.frameHelpers.TexturedElement
import frogger.screen.frame.elements.gameHelpers.managers.globalManager

import scala.collection.mutable


 class Car extends TexturedElement(49, 24) {

  def setTextureOfCar() {}

   def setRedTextureOfCar(): Unit ={
     setTexture(getClass.getResource("assets/redCar.png").toString, 49, 24)
   }
   def setYellowTextureOfCar(): Unit ={
     setTexture(getClass.getResource("assets/yellowCar.png").toString, 49, 24)
   }
  def setTranslateY(): Double = {
    val start = subtractDoubleValues(globalManager.H, 200)
    val end: Int = globalManager.UP_MARGIN
    val interval = subtractIntegerValues(start,end)
    val r1 = subtractIntegerValues(start, (new scala.util.Random).nextInt(interval))
    val finalPosition = getPos(globalManager.carPositions)
    globalManager.carPositions.+=(this)
    setTranslateY(finalPosition)
    finalPosition
  }

  val subtractIntegerValues: (Int, Int) => Int = (x: Int, y: Int) => x - y
  val subtractDoubleValues: (Double, Double) => Int = (x: Double, y: Double) => (x - y).toInt

  val subtract64: Double => Double = (x:Double) => x-64

  def getPos(list: mutable.ListBuffer[Car]): Double = {
    if (list.isEmpty) { 402 }
    else {
      subtract64(list.last.localToScene(list.last.getBoundsInLocal).getMinY)
    }
  }
}

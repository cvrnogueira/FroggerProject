package frogger.screen.frame.elements.car

import frogger.screen.frame.elements.UI.frameHelpers.TexturedElement
import frogger.screen.frame.elements.firstOrderFunctions.FirstOrderFunctions
import frogger.screen.frame.elements.gameHelpers.managers.globalManager
import javafx.scene.Node

import scala.collection.mutable


object Car {


  var carId: Double = globalManager.indice

  val listOfYPos= List(402.0, 402.0, 338.0, 274.0,210.0,146.0)

  def setTranslateY(car: Node): Double = {
    carId= carId+1
    val start = FirstOrderFunctions.subtractDoubleValues(globalManager.H, 200)
    val end: Int = globalManager.UP_MARGIN
    val interval = FirstOrderFunctions.subtractIntegerValues(start, end)
    val r1 = FirstOrderFunctions.subtractIntegerValues(start, (new scala.util.Random).nextInt(interval))
    val finalPosition = getPos(carId)
    globalManager.getCarPosition.+=(car)
   // car.setTranslateY(finalPosition)
    finalPosition
  }
  def getPos(indice: Double): Double = {
    print("indice " + indice)
    FirstOrderFunctions.subtract64(listOfYPos.head)
    //    else {
    //      indice match {
    //        case 1  =>    FirstOrderFunctions.subtract64(listOfYPos.head)
    //        case 2  =>    FirstOrderFunctions.subtract64(listOfYPos(1))
    //        case 3  =>    FirstOrderFunctions.subtract64(listOfYPos(2))
    //        case 4  =>    FirstOrderFunctions.subtract64(listOfYPos(3))
    //        case 5  =>   FirstOrderFunctions.subtract64(listOfYPos.(4))
    //        case 6  =>   FirstOrderFunctions.subtract64(listOfYPos.last)
    //      }
    //}
  }
}

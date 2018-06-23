package frogger.screen.frame.elements.car

import frogger.screen.frame.elements.firstOrderFunctions.FirstOrderFunctions
import frogger.screen.frame.elements.gameHelpers.managers.globalManager
import javafx.scene.Node


object Car {


  val listOfYPos = List(470.0, 402.0, 338.0, 274.0, 210.0, 146.0)

  def setTranslateY(car: Node): Double = {
    globalManager.indice = globalManager.indice + 1
    val carId = globalManager.getIndice
    val start = FirstOrderFunctions.subtractDoubleValues(globalManager.H, 200)
    val end: Int = globalManager.UP_MARGIN
    val interval = FirstOrderFunctions.subtractIntegerValues(start, end)
    val r1 = FirstOrderFunctions.subtractIntegerValues(start, (new scala.util.Random).nextInt(interval))
    val finalPosition = getPos(carId)
    car.setTranslateY(finalPosition)
    globalManager.getCarPosition.+=(car)
    finalPosition
  }

  def getPos(indice: Double): Double = {
    indice match {
      case 0 => FirstOrderFunctions.subtract64(listOfYPos.head)
      case 1 => FirstOrderFunctions.subtract64(listOfYPos(1))
      case 2 => FirstOrderFunctions.subtract64(listOfYPos(2))
      case 3 => FirstOrderFunctions.subtract64(listOfYPos(3))
      case 4 => FirstOrderFunctions.subtract64(listOfYPos(4))
      case 5 => FirstOrderFunctions.subtract64(listOfYPos(5))
    }

  }
}

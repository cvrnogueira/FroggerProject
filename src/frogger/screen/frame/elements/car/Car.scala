//package frogger.screen.frame.elements.car
//
//import frogger.screen.frame.elements.UI.frameHelpers.TexturedElement
//import frogger.screen.frame.elements.firstOrderFunctions.FirstOrderFunctions
//import frogger.screen.frame.elements.gameHelpers.managers.globalManager
//import javafx.scene.Node
//
//import scala.collection.mutable
//
//
//object Car extends TexturedElement(49, 24) {
//
//  def setTextureOfCar() {}
//
//  def setRedTextureOfCar(): Unit = {
//    setTexture(getClass.getResource("assets/redCar.png").toString, 49, 24)
//  }
//
//  def setYellowTextureOfCar(): Unit = {
//    setTexture(getClass.getResource("assets/yellowCar.png").toString, 49, 24)
//  }
//
//  def setTranslateY(): Double = {
//    val start = FirstOrderFunctions.subtractDoubleValues(globalManager.H, 200)
//    val end: Int = globalManager.UP_MARGIN
//    val interval = FirstOrderFunctions.subtractIntegerValues(start, end)
//    val r1 = FirstOrderFunctions.subtractIntegerValues(start, (new scala.util.Random).nextInt(interval))
//    val finalPosition = getPos(globalManager.carPositions)
//    globalManager.carPositions.+=(this)
//    setTranslateY(finalPosition)
//    finalPosition
//  }
//
//  def getPos(list: mutable.ListBuffer[Node]): Double = {
//    if (list.isEmpty) {
//      402
//    }
//    else {
//      FirstOrderFunctions.subtract64(list.last.localToScene(list.last.getBoundsInLocal).getMinY)
//    }
//  }
//}

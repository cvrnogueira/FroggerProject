
package frogger.screen.frame.elements.car

import frogger.screen.frame.elements.UI.frameHelpers.{ImageViewConstant, TexturedElement}
import frogger.screen.frame.elements.firstOrderFunctions.FirstOrderFunctions
import frogger.screen.frame.elements.gameHelpers.managers.globalManager
import javafx.scene.Node
import javafx.scene.image.{Image, ImageView}

import scala.collection.mutable


object DefineCarSpawns extends TexturedElement(49, 24) {

  val listOfYPos= List(402.0, 338.0, 274.0,210.0,146.0)
  var i: Double = -1
  def spawnCarsRed(car: Node): Node = {
    setTranslateY(car)
    car
  }

  def spawnCarsYellow(car: Node): Node = {
    setTranslateY(car)
    car
  }
  def setTranslateY(car: Node): Double = {
    i= i+1
    val start = FirstOrderFunctions.subtractDoubleValues(globalManager.H, 200)
    val end: Int = globalManager.UP_MARGIN
    val interval = FirstOrderFunctions.subtractIntegerValues(start, end)
    val r1 = FirstOrderFunctions.subtractIntegerValues(start, (new scala.util.Random).nextInt(interval))
    val finalPosition = getPos(globalManager.carPositions, i)
    setTranslateY(finalPosition)
    globalManager.carPositions.+=(car)
    finalPosition
  }
  def addCars(cars :mutable.ListBuffer[Node]): mutable.ListBuffer[Node] = {
    cars.+=(DefineCarSpawns.spawnCarsYellow(setYellowCarImage()))
    cars.+=(DefineCarSpawns.spawnCarsRed(setRedCarImage()))
    cars.+=(DefineCarSpawns.spawnCarsYellow(setYellowCarImage()))
    cars.+=(DefineCarSpawns.spawnCarsRed(setRedCarImage()))
    cars.+=(DefineCarSpawns.spawnCarsYellow(setYellowCarImage()))
    cars.+=(DefineCarSpawns.spawnCarsRed(setRedCarImage()))
    cars
  }
  private def setYellowCarImage(): Node = {
    val personageImage = new Image(globalManager.YELLOW_CAR)
    ImageViewConstant.carImg = new ImageView(personageImage)
    val car = ImageViewConstant.carImg
    car
  }

  private def setRedCarImage(): Node = {
    val personageImage = new Image(globalManager.RED_CAR)
    ImageViewConstant.carImg = new ImageView(personageImage)
    val car = ImageViewConstant.carImg
    car
  }

  def getPos(list: mutable.ListBuffer[Node], indice: Double): Double = {
    var a: Double = 0
    if (list.isEmpty) {
      402
    }
    else {
      indice match {
        case 1  =>    a = FirstOrderFunctions.subtract64(listOfYPos.head)
        case 2  =>     a =FirstOrderFunctions.subtract64(listOfYPos(1))
        case 3  =>    a=  FirstOrderFunctions.subtract64(listOfYPos(2))
        case 4  =>    a=  FirstOrderFunctions.subtract64(listOfYPos(3))
        case 5  =>   a=   FirstOrderFunctions.subtract64(listOfYPos.last)
      }
      print("=== " + indice + "==== " + a)

      a

    }
  }

}




package frogger.screen.frame.elements.car

import frogger.screen.frame.elements.UI.frameHelpers.{ImageViewConstant, TexturedElement}
import frogger.screen.frame.elements.firstOrderFunctions.FirstOrderFunctions
import frogger.screen.frame.elements.gameHelpers.managers.globalManager
import javafx.scene.Node
import javafx.scene.image.{Image, ImageView}

import scala.collection.mutable


object DefineCarSpawns extends TexturedElement(49, 24) {

  def spawnCarsRed(car: Node): Node = {
    setTranslateY(car)
    car
  }

  def spawnCarsYellow(car: Node): Node = {
    setTranslateY(car)
    car
  }
  def setTranslateY(car: Node): Double = {
    val start = FirstOrderFunctions.subtractDoubleValues(globalManager.H, 200)
    val end: Int = globalManager.UP_MARGIN
    val interval = FirstOrderFunctions.subtractIntegerValues(start, end)
    val r1 = FirstOrderFunctions.subtractIntegerValues(start, (new scala.util.Random).nextInt(interval))
    val finalPosition = getPos(globalManager.carPositions)
    globalManager.carPositions.+=(car)
    setTranslateY(finalPosition)
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

  def getPos(list: mutable.ListBuffer[Node]): Double = {
    if (list.isEmpty) {
      402
    }
    else {
      FirstOrderFunctions.subtract64(list.last.localToScene(list.last.getBoundsInLocal).getMinY)
    }
  }

}



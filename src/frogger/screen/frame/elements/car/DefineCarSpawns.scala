
package frogger.screen.frame.elements.car

import frogger.screen.frame.elements.UI.frameHelpers.{ImageViewConstant, TexturedElement}
import frogger.screen.frame.elements.firstOrderFunctions.FirstOrderFunctions
import frogger.screen.frame.elements.gameHelpers.managers.globalManager
import javafx.scene.Node
import javafx.scene.image.{Image, ImageView}

import scala.collection.mutable


object DefineCarSpawns {


  def spawnCarsRed(car: Node): Node = {
    Car.setTranslateY(car)
    car
  }

  def spawnCarsYellow(car: Node): Node = {
    Car.setTranslateY(car)
    car
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



}




package frogger.screen.frame.elements.car

import javafx.scene.Node

import scala.collection.mutable


object DefineCarSpawns {

  def spawnCarsRed(car: Car): Car = {
    car.setTranslateY()
    car.setRedTextureOfCar
    car
  }

  def spawnCarsYellow(car: Car): Car = {
    car.setTranslateY()
    car.setYellowTextureOfCar
    car
  }

  def addCars(cars :mutable.ListBuffer[Node]): mutable.ListBuffer[Node] = {
    cars.+=(DefineCarSpawns.spawnCarsYellow(new Car()))
    cars.+=(DefineCarSpawns.spawnCarsRed(new Car()))
    cars.+=(DefineCarSpawns.spawnCarsYellow(new Car()))
    cars.+=(DefineCarSpawns.spawnCarsRed(new Car()))
    cars.+=(DefineCarSpawns.spawnCarsYellow(new Car()))
    cars.+=(DefineCarSpawns.spawnCarsRed(new Car()))
    cars
  }



}



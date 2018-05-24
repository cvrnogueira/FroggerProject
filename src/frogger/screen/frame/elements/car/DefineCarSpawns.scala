
package frogger.screen.frame.elements.car

import javafx.scene.Node

class DefineCarSpawns(val car: Car) {

  def this(car: YellowCar) = {
    this(car: Car)
    spawnCars(car)
  }

  def this(car: RedCar) = {
    this(car: Car)
    spawnCars(car)
  }

  def getSpawnCar(): Node = {
    if(car == null) throw new Exception("Erro de sistema, reinicie o jogo, por favor!")
    car
  }

  def spawnCars(yellowCar: YellowCar): YellowCar = {
    yellowCar.setTranslateY()
    yellowCar.setTextureOfCar()
    yellowCar
  }

  def spawnCars(redCar: RedCar): RedCar = {
    redCar.setTranslateY()
    redCar.setTextureOfCar()
    redCar
  }

}



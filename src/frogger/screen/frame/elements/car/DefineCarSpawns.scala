
package frogger.screen.frame.elements.car


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


}



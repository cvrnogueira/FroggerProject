package frogger.screen.frame.elements.street

import frogger.screen.frame.elements.car.Car
import frogger.screen.frame.elements.frameHelpers.TexturedElement

class Street(lanes: Int) extends TexturedElement(1280, lanes * 64) {

  setTexture(getClass.getResource("street-texture.jpg").toString, 64, 64)

  def addCar(car: Car): Unit = {
    this.getChildren.add(car)
  }

}

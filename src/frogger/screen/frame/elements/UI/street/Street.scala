package frogger.screen.frame.elements.UI.street

import frogger.screen.frame.elements.car.Car
import frogger.screen.frame.elements.UI.frameHelpers.TexturedElement

class Street(lanes: Int) extends TexturedElement(1280, lanes * 64) {

  setTexture(getClass.getResource("street-texture.jpg").toString, 64, 64)

}

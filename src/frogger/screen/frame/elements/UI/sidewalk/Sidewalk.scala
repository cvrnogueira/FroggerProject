package frogger.screen.frame.elements.UI.sidewalk

import frogger.screen.frame.elements.UI.frameHelpers.TexturedElement

class Sidewalk extends TexturedElement(1280, 64) {

  setTexture(getClass.getResource("sidewalk-texture.jpg").toString, 64, 64)

}

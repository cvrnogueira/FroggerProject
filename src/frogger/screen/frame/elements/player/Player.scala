package frogger.screen.frame.elements.player

import frogger.screen.frame.elements.gameHelpers.PositionAndImageVariables

object Player {

  def lostLive() {
    PositionAndImageVariables.livesRemaing -= 1
  }

}

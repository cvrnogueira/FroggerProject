package frogger.screen.frame.elements.player

import frogger.screen.frame.elements.gameHelpers.managers.globalManager

object Player {

  def lostLive() {
    globalManager.livesRemaing -= 1
  }

}

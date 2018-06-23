package frogger.screen.frame.elements.player

import frogger.screen.frame.elements.gameHelpers.alerts.Alerts
import frogger.screen.frame.elements.gameHelpers.managers.{MusicManager, globalManager}

object Player {

  def lostLive() {
    globalManager.livesRemaing -= 1
    globalManager.reestartIndice()
    if (globalManager.livesRemaing <= 0) {
      MusicManager.playMusic(PlayerStatus.LOSER)
      Alerts.loseAlert()
      System.exit(1)

    }
  }

}

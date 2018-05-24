package frogger.screen.frame.elements.gameHelpers.alerts

import javafx.application.Platform
import javafx.scene.control.{Alert, DialogEvent}

object Alerts {

  def loseAlert(): Unit ={
    val alert = new Alert(Alert.AlertType.INFORMATION, "Você perdeu o jogo!")
    alert.setTitle(null)
    alert.setHeaderText(null)
    alert.setOnHidden((evt: DialogEvent) => Platform.exit())
    alert.show()
  }
  def winnerAlert(): Unit ={
    val alert = new Alert(Alert.AlertType.INFORMATION, "Você ganhou o jogo!")
    alert.setTitle(null)
    alert.setHeaderText(null)
    alert.setOnHidden((evt: DialogEvent) => Platform.exit())
    alert.show()
  }
}

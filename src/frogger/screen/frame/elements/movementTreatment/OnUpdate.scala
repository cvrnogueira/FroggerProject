package frogger.screen.frame.elements.movementTreatment

import frogger.screen.frame.elements.firstOrderFunctions.FirstOrderFunctions
import frogger.screen.frame.elements.frog.Frog
import frogger.screen.frame.elements.gameHelpers.alerts.Alerts
import frogger.screen.frame.elements.gameHelpers.managers.{MusicManager, globalManager}
import frogger.screen.frame.elements.player.PlayerStatus
import javafx.animation.AnimationTimer
import javafx.scene.Node
import javafx.stage.Stage

import scala.collection.mutable

object OnUpdate {


  def checkCollisionReturnPlayerState(carList: mutable.ListBuffer[Node], frog: Node, stage: Stage): PlayerStatus.Value = {
    carList.filter(car => car.getTranslateX > stage.getWidth).map(car => car.setTranslateX(0))
    carList.map(car => car.setTranslateX(car.getTranslateX + Math.random() * 10))
    checkState(carList, frog)
  }
  def winnerCheck(frog: Node, timer: AnimationTimer): Unit ={
    val dx = 0
    val dy = 0
    if (!Frog.moveFrog(dx, dy, frog)) {
      timer.stop()
      MusicManager.playMusic(PlayerStatus.WINNER)
      Alerts.winnerAlert
    }
  }
  private def checkState(carList: mutable.Buffer[Node], frog: Node): PlayerStatus.Value = {
    if (carList.isEmpty) PlayerStatus.STILL_ON_GAME
    else {
      if (carList.head.getBoundsInParent.intersects(frog.getBoundsInParent)) {
        PlayerStatus.LOSER
      }
      else {
        checkState(carList.tail, frog)
      }
    }
  }

}

package frogger.screen.frame.elements.movementTreatment

import frogger.screen.frame.elements.player.PlayerStatus
import javafx.scene.Node
import javafx.stage.Stage

import scala.collection.mutable

object onUpdate {


  def onUpdate(carList: mutable.ListBuffer[Node], frog: Node, stage: Stage): PlayerStatus.Value = {
    carList.filter(car => car.getTranslateX > stage.getWidth).map(car => car.setTranslateX(0))
    carList.map(car => car.setTranslateX(car.getTranslateX + Math.random() * 10))
    checkState(carList, frog)
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

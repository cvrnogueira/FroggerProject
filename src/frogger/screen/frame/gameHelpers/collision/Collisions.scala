package frogger.screen.frame.gameHelpers.collision

import frogger.screen.frame.elements.frog.Frog
import frogger.screen.frame.elements.player.PlayerStatus
import javafx.scene.Node
import javafx.stage.Stage

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable

object Collisions {


  def onUpdate(carList: java.util.ArrayList[Node], frog: Frog, stage: Stage):  PlayerStatus.Value = {
    carList.filter(car =>car.getTranslateX > stage.getWidth).map(car => car.setTranslateX(0))
    carList.map(car => car.setTranslateX(car.getTranslateX + Math.random() * 10 ))
    checkState(carList, frog)
  }

  private def checkState(carList: mutable.Buffer[Node], frog: Frog): PlayerStatus.Value = {
    if(carList.isEmpty)  PlayerStatus.STILL_ON_GAME
    else{
      if( carList.head.getBoundsInParent.intersects(frog.getFrog().getBoundsInParent)){
        PlayerStatus.LOSER
      }
      else{
        checkState(carList.tail, frog)
      }
    }
  }

}

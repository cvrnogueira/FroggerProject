package frogger.screen.frame.elements.frog

import frogger.screen.frame.elements.gameHelpers.PositionCalculator
import javafx.scene.Node
import javafx.scene.input.KeyCode

object Frog {

  def setFrog(frog:Node): Node ={
    if(frog == null) throw new Exception("Erro no jogo, tente jogar novamente!")
     frog
  }

  def moveFrog(dx: Int, dy: Int, frog: Node): Boolean = {
    val boundsInScene = frog.localToScene(frog.getBoundsInLocal)
    if (boundsInScene.getMinY > 10) {
      PositionCalculator.moveFrog(frog, dx,dy)
      return true
    }
    false
  }

  def moveFrog(x: Double, y: Double, frog:Node): Unit = {
    PositionCalculator.moveFrog(frog, x)(y)
  }

  def switchFrog(keyCode: KeyCode): Unit = {
    PositionCalculator.switchPosition(keyCode)
  }

  def setLastKeyPressedToFalse(): Unit = {
    PositionCalculator.setFalseToLastKeyActive()
  }

  def switchFrogPositionAndImage(keyCode: KeyCode): Unit = {
    PositionCalculator.switchDirectionAndImage(keyCode)
  }

}

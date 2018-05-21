package frogger.screen.frame.elements.frog

import frogger.screen.frame.gameHelpers.PositionCalculator
import javafx.scene.Node
import javafx.scene.input.KeyCode

class Frog(var frog: Node) {

  def getFrog(): Node ={
    if(frog == null) throw new Exception("Erro no jogo, tente jogar novamente!")
    return frog
  }
  def moveFrog(dx: Int, dy: Int): Boolean = {
    val boundsInScene = frog.localToScene(frog.getBoundsInLocal)
    if (boundsInScene.getMinY > 10) {
      PositionCalculator.moveFrog(frog, dx,dy)
      return true
    }
    return false
  }

  def moveFrog(x: Double, y: Double): Unit = {
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

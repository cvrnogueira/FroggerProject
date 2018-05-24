package frogger.screen.frame.elements.frog

import frogger.screen.frame.elements.UI.frameHelpers.ImageViewConstant
import frogger.screen.frame.elements.gameHelpers.managers.globalManager
import frogger.screen.frame.elements.movementTreatment.PositionCalculator
import javafx.scene.Node
import javafx.scene.image.{Image, ImageView}
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

  def switchFrog(keyCode: KeyCode): Unit = {
    PositionCalculator.switchPosition(keyCode)
  }

  def setLastKeyPressedToFalse(): Unit = {
    PositionCalculator.setFalseToLastKeyActive()
  }

  def switchFrogPositionAndImage(keyCode: KeyCode): Unit = {
    PositionCalculator.switchDirectionAndImage(keyCode)
  }

  def initializeFrog(): Node ={
    val frog = setPersonageImage()
    moveFrog(globalManager.W / 2, globalManager.H - 100, frog)
    frog
  }
  private def moveFrog(x: Double, y: Double, frog:Node): Unit = {
    PositionCalculator.moveFrog(frog, x)(y)
  }
  private def setPersonageImage(): Node = {
    val personageImage = new Image(globalManager.FROG_UP)
    ImageViewConstant.frogImg = new ImageView(personageImage)
    val personage = ImageViewConstant.frogImg
    personage
  }

}

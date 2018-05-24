package frogger.screen.frame.elements.UI.frameHelpers

import java.net.URL
import java.util.ResourceBundle

import frogger.screen.frame.elements.UI.map.GameMap
import javafx.fxml.{FXMLLoader, Initializable}
import javafx.scene.layout.AnchorPane

class GameFrame extends AnchorPane with Initializable {

  val fxmlLoader: FXMLLoader = new FXMLLoader(
    getClass.getResource("GameFrame.fxml"))

  fxmlLoader.setRoot(this)

  fxmlLoader.setController(this)

  fxmlLoader.load()

  private def generateMap(): Unit = {
    getChildren.add(new GameMap())
  }

  override def initialize(location: URL, resources: ResourceBundle): Unit = {
    try generateMap()
    catch {
      case e: Exception => e.printStackTrace()

    }
  }

}
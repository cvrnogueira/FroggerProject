package frogger.screen.frame.elements.gameHelpers.labels

import frogger.screen.frame.elements.gameHelpers.managers.globalManager
import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.layout.{AnchorPane, Background, BackgroundFill, CornerRadii}
import javafx.scene.paint.Color

object LivesRemaingLabel {

   def livesRemainingPanel(anchor: AnchorPane, livesRemaining: Label): Unit = {
    AnchorPane.setTopAnchor(livesRemaining, 50.0)
    AnchorPane.setRightAnchor(livesRemaining, 50.0)
     livesRemaining.setText(new StringBuilder().append("Vidas Restantes: "+ globalManager.livesRemaing).toString())
    livesRemaining.setTextFill(Color.web("#0076a3"))
    livesRemaining.setScaleY(1.5)
    livesRemaining
      .backgroundProperty()
      .setValue(
        new Background(
          new BackgroundFill(Color.CORNFLOWERBLUE,
            CornerRadii.EMPTY,
            Insets.EMPTY)))
    anchor.toFront()
    anchor.getChildren.add(livesRemaining)
  }

}

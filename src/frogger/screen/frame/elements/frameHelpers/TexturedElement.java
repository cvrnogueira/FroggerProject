package frogger.screen.frame.elements.frameHelpers;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class TexturedElement extends Pane {

    public TexturedElement(double width, double height) {
        super();

        this.setPrefHeight(height);
        this.setPrefWidth(width);
    }

    protected void setTexture(String path, int width, int height) {
        Image image = new Image(path);
        BackgroundSize backgroundSize = new BackgroundSize(width, height, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
    }

}

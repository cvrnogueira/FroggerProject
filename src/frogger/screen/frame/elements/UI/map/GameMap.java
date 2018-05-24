package frogger.screen.frame.elements.UI.map;

import frogger.screen.frame.elements.UI.frameHelpers.TexturedElement;
import frogger.screen.frame.elements.car.Car;
import frogger.screen.frame.elements.UI.sidewalk.Sidewalk;
import frogger.screen.frame.elements.UI.street.Street;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameMap extends VBox {

    private List<TexturedElement> places;

    private Car car;

    public GameMap() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameMap.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();

        places = new ArrayList<>();

        addPlaces();

        printPlaces();
    }

    private void printPlaces() {
        for(TexturedElement place : places)
            getChildren().add(place);
    }

    private void addPlaces() {
        places.add(new Sidewalk());
        places.add(new Street(1));
        places.add(new Street(1));
        places.add(new Street(1));
        places.add(new Street(1));
        places.add(new Street(1));
        places.add(new Street(1));
        places.add(new Sidewalk());
        places.add(new Sidewalk());
    }

}

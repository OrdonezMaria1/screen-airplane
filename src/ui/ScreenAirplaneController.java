package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Flight;
import model.ScreenAirplane;

public class ScreenAirplaneController {

    @FXML
    private TextField answer;

    @FXML
    private TextField answer1;

    @FXML
    private Pane pane;

	private ScreenAirplane screenAirplane;

    @FXML
    void after(ActionEvent event) {

    }

    @FXML
    void airline(ActionEvent event) {
    	
    }

    @FXML
    void behing(ActionEvent event) {

    }

    @FXML
    void boarding(ActionEvent event) {

    }

    @FXML
    void date(ActionEvent event) {

    }

    @FXML
    void destinationCity(ActionEvent event) {

    }

    @FXML
    public void generate(ActionEvent event) throws IOException {
    	
    	int cant = Integer.parseInt(answer1.getText());
    	screenAirplane = new ScreenAirplane(cant);
    	GridPane gridPane = new GridPane();
    	pane.getChildren().add(gridPane);
    	Flight current = screenAirplane.getfirFlights();
    	gridPane.add(new Label("	Date		Time		Airline		NumFlight		Destination City  BoardingGate"), 0, 0);
    	gridPane.add(new Label (""), 0, 1);
    	int i = 2;
    	while(current != null) {
    		gridPane.add(new Label(""+current.toString()), 0, i);
			current =current.getNext();
			i++;
    	}
    }
    

    @FXML
    void hour(ActionEvent event) {

    }

    @FXML
    void numFlight(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void sorting(ActionEvent event) {

    }

}

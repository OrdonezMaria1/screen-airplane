package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
    	int num =Integer.parseInt(answer1.getText());
    	screenAirplane = new ScreenAirplane(num);
    	screenAirplane.createFlight(num);
    	GridPane gridPane = new GridPane();
    	pane.getChildren().add(gridPane);
    	
    	for(int j = 0; j<1; j++) {
    		for(int k = 0; k<num; k++) {
    			gridPane.add(new Label(""+screenAirplane.getFlights()[j].toString()+"        "),1,k);
    		}
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

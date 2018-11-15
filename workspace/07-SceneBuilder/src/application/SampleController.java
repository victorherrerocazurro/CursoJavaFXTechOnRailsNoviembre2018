package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class SampleController {
	@FXML
	private BorderPane root;

	@FXML
	public void procesarPulsarBoton(ActionEvent event){
		System.out.println("Procesando el click sobre el boton");
	}
}

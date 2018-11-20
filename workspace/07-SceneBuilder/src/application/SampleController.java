package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class SampleController implements Initializable {
	//El objeto le recibimos por inyeccion, no somo responsables de construirlo
	@FXML
	private BorderPane root;// = new BorderPane();

	@FXML
	public void procesarPulsarBoton(ActionEvent event){
		System.out.println("Procesando el click sobre el boton");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}

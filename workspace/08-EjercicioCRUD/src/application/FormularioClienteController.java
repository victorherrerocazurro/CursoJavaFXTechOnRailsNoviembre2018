package application;

import application.back.Service;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class FormularioClienteController {

	@FXML
	private BorderPane borderPane = new BorderPane();

	private Service service;

	public void setService(Service service) {
		this.service = service;
	}

}

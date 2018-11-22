package application.front;

import application.back.Service;
import application.back.entities.Cliente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FormularioClienteController {

	@FXML
	private Button procesarFormulario;

	@FXML
	private TextField idCliente;

	private Service service;

	public void setService(Service service) {
		this.service = service;
	}

	public void prepararFormualrioParaEdicion(){
		idCliente.setDisable(true);
		procesarFormulario.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//TODO
				Cliente cliente = null;
				service.editarCliente(cliente );

			}
		});
	}

}

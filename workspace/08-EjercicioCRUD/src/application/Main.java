package application;

import java.util.HashMap;
import java.util.ResourceBundle;

import application.back.MemoriaClienteDao;
import application.back.SimpleService;
import application.back.entities.Cliente;
import application.front.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			ResourceBundle mensajes = ResourceBundle.getBundle("/application/front/mensajes");

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"), mensajes);

			Parent root = fxmlLoader.load();

			/*Desde Aqui*/

			HashMap<Long, Cliente> tablaClientes = new HashMap<>();

			MemoriaClienteDao clienteDao = new MemoriaClienteDao(tablaClientes);

			/*Fuesen instancias ocultas, no referenciadas desde otro sitio que no sea el servicio*/

			SimpleService service = new SimpleService(clienteDao);

			MainController mainController = (MainController)fxmlLoader.getController();

			mainController.setService(service);

			/*FormularioClienteController controller = (FormularioClienteController) fxmlLoader.getController();

			//Se puede delegar en un framework como Spring

			controller.setService(service);*/

			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package application;


import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			Button button = new Button("Dialogo");

			button.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Alert alert = new Alert(AlertType.INFORMATION);

					//alert.setHeaderText("Cabecera");
					alert.setHeaderText(null);
					alert.setContentText("contenido");

					alert.show();
				}
			});

			Button buttonConfirmation = new Button("Dialogo");

			buttonConfirmation.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Alert alert = new Alert(AlertType.CONFIRMATION);

					//alert.setHeaderText("Cabecera");
					alert.setHeaderText(null);
					alert.setContentText("contenido");

					Optional<ButtonType> resultado = alert.showAndWait();

					if(resultado.get().equals(ButtonType.CANCEL)){
						System.out.println("La peticion no ha sido aceptada");
					}
				}
			});

			Button buttonCustomAlert = new Button("Dialogo");

			buttonCustomAlert.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Alert alert = new Alert(AlertType.INFORMATION);

					alert.setHeaderText(null);
					alert.setContentText("contenido");

					alert.getButtonTypes().clear();

					alert.getButtonTypes().addAll(ButtonType.CANCEL, new ButtonType("Personalizado"));

					Optional<ButtonType> resultado = alert.showAndWait();

					if(resultado.get().equals(ButtonType.CANCEL)){
						System.out.println("La peticion no ha sido aceptada");
					}
				}
			});

			Button buttonCustomContent = new Button("Dialogo");

			buttonCustomContent.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Alert alert = new Alert(AlertType.INFORMATION);

					alert.getDialogPane().getChildren().clear();

					//TODO Mirar porque no mustra el Label
					alert.getDialogPane().getChildren().add(new Label("Etiqueta custom"));

				    alert.showAndWait();
				}
			});

			Button buttonChoice = new Button("Dialogo");

			buttonChoice.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					ChoiceDialog<String> choiceDialog = new ChoiceDialog<>("Uno", "Dos", "Tres");

					Optional<String> resultado = choiceDialog.showAndWait();

					System.out.println(resultado);
				}
			});

			VBox root = new VBox();

			root.getChildren().addAll(button,buttonConfirmation, buttonCustomAlert, buttonCustomContent, buttonChoice);

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

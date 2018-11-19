package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = new StackPane();
			Button button = new Button("Boton principal");
			button.setOnAction( e -> {
				Stage subStage = new Stage();

				StackPane root1 = new StackPane();
				Button button1 = new Button("Boton en Escena 1");
				root1.getChildren().add(button1);
				Scene scene1 = new Scene(root1,400,400);

				StackPane root2 = new StackPane();
				Button button2 = new Button("Boton En Escena 2");
				root2.getChildren().add(button2);
				Button button3 = new Button("Boton cambiar arbol");
				root2.getChildren().add(button3);
				Scene scene2 = new Scene(root2,400,400);

				button1.setOnAction(ev -> {
					subStage.setScene(scene2);
				});

				button2.setOnAction(ev -> {
					subStage.setScene(scene1);
				});

				button3.setOnAction(ev -> {
					root2.getChildren().clear();
					root2.getChildren().addAll(button2, new Label("texto"));
				});

				subStage.setScene(scene1);
				subStage.initModality(Modality.APPLICATION_MODAL);
				subStage.initOwner(primaryStage);
				subStage.show();
			});
			root.getChildren().add(button);
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

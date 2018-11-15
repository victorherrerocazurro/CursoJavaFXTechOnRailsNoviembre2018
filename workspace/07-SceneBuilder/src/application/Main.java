package application;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
        	Locale.setDefault(new Locale("es_ES"));

            ResourceBundle mensajes = ResourceBundle.getBundle("/application/mensajes", new Locale("en"));

            ResourceBundle mensajes1 = ResourceBundle.getBundle("/application/mensajes");

			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"),mensajes);
            setUserAgentStylesheet(STYLESHEET_CASPIAN);
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

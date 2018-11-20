package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class Main extends Application {

	 private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();

			//Es el mismo caso que File
			Media media = new Media(Main.class.getResource("oow2010-2.flv").toExternalForm());

			MediaPlayer mediaPlayer = new MediaPlayer(media);

			mediaPlayer.setAutoPlay(true);

			MediaView mediaView = new MediaView(mediaPlayer);

			root.getChildren().add(mediaView);

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

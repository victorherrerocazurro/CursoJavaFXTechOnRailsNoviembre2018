package application;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();

			Rectangle rectangle = new Rectangle(100, 100, Color.RED);

			rectangle.setTranslateX(100);
			rectangle.setTranslateY(100);
			rectangle.setRotate(45);

			rectangle.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					rectangle.setScaleX(2);
					rectangle.setScaleY(2);
				}
			});

			rectangle.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					rectangle.setScaleX(1);
					rectangle.setScaleY(1);
				}
			});

			rectangle.getTransforms().add(new Shear(2, 2));

			/*
			 * FadeTransition ft = new FadeTransition(Duration.millis(3000),
			 * rectangle); ft.setFromValue(1.0); ft.setToValue(0.1);
			 * ft.setCycleCount(Timeline.INDEFINITE); ft.setAutoReverse(true);
			 * ft.play();
			 *
			 * Path path = new Path(); path.getElements().add(new
			 * MoveTo(20,20)); path.getElements().add(new CubicCurveTo(380, 0,
			 * 380, 120, 200, 120)); path.getElements().add(new CubicCurveTo(0,
			 * 120, 0, 240, 380, 240));
			 *
			 * PathTransition pathTransition = new PathTransition();
			 * pathTransition.setDuration(Duration.millis(4000));
			 * pathTransition.setPath(path); pathTransition.setNode(rectangle);
			 * pathTransition.setOrientation(PathTransition.OrientationType.
			 * ORTHOGONAL_TO_TANGENT);
			 * pathTransition.setCycleCount(Timeline.INDEFINITE);
			 * pathTransition.setAutoReverse(true); pathTransition.play();
			 */

			FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), rectangle);
			fadeTransition.setFromValue(1.0f);
			fadeTransition.setToValue(0.3f);
			fadeTransition.setCycleCount(1);
			fadeTransition.setAutoReverse(true);

			TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), rectangle);
			translateTransition.setFromX(50);
			translateTransition.setToX(375);
			translateTransition.setCycleCount(1);
			translateTransition.setAutoReverse(true);

			RotateTransition rotateTransition = new RotateTransition(Duration.millis(2000), rectangle);
			rotateTransition.setByAngle(180f);
			rotateTransition.setCycleCount(4);
			rotateTransition.setAutoReverse(true);

			ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), rectangle);
			scaleTransition.setFromX(1);
			scaleTransition.setFromY(1);
			scaleTransition.setToX(2);
			scaleTransition.setToY(2);
			scaleTransition.setCycleCount(1);
			scaleTransition.setAutoReverse(true);

			SequentialTransition sequentialTransition = new SequentialTransition();
			sequentialTransition.getChildren().addAll(fadeTransition, translateTransition, rotateTransition,
					scaleTransition);
			sequentialTransition.setCycleCount(Timeline.INDEFINITE);
			sequentialTransition.setAutoReverse(true);

			sequentialTransition.play();

			root.getChildren().addAll(rectangle);

			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

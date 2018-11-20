package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();

			Rectangle rectangle = new Rectangle(100, 100, Color.AQUA);

			Path path = new Path(new MoveTo(150, 150), new LineTo(300, 300),
					new ArcTo(100.0, 50.0, 0.0, 300.0, 200.0, false, false), new HLineTo(500));

			SVGPath svg = new SVGPath();
			svg.setContent("M150 0 L75 200 L225 200 Z");


			// Drawing Circle1
			Circle circle1 = new Circle(250.0f,135.0f,100.0f,Color.DARKSLATEBLUE);

			// Drawing Circle2
			Circle circle2 = new Circle(350.0f,135.0f,100.0f,Color.BLUE);

			// Performing union operation on the circle
			Shape shape = Shape.union(circle1, circle2);

			// Setting the fill color to the result
			shape.setFill(Color.DARKSLATEBLUE);

			Shape resta = Shape.subtract(circle1, circle2);

			// Setting the fill color to the result
			resta.setFill(Color.YELLOW);

			Shape interseccion = Shape.intersect(circle1, circle2);

			// Setting the fill color to the result
			interseccion.setFill(Color.RED);

			resta.setOnMouseEntered(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					resta.setFill(Color.BROWN);

				}
			});

			resta.setOnMouseExited(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					resta.setFill(Color.YELLOW);

				}
			});


			Group group = new Group();

			group.getChildren().addAll(rectangle, path, svg, shape, resta, interseccion);

			root.getChildren().add(group);

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

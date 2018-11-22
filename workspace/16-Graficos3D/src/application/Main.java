package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class Main extends Application {

	private static final double CAMERA_INITIAL_DISTANCE = -100;
    private static final double CAMERA_INITIAL_X_ANGLE = 70.0;
    private static final double CAMERA_INITIAL_Y_ANGLE = 320.0;
    private static final double CAMERA_NEAR_CLIP = 0.1;
    private static final double CAMERA_FAR_CLIP = 10000.0;

	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();

			final PhongMaterial redMaterial = new PhongMaterial();
			redMaterial.setSpecularColor(Color.ORANGE);
			redMaterial.setDiffuseColor(Color.RED);

			final PhongMaterial blueMaterial = new PhongMaterial();
			blueMaterial.setDiffuseColor(Color.BLUE);
			blueMaterial.setSpecularColor(Color.LIGHTBLUE);

			final PhongMaterial greyMaterial = new PhongMaterial();
			greyMaterial.setDiffuseColor(Color.DARKGREY);
			greyMaterial.setSpecularColor(Color.GREY);

			final Box red = new Box(400, 400, 400);
			red.setMaterial(redMaterial);

			final Sphere blue = new Sphere(200);
			blue.setMaterial(blueMaterial);

			final Cylinder grey = new Cylinder(5, 100);
			grey.setMaterial(greyMaterial);

			Group group = new Group();

			group.getChildren().addAll(red, blue, grey);

			root.getChildren().add(group);

			PerspectiveCamera camera = new PerspectiveCamera(false);

			//camera.setNearClip(CAMERA_NEAR_CLIP);
	        //camera.setFarClip(CAMERA_FAR_CLIP);
	        //camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);

			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			scene.setCamera(camera);

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

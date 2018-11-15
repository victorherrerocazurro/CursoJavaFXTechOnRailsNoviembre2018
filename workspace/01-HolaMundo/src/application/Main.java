package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			Label label1 = new Label("Etiqueta 1");
			Label label2 = new Label("Etiqueta 2");
			Label label3 = new Label("Etiqueta 3");
			Label label4 = new Label("Etiqueta 4");
			Label label5 = new Label("Etiqueta 5");

			Image image = new Image(getClass().getResourceAsStream("/application/Java_Logo.png"));
			label1.setGraphic(new ImageView(image));
			label1.setTextFill(Color.web("#0076a3"));

			label2.setRotate(45);

			ToggleGroup group = new ToggleGroup();

			ToggleButton tb1 = new ToggleButton("Minor");
			tb1.setToggleGroup(group);
			tb1.setSelected(true);

			ToggleButton tb2 = new ToggleButton("Major");
			tb2.setToggleGroup(group);

			ToggleButton tb3 = new ToggleButton("Critical");
			tb3.setToggleGroup(group);

			group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
			    public void changed(ObservableValue<? extends Toggle> ov,
			        Toggle toggle, Toggle new_toggle) {
			    		System.out.println("Old: " + toggle + ", new: " + new_toggle);
			         }
			});

			CheckBox cb1 = new CheckBox();
			cb1.setText("First");
			cb1.setSelected(true);
			cb1.setAllowIndeterminate(true);

			label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
			    @Override public void handle(MouseEvent e) {
			        label3.setScaleX(1.5);
			        label3.setScaleY(1.5);
			    }
			});

			label3.setOnMouseExited(new EventHandler<MouseEvent>() {
			    @Override public void handle(MouseEvent e) {
			        label3.setScaleX(1);
			        label3.setScaleY(1);
			    }
			});

			Button button = new Button("Pulsa");

			HBox top = new HBox(label1, label2);

			VBox left = new VBox(label3, label4, tb1, tb2, tb3,cb1);

			StackPane center = new StackPane(label5, button);

			root.setTop(top);
			root.setLeft(left);
			root.setCenter(center);

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

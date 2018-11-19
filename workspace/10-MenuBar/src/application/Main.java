package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	private Label label;

	@Override
	public void start(Stage stage) {
		try {
			stage.setTitle("Menu Sample");
			Scene scene = new Scene(new VBox(), 400, 350);
			scene.setFill(Color.OLDLACE);

			MenuBar menuBar = new MenuBar();
			label = new Label("");


			// --- Menu File
			Menu menuFile = new Menu("File");
			MenuItem add = new MenuItem("Add", new ImageView(new Image("/application/Java_Logo.png")));
			add.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent t) {
					label.setText("Se pulso la opcion de Add");
				}
			});
			MenuItem clear = new MenuItem("Clear");
			clear.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
			clear.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent t) {
					label.setText("");
				}
			});

			menuFile.getItems().addAll(add, clear);

			// --- Menu Edit
			Menu menuEdit = new Menu("Edit");

			Menu menuEffect = new Menu("Picture Effect");

			ToggleGroup groupEffect = new ToggleGroup();

			RadioMenuItem opcion1 = new RadioMenuItem("Opcion1");
			opcion1.setToggleGroup(groupEffect);

			RadioMenuItem opcion2 = new RadioMenuItem("Opcion2");
			opcion2.setToggleGroup(groupEffect);

		    menuEffect.getItems().addAll(opcion1, opcion2);

			MenuItem noEffects = new MenuItem("No Effects");

			menuEdit.getItems().addAll(menuEffect, noEffects);

			// --- Menu View
			Menu menuView = new Menu("View");

			CheckMenuItem titleView = createMenuItem ("Title");
			CheckMenuItem binNameView = createMenuItem ("Binomial name");
			CheckMenuItem picView = createMenuItem ("Picture");
			CheckMenuItem descriptionView = createMenuItem ("Description");

			menuView.getItems().addAll(titleView, binNameView, picView, descriptionView);

			menuBar.getMenus().addAll(menuFile, menuEdit, menuView);

			((VBox) scene.getRoot()).getChildren().addAll(menuBar, label);

			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private CheckMenuItem createMenuItem (String title){
	    CheckMenuItem cmi = new CheckMenuItem(title);
	    cmi.setSelected(true);
	    cmi.selectedProperty().addListener(new ChangeListener<Boolean>() {
	        public void changed(ObservableValue ov,
	        Boolean old_val, Boolean new_val) {
	            label.setText("Se ha seleccionado: " + title + " a " + new_val);
	        }
	    });
	    return cmi;
	}

	public static void main(String[] args) {
		launch(args);
	}
}

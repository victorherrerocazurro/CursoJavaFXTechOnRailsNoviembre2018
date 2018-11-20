package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(new Browser(),400,400);
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

class Browser extends Region {
	   private HBox toolBar;

	   private static String[] imageFiles = new String[]{
	        "Java_Logo.png",
	        "Java_Logo.png",
	        "Java_Logo.png",
	        "Java_Logo.png",
	        "Java_Logo.png"
	    };
	    private static String[] captions = new String[]{
	        "Products",
	        "Blogs",
	        "Documentation",
	        "Partners",
	        "Help"
	    };

	    private static String[] urls = new String[]{
	        "http://www.oracle.com/products/index.html",
	        "http://blogs.oracle.com/",
	        "http://docs.oracle.com/javase/index.html",
	        "http://www.oracle.com/partners/index.html",
	        Main.class.getResource("help.html").toExternalForm()
	    };

	    final ImageView selectedImage = new ImageView();
	    final Hyperlink[] hpls = new Hyperlink[captions.length];
	    final Image[] images = new Image[imageFiles.length];
	    final WebView browser = new WebView();
	    final WebEngine webEngine = browser.getEngine();

	    public Browser() {
	        //apply the styles
	        getStyleClass().add("browser");

	        for (int i = 0; i < captions.length; i++) {
	            final Hyperlink hpl = hpls[i] = new Hyperlink(captions[i]);
	            Image image = images[i] =
	                new Image(getClass().getResourceAsStream(imageFiles[i]));
	            hpl.setGraphic(new ImageView (image));
	            final String url = urls[i];

	            hpl.setOnAction(new EventHandler<ActionEvent>() {
	                @Override
	                public void handle(ActionEvent e) {
	                    webEngine.load(url);
	                }
	            });
	        }

	     // process page loading
	        webEngine.getLoadWorker().stateProperty().addListener(
	            new ChangeListener<State>() {
	                @Override
	                public void changed(ObservableValue<? extends State> ov,
	                    State oldState, State newState) {
	                    if (newState == State.SUCCEEDED) {
	                            JSObject win = (JSObject) webEngine.executeScript("window");
	                            win.setMember("app", new JavaApp());
	                        }
	                    }
	                }
	        );

	        // load the home page
	        webEngine.load("http://www.oracle.com/products/index.html");

	        // create the toolbar
	        toolBar = new HBox();
	        toolBar.getStyleClass().add("browser-toolbar");
	        toolBar.getChildren().addAll(hpls);

	        //add components
	        getChildren().add(toolBar);
	        getChildren().add(browser);
	    }

	    private Node createSpacer() {
	        Region spacer = new Region();
	        HBox.setHgrow(spacer, Priority.ALWAYS);
	        return spacer;
	    }

	    @Override protected void layoutChildren() {
	        double w = getWidth();
	        double h = getHeight();
	        double tbHeight = toolBar.prefHeight(w);
	        layoutInArea(browser,0,0,w,h-tbHeight,0, HPos.CENTER, VPos.CENTER);
	        layoutInArea(toolBar,0,h-tbHeight,w,tbHeight,0,HPos.CENTER,VPos.CENTER);
	    }

	    @Override protected double computePrefWidth(double height) {
	        return 750;
	    }

	    @Override protected double computePrefHeight(double width) {
	        return 500;
	    }

	    public class JavaApp {
	        public void exit() {
	            Platform.exit();
	        }
	    }
	}

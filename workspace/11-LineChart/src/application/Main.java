package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		stage.setTitle("Line Chart Sample");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Month");

		//LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
		//StackedAreaChart<String,Number> lineChart = new StackedAreaChart<String,Number>(xAxis,yAxis);
		//StackedBarChart<String, Number> lineChart = new StackedBarChart<String, Number>(xAxis, yAxis);
		BarChart<String, Number> lineChart = new BarChart<String, Number>(xAxis, yAxis);


		lineChart.setTitle("Stock Monitoring, 2010");

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("Portfolio 1");

		series1.getData().add(new XYChart.Data("Jan", 23));
		series1.getData().add(new XYChart.Data("Feb", 14));
		series1.getData().add(new XYChart.Data("Mar", 15));
		series1.getData().add(new XYChart.Data("Apr", 24));
		series1.getData().add(new XYChart.Data("May", 34));
		series1.getData().add(new XYChart.Data("Jun", 36));
		series1.getData().add(new XYChart.Data("Jul", 22));
		series1.getData().add(new XYChart.Data("Aug", 45));
		series1.getData().add(new XYChart.Data("Sep", 43));
		series1.getData().add(new XYChart.Data("Oct", 17));
		series1.getData().add(new XYChart.Data("Nov", 29));
		series1.getData().add(new XYChart.Data("Dec", 25));

		XYChart.Series series2 = new XYChart.Series();
		series2.setName("Portfolio 2");
		series2.getData().add(new XYChart.Data("Jan", 33));
		series2.getData().add(new XYChart.Data("Feb", 34));
		series2.getData().add(new XYChart.Data("Mar", 25));
		series2.getData().add(new XYChart.Data("Apr", 44));
		series2.getData().add(new XYChart.Data("May", 39));
		series2.getData().add(new XYChart.Data("Jun", 16));
		series2.getData().add(new XYChart.Data("Jul", 55));
		series2.getData().add(new XYChart.Data("Aug", 54));
		series2.getData().add(new XYChart.Data("Sep", 48));
		series2.getData().add(new XYChart.Data("Oct", 27));
		series2.getData().add(new XYChart.Data("Nov", 37));
		series2.getData().add(new XYChart.Data("Dec", 29));

		XYChart.Series series3 = new XYChart.Series();
		series3.setName("Portfolio 3");
		series3.getData().add(new XYChart.Data("Jan", 44));
		series3.getData().add(new XYChart.Data("Feb", 35));
		series3.getData().add(new XYChart.Data("Mar", 36));
		series3.getData().add(new XYChart.Data("Apr", 33));
		series3.getData().add(new XYChart.Data("May", 31));
		series3.getData().add(new XYChart.Data("Jun", 26));
		series3.getData().add(new XYChart.Data("Jul", 22));
		series3.getData().add(new XYChart.Data("Aug", 25));
		series3.getData().add(new XYChart.Data("Sep", 43));
		series3.getData().add(new XYChart.Data("Oct", 44));
		series3.getData().add(new XYChart.Data("Nov", 45));
		series3.getData().add(new XYChart.Data("Dec", 44));

		final VBox vbox = new VBox();
		final HBox hbox = new HBox();

		final Button add = new Button("Add Series");

		add.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (lineChart.getData() == null)
					lineChart.setData(FXCollections.<XYChart.Series<String, Number>>observableArrayList());

				XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();

				series.setName("Portfolio " + (lineChart.getData().size() + 1));

				series.getData().add(new XYChart.Data("Jan", Math.random() * 100));
				series.getData().add(new XYChart.Data("Feb", Math.random() * 200));
				series.getData().add(new XYChart.Data("Mar", Math.random() * 300));
				series.getData().add(new XYChart.Data("Apr", Math.random() * 400));
				series.getData().add(new XYChart.Data("May", Math.random() * 500));
				series.getData().add(new XYChart.Data("Jun", Math.random() * 600));
				series.getData().add(new XYChart.Data("Jul", Math.random() * 700));
				series.getData().add(new XYChart.Data("Aug", Math.random() * 800));
				series.getData().add(new XYChart.Data("Sep", Math.random() * 900));
				series.getData().add(new XYChart.Data("Oct", Math.random() * 100));
				series.getData().add(new XYChart.Data("Nov", Math.random() * 200));
				series.getData().add(new XYChart.Data("Dec", Math.random() * 300));

				lineChart.getData().add(series);
			}
		});

		final Button remove = new Button("Remove Series");

		hbox.setSpacing(10);
		hbox.getChildren().addAll(add, remove);

		vbox.getChildren().addAll(lineChart, hbox);
		hbox.setPadding(new Insets(10, 10, 10, 50));

		Scene scene = new Scene(vbox, 800, 600);
		lineChart.getData().addAll(series1, series2, series3);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

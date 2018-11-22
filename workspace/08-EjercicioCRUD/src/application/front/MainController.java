package application.front;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import application.back.Service;
import application.back.entities.Cliente;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController implements Initializable {

	@FXML
	private Group icono;

	@FXML
	private StackPane contenido;

	private TableView<Cliente> tablaClientes;

	private Service service;

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Contruir la tabla de datos
		tablaClientes = new TableView<Cliente>();

		TableColumn idCol = new TableColumn("Id");
		idCol.setMinWidth(100);
		idCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("id"));

		TableColumn nombreCol = new TableColumn("Nombre");
		nombreCol.setMinWidth(100);
		nombreCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));

		TableColumn direccionCol = new TableColumn("Direccion");
		direccionCol.setMinWidth(200);
		direccionCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("direccion"));

		TableColumn telefonoCol = new TableColumn("Telefono");
		telefonoCol.setMinWidth(200);
		telefonoCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefono"));

		tablaClientes.getColumns().addAll(idCol, nombreCol, direccionCol, telefonoCol);
	}

	@FXML
	public void procesarMenuAltaCliente(ActionEvent event) throws IOException {
		mostrarFormularioCliente(false);

	}

	@FXML
	public void procesarMenuEdicionCliente(ActionEvent event) throws IOException {
		mostrarFormularioCliente(true);
	}

	private void mostrarFormularioCliente(boolean edicion) throws IOException {
		// Abrir una nueva ventana
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FormularioCliente.fxml"));

		Parent root = fxmlLoader.load();

		FormularioClienteController controller = (FormularioClienteController) fxmlLoader.getController();

		// Se puede delegar en un framework como Spring

		controller.setService(service);

		if (edicion) controller.prepararFormualrioParaEdicion();

		Stage ventanaFormularioAltaCliente = new Stage();

		Scene scene = new Scene(root, 400, 400);

		ventanaFormularioAltaCliente.setScene(scene);
		ventanaFormularioAltaCliente.initModality(Modality.APPLICATION_MODAL);
		ventanaFormularioAltaCliente.initOwner((Stage) contenido.getScene().getWindow());

		ventanaFormularioAltaCliente.show();
	}

	@FXML
	public void procesarMenuMostrarTablaClientes(ActionEvent event) {
		// Actualziar los datos de la tabla y añadir/quitar la tabla al arbol
		CheckMenuItem checkMenuItem = (CheckMenuItem)event.getSource();

		if (checkMenuItem.isSelected()){
			//Mostrar la tabla
			tablaClientes.setItems(FXCollections.observableArrayList(service.obtenerTodosLosCliente()));
			contenido.getChildren().add(tablaClientes);
		} else {
			contenido.getChildren().clear();
		}
	}

	@FXML
	public void procesarMenuCambiarIdiomaSpain(ActionEvent event) throws IOException {
		cambiarArbolScene(new Locale("es"));
	}

	@FXML
	public void procesarMenuCambiarIdiomaIngles(ActionEvent event) throws IOException {
		cambiarArbolScene(new Locale("en"));
	}

	private void cambiarArbolScene(Locale locale) throws IOException {
		// Realizar la recarga del FXML con el nuevo idioma
		ResourceBundle mensajes = ResourceBundle.getBundle("/application/front/mensajes", locale);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"),mensajes);
		Parent root = fxmlLoader.load();
		MainController mainController = (MainController)fxmlLoader.getController();

		mainController.setService(service);

		contenido.getScene().setRoot(root);
	}



	@FXML
	public void procesarMenuGraficaClientesPorDireccion(ActionEvent event) {
		// Abrir otra ventana con la grafica de clientes por direccion

		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Direccion");

		BarChart<String, Number> root = new BarChart<String, Number>(xAxis, yAxis);


		root.setTitle("Cliente Por Direccion");

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("2018");

		//Obtener daots de negocio del servicio
		Map<String, Integer> clientesPorDireccion = service.obtenerClientesPorDireccion();

		Collection<XYChart.Data> datos = UtilidadesGraficas.transformarMapEnXYChartData(clientesPorDireccion);

		series1.getData().addAll(datos);

		root.getData().addAll(series1);

		Stage ventanaGrafica = new Stage();

		Scene scene = new Scene(root, 400, 400);

		ventanaGrafica.setScene(scene);
		ventanaGrafica.initModality(Modality.APPLICATION_MODAL);
		ventanaGrafica.initOwner((Stage) contenido.getScene().getWindow());

		ventanaGrafica.show();
	}

}

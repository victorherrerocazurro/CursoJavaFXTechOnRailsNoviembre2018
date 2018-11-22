package application.front;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.scene.chart.XYChart.Data;

public class UtilidadesGraficas {

	public static Collection<Data> transformarMapEnXYChartData(Map<String, Integer> clientesPorDireccion) {
		return clientesPorDireccion.entrySet().stream()
		        .map(x -> new Data<>(x.getKey(), x.getValue()))
		        .collect(Collectors.toList());
	}

}

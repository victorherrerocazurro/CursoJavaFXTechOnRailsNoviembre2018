package application.back;

import java.util.Collection;

import application.back.entities.Cliente;

public interface Service {

	long registrarCliente(Cliente cliente);

	boolean editarCliente(Cliente cliente);

	Collection<Cliente> obtenerTodosLosCliente();

}

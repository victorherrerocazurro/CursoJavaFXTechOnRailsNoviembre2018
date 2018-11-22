package application.back;

import java.util.Collection;

import application.back.entities.Cliente;

public class SimpleService implements Service{

	private ClienteDao clienteDao;

	public SimpleService(ClienteDao clienteDao) {
		super();
		this.clienteDao = clienteDao;
	}

	@Override
	public long registrarCliente(Cliente cliente) {
		Long idAutogenerado = clienteDao.insert(cliente);
		return idAutogenerado;
	}

	@Override
	public boolean editarCliente(Cliente cliente) {
		Integer elementosActualziados = clienteDao.update(cliente);
		return elementosActualziados > 0;
	}

	@Override
	public Collection<Cliente> obtenerTodosLosCliente() {
		return clienteDao.select();
	}
}

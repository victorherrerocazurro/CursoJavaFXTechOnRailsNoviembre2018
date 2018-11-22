package application.back;

import java.util.Collection;
import java.util.Map;

import application.back.entities.Cliente;

public class MemoriaClienteDao implements ClienteDao {

	private Map<Long, Cliente> tablaClientes;

	public MemoriaClienteDao(Map<Long, Cliente> tablaClientes) {
		super();
		this.tablaClientes = tablaClientes;
	}

	@Override
	public Long insert(Cliente cliente) {
		tablaClientes.put(cliente.getId(), cliente);
		return cliente.getId();
	}

	@Override
	public Integer update(Cliente cliente) {
		Cliente resultado = tablaClientes.replace(cliente.getId(), cliente);
		return (resultado != null)? 1 : 0;
	}

	@Override
	public Collection<Cliente> select() {
		return tablaClientes.values();
	}
}

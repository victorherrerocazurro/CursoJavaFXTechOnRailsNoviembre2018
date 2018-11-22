package application.back;

import java.util.Collection;

import application.back.entities.Cliente;

public interface ClienteDao {

	Long insert(Cliente cliente);

	Integer update(Cliente cliente);

	Collection<Cliente> select();

}

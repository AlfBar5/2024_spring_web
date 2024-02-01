package service.interfaces;

import model.Cliente;

public interface ClientesService {
	
	
	Cliente autenticarCliente(String usuario, String password);
	
	boolean altaCliente(Cliente cliente);
	

}

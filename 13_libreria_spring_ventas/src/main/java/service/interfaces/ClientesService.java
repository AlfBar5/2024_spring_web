package service.interfaces;

import dtos.ClienteDto;
import model.Cliente;

public interface ClientesService {
	
	
	ClienteDto autenticarCliente(String usuario, String password);
	
	boolean altaCliente(ClienteDto cliente);
	

}

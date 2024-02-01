package service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import model.Cliente;
import service.interfaces.ClientesService;



//@Service para que SPRIM cree objetos de la clase ClientesServiceImpl (para que haga los new)
@Service
public class ClientesServiceImpl implements ClientesService {
	
	
	//inyectamos el dao ClientesDao
	@Autowired
	ClientesDao clientesDao;
	

	@Override
	public Cliente autenticarCliente(String usuario, String password) {
		
		//si no lo encuentra devuelve un null
		return clientesDao.findByUsuarioAndPassword(usuario, password);
				
	}

	
	@Override
	public boolean altaCliente(Cliente cliente) {
		//para que no se repitan usuarios, compruebo si existe
		if(clientesDao.findByUsuario(cliente.getUsuario())==null) {
			clientesDao.save(cliente);
			return true;
		}
		return false;
			
	}

}

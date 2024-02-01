package service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import dtos.ClienteDto;
import model.Cliente;
import service.interfaces.ClientesService;
import service.mappers.Mapeador;



//@Service para que SPRIM cree objetos de la clase ClientesServiceImpl (para que haga los new)
@Service
public class ClientesServiceImpl implements ClientesService {
	
	
	//inyectamos el dao ClientesDao
	//inyectamos el mapeador
	@Autowired
	ClientesDao clientesDao;
	@Autowired
	Mapeador mapeador;
	

	@Override
	public ClienteDto autenticarCliente(String usuario, String password) {
		
		//si no lo encuentra devuelve un null
		Cliente cliente=clientesDao.findByUsuarioAndPassword(usuario, password);
		
		//por si llega un cliente que no existe
		return cliente!=null?
				mapeador.clienteEntityToDto(clientesDao.findByUsuarioAndPassword(usuario, password))
				:null;
				
	}

	
	@Override
	public boolean altaCliente(ClienteDto cliente) {
		
		//para que no se repitan usuarios, compruebo si existe
		if(clientesDao.findByUsuario(cliente.getUsuario())==null) {
			
			clientesDao.save(mapeador.clienteDtoToEntity(cliente));
			return true;
		}
		return false;
			
	}

}

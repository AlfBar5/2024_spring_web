package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cliente;

public interface ClientesDao extends JpaRepository<Cliente,Integer >{
	
	//autentificar
	Cliente findByUsuarioAndPassword(String u, String p);
	
	//Comprobar si existe un usuario antes de darlo de alta
	Cliente findByUsuario(String usuario);
	
	//métodos que se necesitan pero los heredamos del JpaRepository 
	//no hace falta explicitarlos
	//necesitamos el alta del cliente
	//si ponemos @Override lo podemos sobreescribir, pero en este caso no hace falta
	
	//save(Cliente cliente);
	

}

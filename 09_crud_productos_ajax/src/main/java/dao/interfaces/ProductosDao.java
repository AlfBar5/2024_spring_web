package dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import model.Producto;

public interface ProductosDao extends JpaRepository<Producto, Integer> {

	//métodos simples de acceso a datos. Separa el model de la lógica de negocio (service)
	//	USANDO SPRING DATA JPA (para eliminar la implementación de la capa DAO)
	// solo necesitamos la interfaz (no la implementación de la capa DAO) 
	// simplificamos así el acceso a datos -->
	
	
	
	//Buscar por nombre
	Producto findByNombre(String nombre);
	
	//Buscar por categoría
	List<Producto> findByCategoria(String categoria);
		
	//Borrar productos por nombre Como es de acción hay que anotarlo
	@Transactional
	@Modifying
	void deleteByNombre(String nombre);
	
	
}

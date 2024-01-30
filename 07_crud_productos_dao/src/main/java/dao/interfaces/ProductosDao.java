package dao.interfaces;

import java.util.List;

import model.Producto;

public interface ProductosDao {

	//métodos simples de acceso a datos. Separa el model de la lógica de negocio (service)
	
	//GUARDAR
	void save(Producto producto);
	
	//Buscar todos
	List<Producto> todosProductos();
	
	//Buscar por nombre
	Producto findByNombre(String nombre);
	
	//Buscar por categoría
	List<Producto> findByCategoria(String categoria);
		
	//Actualizar precio producto
	void update(Producto producto);
	
	//Borrar producto
	void delete(Producto producto);
	
	//Borrar productos por categoria (no usado)
	void deleteByCategoria(String categoria);
	
	
}

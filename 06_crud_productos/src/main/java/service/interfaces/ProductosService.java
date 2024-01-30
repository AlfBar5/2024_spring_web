package service.interfaces;

import java.util.List;

import model.Producto;

public interface ProductosService {
	
	List<Producto> todosProductos();
	
	List<Producto> buscarPorCategoria(String categoria);
	
	boolean agregarProducto(Producto producto);
	
	void modificarPrecio(String nombre, double nuevoPrecio);
	
	//Devuelve el producto eliminado
	Producto eliminarProducto(String nombre);
	
	

}

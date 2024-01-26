package service.interfaces;

import java.util.List;

import model.Producto;

public interface ProductosService {
	
	
	List<Producto> buscarPorCategoria(String categoria);
	
	void agregarProducto(Producto producto);
	
	void eliminarProducto(String nombre);

}

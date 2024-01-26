package service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Producto;
import service.interfaces.ProductosService;

@Service
public class ProductosServiceImpl  implements ProductosService {

	private static List<Producto> productos=new ArrayList<>();
	
	@Override
	public List<Producto> buscarPorCategoria(String categoria) {
		return productos.stream()
				.filter(p->p.getCategoria().equals(categoria))
				.toList();
		
	}

	@Override
	public void agregarProducto(Producto producto) {

		productos.add(producto);
		
	}

	@Override
	public void eliminarProducto(String nombre) {
		productos.removeIf(p->p.getNombre().equals(nombre));
		
	}

	
	
	
}

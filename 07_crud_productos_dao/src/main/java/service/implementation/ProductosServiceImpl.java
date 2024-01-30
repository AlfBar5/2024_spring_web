package service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.interfaces.ProductosDao;

import model.Producto;
import service.interfaces.ProductosService;

//@Service para que SPRIM cree objetos de la clase ProductosServiceImpl (para que haga los new)
@Service
public class ProductosServiceImpl implements ProductosService {
	
	//inyectamos el dao ProductosDao
	@Autowired
	ProductosDao productosDao;
	
	
	

	//hay que utilizar el import org.springframework.transaction.annotation.Transactional;
	//Para que spring inicie y confirme la tx (transacción) automáticamente. 
	@Transactional
	@Override
	public boolean agregarProducto(Producto producto) {
		
		if(productosDao.findByNombre(producto.getNombre())!=null) {
			return false;
		}
		
		productosDao.save(producto);
		return true;
		
	}

	 
	@Transactional
	@Override
	public void modificarPrecio(String nombre, double nuevoPrecio) {

		//le pasamos el nombre del producto al método private buscarProducto
		Producto prod=productosDao.findByNombre(nombre);

		if (prod!=null) {
			prod.setPrecio(nuevoPrecio);
			productosDao.update(prod);
			//return prod;
		}else {
			//return null;
		}
		
		
		/* OTRA FORMA
		Producto producto=buscarProducto(nombre);
		if(producto!=null){
			producto.setPrecio(nuevoPrecio);
			em.merge(producto)
		}
		
		*/


	}

	@Transactional
	@Override
	public Producto eliminarProducto(String nombre) {
		
		Producto prod=productosDao.findByNombre(nombre);
		if(prod==null) {
			return null;
		}
		/*String jpql="delete from Producto p where p.nombre=?1";
		Query query=em.createQuery(jpql);
		query.setParameter(1, nombre);
		query.executeUpdate();
		*/
		productosDao.delete(prod);
		//productosDao.deleteByNombre(nombre);
		return prod;
	}


	@Override
	public List<Producto> todosProductos() {

		return productosDao.todosProductos();
		
	}


	@Override
	public List<Producto> buscarPorCategoria(String categoria) {
		return productosDao.findByCategoria(categoria);
	}

}

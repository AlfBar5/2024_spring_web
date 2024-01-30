package service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Producto;
import service.interfaces.ProductosService;


@Service
public class ProductosServiceImpl implements ProductosService {
	
	//Para inyectar el EntityManager
	@PersistenceContext 
	EntityManager em;
	
	
	//mostrar todos los productos
	@Override
	public List<Producto> todosProductos() {
		
		//definimos la jpql
		String jpql="select p from Producto p";
		TypedQuery<Producto> query=em.createQuery(jpql, Producto.class);
		return query.getResultList();
		
	}

	//buscar producto por categoria
	@Override
	public List<Producto> buscarPorCategoria(String categoria) {

		//definimos la jpql
		String jpql="select p from Producto p where p.categoria=?1";
		TypedQuery<Producto> query=em.createQuery(jpql, Producto.class);
		query.setParameter(1, categoria);
		return query.getResultList();
		
		
	}

	//buscar producto por nombre
	//metodo privado, no está en la interfaz
	private Producto buscarProducto(String nombre) {

		String jpql="select p from Producto p where p.nombre=?1";
		TypedQuery<Producto> query=em.createQuery(jpql,Producto.class);
		query.setParameter(1, nombre);
		List<Producto> productos=query.getResultList();
		return productos.size()>0?productos.get(0):null;
		
	}

	//hay que utilizar el import org.springframework.transaction.annotation.Transactional;
	//Para que spring inicie y confirme la tx (transacción) automáticamente. 
	@Transactional
	@Override
	public boolean agregarProducto(Producto producto) {
		
		//le pasamos el nombre del producto al método private buscarProducto
		Producto prod=buscarProducto(producto.getNombre());
		
		//si ya está no lo agregamos
		if (prod!=null) {
			return false;
		}else {
			em.persist(producto);
			return true;
			
		}
		
	}

	 
	@Transactional
	@Override
	public void modificarPrecio(String nombre, double nuevoPrecio) {

		//le pasamos el nombre del producto al método private buscarProducto
		Producto prod=buscarProducto(nombre);

		if (prod!=null) {
			String jpql="update Producto p set p.precio=?1 where p.nombre=?2";
			Query query=em.createQuery(jpql);
			query.setParameter(1, nuevoPrecio);
			query.setParameter(2, nombre);
			query.executeUpdate();
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
		
		Producto prod=buscarProducto(nombre);
		if(prod==null) {
			return null;
		}
		/*String jpql="delete from Producto p where p.nombre=?1";
		Query query=em.createQuery(jpql);
		query.setParameter(1, nombre);
		query.executeUpdate();
		*/
		em.remove(prod);
		return prod;
	}

}

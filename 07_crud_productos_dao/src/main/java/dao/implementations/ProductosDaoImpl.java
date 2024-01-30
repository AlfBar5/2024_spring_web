package dao.implementations;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.interfaces.ProductosDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Producto;

//PARA DECIRLE A SPRIM que tiene que instanciar objetos de esta clase en otras capas (los news)
@Repository
public class ProductosDaoImpl implements ProductosDao {

	@PersistenceContext
	EntityManager em;
	
	
	//GUARDAR PRODUCTO
	@Transactional
	@Override
	public void save(Producto producto) {

		em.persist(producto);

	}

	//Lista de todos lo productos
	@Override
	public List<Producto> todosProductos() {
		//definimos la jpql
		String jpql="select p from Producto p";
		TypedQuery<Producto> query=em.createQuery(jpql, Producto.class);
		return query.getResultList();
	}

	
	//Buscar por nombre
	@Override
	public Producto findByNombre(String nombre) {
		
		String jpql="select p from Producto p where p.nombre=?1";
		TypedQuery<Producto> query=em.createQuery(jpql,Producto.class);
		query.setParameter(1, nombre);
		List<Producto> productos=query.getResultList();
		return productos.size()>0?productos.get(0):null;
	}

	
	@Override
	public List<Producto> findByCategoria(String categoria) {

		//definimos la jpql
		String jpql="select p from Producto p where p.categoria=?1";
		TypedQuery<Producto> query=em.createQuery(jpql, Producto.class);
		query.setParameter(1, categoria);
		return query.getResultList();
		
		
	}

	@Transactional
	@Override
	public void update(Producto producto) {
		//em.refresh(producto); //refrescamos el objeto y reintegramos el objeto al grupo de persistencia
		em.merge(producto);

	}

	@Transactional
	@Override
	public void delete(Producto producto) {
		//em.refresh(producto); //refrescamos el objeto y reintegramos el objeto al grupo de persistencia
		//em.remove(producto);
		
		//buscar y eliminar para que no pierda la persistencia
		//em.remove(em.find(Producto.class, producto.getIdProducto()));
		
		em.remove(em.merge(producto));

	}

	
	@Transactional
	@Override
	public void deleteByCategoria(String nombre) {

		String jpql="delete from Producto p where p.nombre=?1";
		Query query=em.createQuery(jpql);
		query.setParameter(1, nombre);
		query.executeUpdate();
		

	}

}

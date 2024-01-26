package service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import model.Resultado;
import service.interfaces.BuscadorService;



@Service
public class BuscadorServiceImpl implements BuscadorService {
	
	//Para inyectar el EntityManager
	@PersistenceContext 
	EntityManager em;
	
	
	//no toca la base de datos, no hace falta transaccionalidad
	@Override
	public List<Resultado> buscar(String tematica) {
		
		//definimos la jpql
		String jpql="select r from Resultado r where r.tematica=?1";
		TypedQuery<Resultado> query=em.createQuery(jpql, Resultado.class);
		query.setParameter(1, tematica);
		return query.getResultList();
		
	}
	
	
	//hay que utilizar el import org.springframework.transaction.annotation.Transactional;
	//Para que spring inicie y confirme la tx (transacción) automáticamente. 
	@Transactional
	@Override
	public void agregarResultado(Resultado resultado) {

		em.persist(resultado);
		
		
	}

}

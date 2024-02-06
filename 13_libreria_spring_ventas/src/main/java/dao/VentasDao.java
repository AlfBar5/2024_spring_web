package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Venta;

public interface VentasDao extends JpaRepository<Venta, Integer> {
	
	//no hace falta poner la query --> jugamos con los nombres
	//Nombre del campo que contiene la entidad completa --> Cliente
	//nombre de la propiedad -->idCliente
	List<Venta> findByClienteIdCliente(int idCliente);
	
	//No usado
	//Ventas por un rango de fechas
	//java.util.Date
	List<Venta> findByFechaBetween(Date f1, Date f2);

	//select de todas las ventas que ha tenido un libro concreto
	//la siguiente query no hace falta, se pone por claridad
	@Query("select v from Venta v where v.libro.isbn=?1")
	List<Venta> findByLibroIsbn(int isbn);
	
	
}

package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Tema;

public interface TemasDao extends JpaRepository<Tema, Integer> {

	//métodos que se necesitan pero los heredamos del JpaRepository 
	//no hace falta explicitarlos
	
	//findAll();
	//findByIdTema();
	
	
	
	//quiero un tema asociado a un libro JOIN EXPLICITO
	//La condicion es MUCHOS (es un List) a UNO
	@Query("select t from Tema t join t.libros l where l.titulo=?1")
	
	//Tema asociado a un determinado libro
	Tema findByTitulo(String titulo);
}

package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Libro;

public interface LibrosDao extends JpaRepository<Libro, Integer> {
	
	//nos devuelve el libro del titulo buscado
	Libro findByTitulo(String titulo);
	
	//no usado
	List<Libro> findByAutor(String autor);
	
	//permite buscar un libro por idTema (por categoria/temas)
	List<Libro> findByIdTema(int idTema);
	
	//dos métodos que se necesitan pero los heredamos del JpaRepository 
	//no hace falta explicitarlos
	
	//findById(int isbn)
	//findAll()
	
	
}

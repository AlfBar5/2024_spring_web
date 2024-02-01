package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Libro;

public interface LibrosDao extends JpaRepository<Libro, Integer> {
	
	//nos devuelve el libro del titulo buscado
	Libro findByTitulo(String titulo);
	
	//no usado
	List<Libro> findByAutor(String autor);
	
	
	
	//Buscar libros por nombre de tema
	//no se puede hacer ahora mismo, no hay nombre de tema en la tabla libro
	//List<Libro> findByTema(String tema);
	//Cuando hay que buscar entidades cuya condición dependa de otra entidad
	//con la que está relacionada, no queda más remedio que relacionar las entidades(tablas)
	
	//permite buscar un libro por idTema (por categoria/temas)
	//Relación join implícito
	@Query("select l from Libro l where l.tema.idTema=?1")
	List<Libro> findByIdTema(int idTema);
	
	//l.objetotema.propiedaddelobjeto
	//.nombretabla tema.nombredelcampo tema
	@Query("select l from Libro l where l.tema.tema=?1")
	List<Libro> findByTema(String tema);
	
	//dos métodos que se necesitan pero los heredamos del JpaRepository 
	//no hace falta explicitarlos
	
	//findById(int isbn)
	//findAll()
	
	
}

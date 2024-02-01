package service.interfaces;

import java.util.List;
import java.util.Optional;

import model.Libro;
import model.Tema;

public interface LibrosService {
	
	
	//devolvemos Dtos, y dentro del service trabajamos con los javabean del model (entidades)
	List<Tema> getTemas();

	
	List<Libro> librosTema(int idTema);

	
	//a partir del isbn que se devuelva un libro
	//Devuelve la entidad a partir de su primary key, envuelta en un Optional 
	Libro getLibro(int isbn);

	
	//devuelve el objeto Tema si le pasamos el idTema. Para conseguir el nombre de la categoría
	//permite buscar un libro por idTema (por categoria/temas)
	//Devuelve la entidad a partir de su primary key, envuelta en un Optional 
	Tema getTema(int idTema);

}

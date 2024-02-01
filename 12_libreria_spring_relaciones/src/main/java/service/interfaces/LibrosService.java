package service.interfaces;

import java.util.List;
import java.util.Optional;

import dtos.LibroDto;
import dtos.TemaDto;
import model.Libro;
import model.Tema;

public interface LibrosService {
	
	
	//devolvemos Dtos, y dentro del service trabajamos con los javabean del model (entidades)
	List<TemaDto> getTemas();

	
	List<LibroDto> librosTema(int idTema);

	
	//a partir del isbn que se devuelva un libro
	//Devuelve la entidad a partir de su primary key, envuelta en un Optional 
	LibroDto getLibro(int isbn);

	
	//devuelve el objeto Tema si le pasamos el idTema. Para conseguir el nombre de la categoría
	//permite buscar un libro por idTema (por categoria/temas)
	//Devuelve la entidad a partir de su primary key, envuelta en un Optional 
	TemaDto getTema(int idTema);

}

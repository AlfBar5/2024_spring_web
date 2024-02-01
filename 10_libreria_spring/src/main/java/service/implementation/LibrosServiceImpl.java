package service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import dao.LibrosDao;
import dao.TemasDao;
import model.Libro;
import model.Tema;
import service.interfaces.LibrosService;


//@Service para que SPRIM cree objetos de la clase LibrosServiceImpl (para que haga los new)
@Service
public class LibrosServiceImpl implements LibrosService {
	
	
	//inyectamos los dos Dao TemasDao y LibrosDao. 
	//Cada una tiene que llevar su inyección de objetos (@Autowired)
	@Autowired
	LibrosDao librosDao;
	@Autowired
	TemasDao temasDao;
	
	
	//devuelve todos los temas
	@Override
	public List<Tema> getTemas() {
		
		return temasDao.findAll();
	}

	
	//buscar por foreignkey (idTema)
	@Override
	public List<Libro> librosTema(int idTema) {
		
		//lógica de negocio
		//si el idTema es 0, tengo que llamar a todos los temas
		if(idTema==0) {
			return librosDao.findAll();
		}else {
			return librosDao.findByIdTema(idTema);
		}
		
	}

	
	
	//Devuelve la entidad a partir de su primary key, envuelta en un Optional 
	@Override
	public Libro getLibro(int isbn) {
		
		Optional<Libro> resultado =librosDao.findById(isbn); 
		
		//Si el dato está presente, ya puedo llamar a get
		//una forma
		//return resultado.isPresent()?resultado.get():null;
		
		//otra forma. orElse comprueba el resultado 
		//y le podemos decir que devuelve (null) en caso de no encontrar nada
		return resultado.orElse(null);

		
	}

	
	//Devuelve la entidad a partir de su primary key, envuelta en un Optional
	@Override
	public Tema getTema(int idTema) {
		
		//otra forma para lidiar con el Optional
		return temasDao.findById(idTema).orElse(null);
		
	}

}

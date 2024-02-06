package model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//lombok
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//colocamos antes de la clase lo que queremos que haga la librería LOMBOK
//Coloca el código durante la compilación del código
//@Data agrupa al setter y al getter y tiene más cosas

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "temas")
public class Tema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTema;
	private String tema;
	
	//tablas relacionadas: temas y libros --> UNO A MUCHOS (por idTema)
	//un tema puede tener asociados muchos libros, devuelve una lista de libros
	//nombre del objeto de la otra entidad -->tema
	@OneToMany(mappedBy = "tema") 
	private List<Libro> libros;
	
	
	
	

}

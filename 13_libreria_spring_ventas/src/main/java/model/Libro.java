package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "libros")
public class Libro {
	
	@Id
	private int isbn;
	private String titulo;
	private String autor;
	private double precio;
	private int paginas;
	
	//relacion tabla  MUCHOS A UNO
	//decimos en nombre de la Foreign Key.
	//name es la FK (de la tabla libros), referencedColumnName es la PrimaryKey (tabla temas)
	@ManyToOne()
	@JoinColumn(name="idTema",referencedColumnName = "idTema")
	private Tema tema;

}

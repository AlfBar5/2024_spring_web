package model;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
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
@Table(name = "ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenta;
	private Date fecha;
	
	

	//MUCHOS A UNO
	//una cliente puede tener muchas ventas (ha comprado varias veces)
	//nombre de la FK (de la tabla ventas -- idCliente)
	//referencedColumnName --> PK de la tabla clientes -- idClientes
	@ManyToOne()
	@JoinColumn(name="idCliente",referencedColumnName =  "idCliente")
	private Cliente cliente;
	
	//MUCHOS A UNO
	//una venta puede tener muchos libros
	//relacion tabla  MUCHOS A UNO
	//decimos en nombre de la Foreign Key.
	//name es la FK (de la tabla ventas), referencedColumnName es la PrimaryKey (tabla libros)
	@ManyToOne()
	@JoinColumn(name="idLibro",referencedColumnName = "isbn")
	private Libro libro;
	
	
	
}

package service.mappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dtos.ClienteDto;
import dtos.LibroDto;
import dtos.TemaDto;
import dtos.VentaDto;
import model.Cliente;
import model.Libro;
import model.Tema;
import model.Venta;
import service.implementation.LibrosServiceImpl;
import service.interfaces.LibrosService;


//le decimos que es componente de sprim
@Component
public class Mapeador {
	
	@Autowired
	LibrosService service;
	
	public  TemaDto temaEntityToDto(Tema tema) {
		return new TemaDto(tema.getIdTema(),tema.getTema());
	}
	
	public  LibroDto libroEntityToDto(Libro libro) {
		
		return new LibroDto(libro.getIsbn(),
				libro.getTitulo(),
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(),
				service.getTema(libro.getTema().getIdTema())); //libro tiene el objeto Tema completo 
	}
	
	
	//crear a partir de un libroDto un objeto Libro (el tema, lo dejamos a nulo)
	public Libro libroDtoToEntity(LibroDto libro) {
		return new Libro(libro.getIsbn(),
				libro.getTitulo(),
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(),
				null);
	}
	
	
	public  ClienteDto clienteEntityToDto(Cliente cliente) {
		return cliente!=null?new ClienteDto(cliente.getUsuario(),
							cliente.getPassword(),
							cliente.getEmail(),
							cliente.getTelefono()):null;
	}
	
	
	//el constructor del cliente no necesita la lista de ventas para dar de
	//alta un cliente, le ponemos un null como ultimo parámetro
	// el private List<Venta> ventas no lo necesitamos;
	public  Cliente clienteDtoToEntity(ClienteDto cliente) {
		return new Cliente(0,
				cliente.getUsuario(),
				cliente.getPassword(),
				cliente.getEmail(),
				cliente.getTelefono(), 
				null);
	}
	
	
	public VentaDto ventaEntityToDto(Venta venta) {
		return new VentaDto(
				venta.getIdVenta(),
				venta.getCliente().getUsuario(),
				venta.getLibro().getTitulo(),
				convertirDateALocalDate(venta.getFecha()) //convertir fecha 
				);
				
		
	}
	
	
	//método para convertir Date a LocalDate
	private LocalDate convertirDateALocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime())
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate(); 
		
	}
	
	
	
	
	
}

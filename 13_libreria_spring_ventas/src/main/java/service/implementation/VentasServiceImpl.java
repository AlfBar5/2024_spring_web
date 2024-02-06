package service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import dao.LibrosDao;
import dao.VentasDao;
import dtos.LibroDto;
import dtos.VentaDto;
import model.Cliente;
import model.Venta;
import service.interfaces.VentasService;
import service.mappers.Mapeador;

//@Service para que SPRIM cree objetos de la clase VentasServiceImpl (para que haga los new)
@Service
public class VentasServiceImpl implements VentasService {

	
	
	//inyectamos los dos Dao VentasDao. 
	//Cada una tiene que llevar su inyección de objetos (@Autowired)
	@Autowired
	VentasDao ventasDao;
	@Autowired
	ClientesDao clientesDao;
	@Autowired
	LibrosDao librosDao;
	@Autowired
	Mapeador mapeador;
	
	@Override
	public List<VentaDto> informeVentasCliente(String usuario) {
		return ventasDao.findByClienteIdCliente(clientesDao.findByUsuario(usuario).getIdCliente())
				.stream()
				.map(v->mapeador.ventaEntityToDto(v))
				.toList();
	}

	
	@Override
	public void registrarCompra(String usuario, List<LibroDto> libros) {
		
		//hay que dar de alta objetos venta (que tienen un idVenta, fecha, objeto Cliente, objeto Libro
		//ya se encarga jpa de convertir los datos a los campos que tiene la tabla.
		//y guardarlos con save en la tabla ventas
		
		//Fecha actual de java.utils
		Date fechaactual = new Date();
		
		//Objeto cliente
		Cliente cliente=clientesDao.findByUsuario(usuario);
		
		//recorre la colección de libros
		//Creamos un objeto venta
		//salvamos. El metodo save ya viene heredado
		//idVenta lo ponemos a 0
		for(LibroDto dto:libros) {
			Venta venta=new Venta(0, fechaactual, cliente, mapeador.libroDtoToEntity(dto));
			ventasDao.save(venta);
		}
				
		

		
				
		
	}
	
	
	
	

}

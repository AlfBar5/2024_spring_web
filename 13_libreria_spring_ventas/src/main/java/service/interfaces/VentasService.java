package service.interfaces;

import java.util.List;

import dtos.LibroDto;
import dtos.VentaDto;

public interface VentasService {
	
	//devuelve una lista de objeto Venta asociadios a un cliente (el que se ha logado)
	List<VentaDto> informeVentasCliente(String usuario);
	
	//Comprar carrito
	//recibe de parámetros el usuario que está logado y la lista de libros que compra
	void registrarCompra(String usuario, List<LibroDto> libros);

}

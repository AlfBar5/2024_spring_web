package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import model.Cliente;
import model.Libro;
import service.interfaces.ClientesService;
import service.interfaces.LibrosService;


//Hacemos un solo controller

@Controller
public class LibreriaController {
	
	
	@Autowired
	LibrosService librosService;
	@Autowired
	ClientesService clientesService;
	
	
	//alta @ModelAttribute se trae todos los parámetros del objeto Cliente
	@PostMapping(value="alta")
	public String altaCliente(@ModelAttribute Cliente cliente, Model model) {
		
		if(!clientesService.altaCliente(cliente)) {
			
			model.addAttribute("mensaje","Usuario repetido, no se pudo registrar");
			return "nuevo";
			
		}
		return "login";
	}
	
	
	//no es petición ayax
	@PostMapping(value="login")
	public String login(@RequestParam("usuario") String usuario,
			@RequestParam("password") String password, Model model) {
		
		//si el usuario no existe en la base de datos
		if(clientesService.autenticarCliente(usuario, password)==null) {
			model.addAttribute("mensaje", "Usuario no existente, registrese");
			return "login";
		}
		
		//si está el cliente autenticado, ya cogemos los textos para pintar el selector
		model.addAttribute("temas", librosService.getTemas());
		return "visor";
	}
	
	
	
	
	/////////////
	///PETICIONES AYAX - SPRIM convierte los resultados en un json
	
	//Recibe el idTema y recoge los libros
	@GetMapping(value="libros", produces="application/json")
	public @ResponseBody List<Libro> librosTema(@RequestParam("idTema") int idTema){
		return librosService.librosTema(idTema);
	}
	
	
	//recibimos el isbn y agregamos al carrito
	//crear objeto sesion --> HttpSession sesion
	@GetMapping(value="agregarCarrito",produces="application/json")
	public @ResponseBody List<Libro> agregarCarrito(@RequestParam("isbn") int isbn, HttpSession sesion){
		
		//Agregamos libro a sesión del carrito
		//recogemos parámetro
		Libro libro=librosService.getLibro(isbn);	
		
		//creo e inicializo la lista vacía
		List<Libro> carrito = new ArrayList<>();
												
		//controlamos que la variable de sesión esté creada
		if(sesion.getAttribute("carrito")!=null) {
			//el List productos lo hemos vaciado al inicializar la lista vacia
			//pero lo volvemos a llenar con los productos guardados en la variable de sesión
			//Creamos la variable de sesión la primera vez
			carrito = (List<Libro>)sesion.getAttribute("carrito");
						
		}					
		carrito.add(libro);
		sesion.setAttribute("carrito", carrito);
		//deben devolver los resultados que el javascript necesite
		return carrito;
				
		
	}
	
	
	
	//recibimos la posición pos y quitamos del carrito (de la sesion)
	//@ResponseBody List<Libro> transforma json en list<Libro>
	@GetMapping(value="quitarCarrito",produces="application/json")
	public @ResponseBody List<Libro> quitarCarrito(@RequestParam("pos") int pos, HttpSession sesion){
		
		//llenamos la lista de libros con la lista de la sesion
		List<Libro> carrito=new ArrayList<>();
		
		if(sesion.getAttribute("carrito")!=null) {
			carrito=(List<Libro>)sesion.getAttribute("carrito");
			carrito.remove(pos);
		}

		sesion.setAttribute("carrito", carrito);
		//envía como respuesta un JSON con los datos del carrito
		return carrito;
	} 
	
}

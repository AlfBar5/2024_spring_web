package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Producto;

import service.interfaces.ProductosService;

@Controller
public class ProductosController {

	
	//como spring es responsable de inyectar los objetos de la lógica de negocio
		//también es responsable de inyectarlos donde se le pidan
		//Con @Autowired (que es igual que el antiguo @inject, le decimos que tiene que inyectar 
		//alguna instacia de la clase que implemente esta interfaz
		//inyecta objetos de otras capas en la variable donde aparecen
		
		@Autowired
		ProductosService productosService;
	
		//MÉTODO GET del formulario @GetMapping
		//Método que devuelve un String (obligatorio) Es la página a la que se va a ir
		//El @RequestParam("tematica") ya nos recoge los parámetros
		//El parámetro model lo predefinimos. Le vamos a pasar el resultado del método, en este caso una Lista
		@GetMapping(value="buscar")
		public String buscar(@RequestParam("categoria") String categoria, Model model) {
			
			//Le vamos a pasar una lista
			List<Producto> resultados=productosService.buscarPorCategoria(categoria);
			
			//Equivale al request.setAtribute(...)
			model.addAttribute("resultados",resultados);
									
			//devolvemos una cadena String con el nombre de la página a que debemos devolver el resultado
			//Nombre de la página. La extensión se la decimos en la configuración:
			return "resultados";
			
			//OTRA FORMA EN SOLO DOS LINEAS
			//model.addAttribute("productos",productosService.buscarPorCategoria(categoria));
			//return "productos"
		}
		
		
		
		//método para agregar Objeto METODO POST
		//@ModelAttribute Resultado -->se trae todos los parámetros del formulario y construye el objeto Resultado. Parsea también. Usa los get del model
		@PostMapping(value="alta")
		public String agregarResultado(@ModelAttribute Producto producto) {
			
			//le pasamos el nuevo resultado al método agregarResultado
			productosService.agregarProducto(producto);
			
			//devolvemos una cadena String con el nombre de la página a que debemos devolver el resultado
			return "menu";
					
			
		}
		
		//método para agregar Objeto METODO POST
		//el parámetro que traemos del fomulario es el nombre del producto
		@GetMapping(value="eliminar")
		public String eliminarProducto(@RequestParam("nombre") String nombre, Model model) {
			
			productosService.eliminarProducto(nombre);
			
			return "menu";
		}
		
	
}

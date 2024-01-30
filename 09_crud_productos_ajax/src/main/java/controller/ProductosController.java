package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
		
		
		@GetMapping(value="/")
		public String index(Model model) {
			
			//mostrar todos los productos
			List<Producto> resultados=productosService.todosProductos();
			
			//Equivale al request.setAtribute(...)
			model.addAttribute("resultados", resultados);
			
			//devolvemos una cadena String con el nombre de la página a que debemos devolver el resultado
			//Nombre de la página. La extensión se la decimos en la configuración:
			return "index";
			
		}
		
		
		
		

		@GetMapping(value="toIndex")
		public String toindex(Model model) {
			
			//mostrar todos los productos
			List<Producto> resultados=productosService.todosProductos();
			
			//Equivale al request.setAtribute(...)
			model.addAttribute("resultados", resultados);
			
			//devolvemos una cadena String con el nombre de la página a que debemos devolver el resultado
			//Nombre de la página. La extensión se la decimos en la configuración:
			return "index";
			
		}
		
		
		
		//Método que devuelve un List<Producto> 
		//Es una petición AJAX, le decimos que en la propia página pinte la lista de productos
		//@ResponseBody List<Producto>
		//El @RequestParam("categoria") ya nos recoge los parámetros		
		@GetMapping(value="buscar", produces="application/json")
		public @ResponseBody List<Producto> buscar(@RequestParam("categoria") String categoria, Model model) {
			
			return productosService.buscarPorCategoria(categoria);
			
		}
		
		
		//método para agregar Objeto METODO POST
		//@ModelAttribute Resultado -->se trae todos los parámetros del formulario y construye el objeto Resultado. Parsea también. Usa los get del model
		@PostMapping(value="doNuevoProducto")
		public String agregarProducto(@ModelAttribute Producto producto, Model model) {
			
			
			
			if(!productosService.agregarProducto(producto)) {
				model.addAttribute("mensajeAlta","Producto "+producto.getNombre()+" repetido, no se añadió!!!");
			}
			
			//Para lanzar los resultados del grid de datos al index
			//mostrar todos los productos
			List<Producto> resultados=productosService.todosProductos();
			//Equivale al request.setAtribute(...)
			model.addAttribute("resultados", resultados);
			
			return "index";
					
			
		}
		
		
		
		//método para agregar Objeto METODO POST
		//@RequestParam -->nos traemose todos los parámetros del formulario y construye el objeto Resultado. Parsea también. Usa los get del model
		@PostMapping(value="doModificarProducto")
		public String modificarProducto(@RequestParam("nombre") String nombre, @RequestParam("nuevoprecio") double nuevoprecio, Model model) {
				
			
			
			//le pasamos el nuevo resultado al método agregarResultado
			productosService.modificarPrecio(nombre, nuevoprecio);

			
			//Para lanzar los resultados del grid de datos al index
			//mostrar todos los productos
			List<Producto> resultados=productosService.todosProductos();
			//Equivale al request.setAtribute(...)
			model.addAttribute("resultados", resultados);
			
			
			//devolvemos una cadena String con el nombre de la página a que debemos devolver el resultado
			return "index";
							
					
		}
		
		
		//método para agregar Objeto METODO POST
		//@RequestParam -->nos traemose todos los parámetros del formulario y construye el objeto Resultado. Parsea también. Usa los get del model
		@GetMapping(value="doEliminarProducto")
		public String eliminarProducto(@RequestParam("nombre") String nombre, Model model) {

			
			
			Producto prod=productosService.eliminarProducto(nombre);
			if(prod!=null) {
				model.addAttribute("mensajeEliminar","se ha eliminado el producto "+nombre+" de la categoría "+prod.getCategoria());
			}else {
				model.addAttribute("mensajeEliminar","el producto "+nombre+ " no existe!!!");
			}
			
			//Para lanzar los resultados del grid de datos al index
			//mostrar todos los productos
			List<Producto> resultados=productosService.todosProductos();
			//Equivale al request.setAtribute(...)
			model.addAttribute("resultados", resultados);
			
			return "index";


		}
				
		
		
		
}

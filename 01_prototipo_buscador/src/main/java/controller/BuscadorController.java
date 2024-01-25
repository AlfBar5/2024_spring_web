package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Resultado;
import service.interfaces.BuscadorService;

@Controller
public class BuscadorController {
	//como spring es responsable de inyectar los objetos de la lógica de negocio
	//también es responsable de inyectarlos donde se le pidan
	//Con @Autowired (que es igual que el antiguo @inject, le decimos que tiene que inyectar 
	//alguna instacia de la clase que implemente esta interfaz
	
	@Autowired
	BuscadorService buscadorService;
	
	//MÉTODO GET del formulario
	//Método que devuelve un string (obligatorio) Es la página a la que se va a ir
	//El @RequestParam("tematica") ya nos recoge los parámetros
	//El parámetro model lo predefinimos. Le vamos a pasar el resultado del método, en este caso una Lista
	@GetMapping(value="buscar")
	public String buscar(@RequestParam("tematica") String tematica, Model model) {
		
		//Le vamos a pasar una lista
		List<Resultado> resultados=buscadorService.buscar(tematica);
		
		//Equivale al request.setAtribute(...)
		model.addAttribute("resultados",resultados);
		
		//devolvemos una cadena String con el nombre de la página a que debemos devolver el resultado
		//Nombre de la página. La extensión se la decimos en la configuración:
		return "resultados";
	}
	
	
	//método para agregar Objeto METODO POST
	//@ModelAttribute Resultado -->se trae todos los parámetros del formulario y construye el objeto Resultado. Parsea también. Usa los get del model
	@PostMapping(value="doNuevoResultado")
	public String agregarResultado(@ModelAttribute Resultado resultado) {
		
		//le pasamos el nuevo resultado al método agregarResultado
		buscadorService.agregarResultado(resultado);
		
		//devolvemos una cadena String con el nombre de la página a que debemos devolver el resultado
		return "menu";
				
		
	}
	
	
	//botón VOLVER
	@GetMapping(value="toBuscar")
	public String toBuscar() {
		return "buscar";
	}
	
	
	//Definimos la página de inicio
	@GetMapping(value="/")
	public String toInicio() {
		return "menu";
	}
	
	@GetMapping(value="toAlta")
	public String toAlta() {
		return "alta";
	}
	
	@GetMapping(value="toMenu")
	public String toMenu() {
		return "menu";
	}
	
	/*
	 * OTRA FORMA PARA DOS URL QUE VAN AL MISMO SITIO
	 
	 @GetMapping(value={"toBuscar","/"})
	 public String toBuscar() {
		return "buscar";
	 }
	 
	 */
	
	
}

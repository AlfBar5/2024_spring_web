package controller.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;


/*
------ el action del formulario action="doNuevoResultado" method="POST"
------ va al método del controlador @PostMapping(value="doNuevoResultado")
------ El String del método retorna a la página de destino --> return "alta"
------ Al salir del método va a la página de alta.html/alta.jsp
*/

@ComponentScan(basePackages= {"controller"})
@EnableWebMvc
@Configuration

public class MvcConfig implements WebMvcConfigurer{
	
	@Autowired
	private ApplicationContext applicationContext;
	@Bean
	public SpringResourceTemplateResolver templateResolver(){
	 SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	 templateResolver.setApplicationContext(this.applicationContext);
	 templateResolver.setPrefix("/");
	 templateResolver.setSuffix(".html");
	 // HTML es la plantilla por defecto, se indica por claridad.
	 templateResolver.setTemplateMode(TemplateMode.HTML);
	 return templateResolver;
	}
	@Bean
	public SpringTemplateEngine templateEngine(){ 
	 SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	 templateEngine.setTemplateResolver(templateResolver());
	 templateEngine.setEnableSpringELCompiler(true);
	 return templateEngine;
	}
	@Bean
	public ThymeleafViewResolver viewResolver(){
	 ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	 viewResolver.setTemplateEngine(templateEngine());
	 return viewResolver;
	}
	
	
	//Navegaciones estáticas TODAS PARA ENLACES toXXX
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/altacliente").setViewName("altacliente");
		
		
	}
	
	
	//Hay que decirle a Sprim en qué carpeta están los recursos estáticos (imagenes. etc)
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//le damos la ruta, podemos añadir todos los registros como sean necesarios
		registry.addResourceHandler("/**").addResourceLocations("/img");
		
		
		
	}
	
	
	
	
	

}
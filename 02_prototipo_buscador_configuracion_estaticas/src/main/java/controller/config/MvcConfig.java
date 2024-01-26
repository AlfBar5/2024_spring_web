package controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//Paquete con clases a instanciar

@ComponentScan(basePackages= {"controller"})
@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	//método que será automáticamente ejecutado por spring cuando se inicie Spring
	//objeto para resolver las vistas
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		 InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		 resolver.setPrefix("/");
		 resolver.setSuffix(".jsp");
		 return resolver;
	}
	

	//Navegaciones estáticas
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("menu");
		registry.addViewController("/toAlta").setViewName("alta");
		registry.addViewController("/toBuscar").setViewName("buscar");
		registry.addViewController("/toMenu").setViewName("menu");
	}
	
	
}




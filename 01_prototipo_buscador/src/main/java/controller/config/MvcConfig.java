package controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//Paquete con clases a instanciar

@ComponentScan(basePackages= {"controller"})
@EnableWebMvc
@Configuration
public class MvcConfig {
	
	//método que será automáticamente ejecutado por spring cuando se inicie Spring
	//objeto para resolver las vistas
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		 InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		 resolver.setPrefix("/");
		 resolver.setSuffix(".jsp");
		 return resolver;
	}
	

}




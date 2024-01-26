package service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan(basePackages = {"service.implementation"})
@Configuration
public class ServiceConfig {

}

package service.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//habilita la transaccionalidad usando anotación @Transactional
//Le decimos en la segunda anotación en qué paquetes están las clases que tiene que instanciar
//En la tercera anotación, le decimos a spring que estamos ante una clase de configuración
@EnableTransactionManagement 
@ComponentScan(basePackages = {"service.implementation"})
@Configuration
public class ServiceConfig {
	
	String driver="com.mysql.cj.jdbc.Driver";
	String cadena="jdbc:mysql://localhost:3306/tienda";
	String usuario="root";
	String pw="root";
	
	//creación del objeto DataSource con los datos de conexión a la BD
	//import este: javax.sql.DataSource;
	//el objeto Datasource tiene un pool de conexiones a la base de datos y 
	@Bean
	public DataSource crearDatasource() {
		DriverManagerDataSource data=new DriverManagerDataSource();
		data.setDriverClassName(driver);
		data.setUrl(cadena);
		data.setUsername(usuario);
		data.setPassword(pw);
		return data;
	} 
	
	
	//Objeto adaptador de Hibernate, para poder conectarse con hibernate. 
	//Hibernate con este objeto adapta las consultas a MySQL
	@Bean
	public HibernateJpaVendorAdapter adapter() {
		HibernateJpaVendorAdapter adp=new HibernateJpaVendorAdapter();
		adp.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adp;
	} 
	
	
	//Objeto que se encarga de la creación de los EntityManager
	//factoria EntityManager: Objeto para acceder a capa de persistencia con JPA
	//se le da un nombre a la Unidad de Persistencia -->buscadorPU
	//el paquete donde estarán las entidades se llama --> model
	@Bean
	public LocalContainerEntityManagerFactoryBean factory() {
		LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceUnitName("tiendaPU");
		factory.setDataSource(crearDatasource());
		factory.setPackagesToScan("model");
		factory.setJpaVendorAdapter(adapter());
		return factory;
	} 
	
	
	//Objeto encargado de la transaccionalidad si se toca la base de datos. Se encarga de los commit
	//creación y configuración del transactionmanager
	@Bean
	public JpaTransactionManager txManager() {
		JpaTransactionManager manager=new JpaTransactionManager();
		manager.setEntityManagerFactory(factory().getObject());
		return manager;
	} 

}

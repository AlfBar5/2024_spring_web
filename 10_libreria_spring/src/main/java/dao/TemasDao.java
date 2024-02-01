package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Tema;

public interface TemasDao extends JpaRepository<Tema, Integer> {

	//métodos que se necesitan pero los heredamos del JpaRepository 
	//no hace falta explicitarlos
	
	//findAll();
	//findByIdTema();
	
}

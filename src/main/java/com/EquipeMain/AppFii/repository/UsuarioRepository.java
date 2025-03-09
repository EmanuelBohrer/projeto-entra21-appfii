package com.EquipeMain.AppFii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EquipeMain.AppFii.models.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	
	
	//Linha que busca o email (que é a forma de login principal) usando o pacote do JPA
	Usuario findByEmail(String email);
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

}

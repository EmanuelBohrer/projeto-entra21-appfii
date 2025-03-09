package com.EquipeMain.AppFii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EquipeMain.AppFii.models.Carteira;

public interface CarteiraRepository extends  JpaRepository<Carteira, String>{
	
	Carteira findByCodigo(long codigo);

}

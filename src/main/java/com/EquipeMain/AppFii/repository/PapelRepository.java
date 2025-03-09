package com.EquipeMain.AppFii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EquipeMain.AppFii.models.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long> {
	
	Papel findByPapel(String papel);

}

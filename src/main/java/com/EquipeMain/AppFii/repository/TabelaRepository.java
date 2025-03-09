package com.EquipeMain.AppFii.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.EquipeMain.AppFii.models.Tabela_Fii;



public interface TabelaRepository extends JpaRepository<Tabela_Fii, Long>{

		

		
		Tabela_Fii findByCODIGO(String CODIGO);
	
}

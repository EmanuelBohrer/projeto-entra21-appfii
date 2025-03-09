package com.EquipeMain.AppFii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EquipeMain.AppFii.models.Carteira;
import com.EquipeMain.AppFii.models.FundosCad;

public interface FundoRepository extends JpaRepository<FundosCad, String>{	
	
	
	Iterable<FundosCad>findByCarteira(Carteira carteira);
	
	FundosCad findByCotas(String cotas);

}

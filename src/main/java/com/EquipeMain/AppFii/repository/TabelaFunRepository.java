package com.EquipeMain.AppFii.repository;



import org.springframework.data.repository.CrudRepository;

import com.EquipeMain.AppFii.models.TabelaFun;



public interface TabelaFunRepository extends CrudRepository <TabelaFun,Long>{
	
	TabelaFun findByCodigo(String codigo);
	

}

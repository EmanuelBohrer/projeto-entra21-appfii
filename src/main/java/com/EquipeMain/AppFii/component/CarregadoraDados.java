package com.EquipeMain.AppFii.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.EquipeMain.AppFii.models.Papel;
import com.EquipeMain.AppFii.repository.PapelRepository;


@Component
public class CarregadoraDados implements CommandLineRunner {

	@Autowired
	private PapelRepository pr;
	
	//O carregador de dados gera a criação de papeis para o banco, caso ele possua os papeis, o banco não é alterado 
	@Override
	public void run(String... args) throws Exception {
		
		String [] papeis = {"ADMIN","USER"};
		for (String papelString: papeis) {
			Papel papel = pr.findByPapel(papelString);
			if(papel == null) {
				papel = new Papel(papelString);
				pr.save(papel);
			}
		}
		
		
	}

}

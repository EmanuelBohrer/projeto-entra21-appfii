package com.EquipeMain.AppFii.visions;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Objeto a ser criado e deixado disponivel no app
@Component
public class VisionConfig implements WebMvcConfigurer {
	
	
	//Registramos no controlador as páginas, utilizando o pacote do webmvc
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/auth/auth-acesso-negado").setViewName("/auth/auth-acesso-negado");

	}

}

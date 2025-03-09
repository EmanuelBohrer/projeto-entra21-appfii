package com.EquipeMain.AppFii.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;





@Component
public class LoginSuccess extends SavedRequestAwareAuthenticationSuccessHandler {
	
	
	//é criado um metodo utilizando o pacote do javax de servlets (servlet tem como objetivo receber requisições http, trazer algo objetos imagens)
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException{
		
		String redirectURL = "/usuario/index";
		response.sendRedirect(redirectURL);
		
	}
	
	

}

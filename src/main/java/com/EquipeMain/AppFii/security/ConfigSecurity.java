package com.EquipeMain.AppFii.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.EquipeMain.AppFii.repository.UsuarioRepository;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UsuarioRepository rp;
	
	
	@Autowired
	private LoginSuccess lp;
	
	
	
	
	@Bean
	public BCryptPasswordEncoder gerarCripto() {
		BCryptPasswordEncoder criptografia = new BCryptPasswordEncoder();
		return criptografia;
		
	}
	
	
	//Recebe os dados do detalhes user para o possivel login
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception{
		DetalhesUsuarioService detalheUser = new DetalhesUsuarioService(rp);
		return detalheUser;
	}
	
	
	//- Configuração das permissões, aqui seleciona quais são as request com os papeis de usuários
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/auth/user/*").hasAnyAuthority("USER","ADMIN")
		.antMatchers("/auth/admin/*").hasAnyAuthority("ADMIN")
		.antMatchers("/usuario/admin/*").hasAnyAuthority("ADMIN")
		.and()
		.exceptionHandling().accessDeniedPage("/auth/auth-acesso-negado")
		.and()
		.formLogin().successHandler(lp) //o spring entende que o login foi um sucesso, criando as views e jogando o usuario pra pagina correta
		.loginPage("/login").permitAll()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/").permitAll();
		
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		//1- Objeto recebe os detalhes do usuario
		UserDetailsService detalheUser = userDetailsServiceBean();
		
		//2- Objeto inicia a criptografia
		BCryptPasswordEncoder criptografia = gerarCripto();
		
		auth.userDetailsService(detalheUser).passwordEncoder(criptografia);
		
		
		
		
	}
	
	

}

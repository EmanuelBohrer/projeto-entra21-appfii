package com.EquipeMain.AppFii.security;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.EquipeMain.AppFii.models.Papel;
import com.EquipeMain.AppFii.models.Usuario;
import com.EquipeMain.AppFii.repository.UsuarioRepository;

@Service
@Transactional
public class DetalhesUsuarioService implements UserDetailsService {

	private UsuarioRepository rp;
	
	
	
	public DetalhesUsuarioService(UsuarioRepository rp) {
		this.rp = rp;
	}



	
	//- Faz a verificação do login, recebendo os dados do banco de dados, e os seus papeis 
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Usuario usuario = rp.findByEmail(email);
		
		if(usuario !=null) {
			Set<GrantedAuthority> papeisUser = new HashSet<GrantedAuthority>();
			for(Papel papel : usuario.getPapeis()) {
				GrantedAuthority pp = new SimpleGrantedAuthority(papel.getPapel());
				papeisUser.add(pp);
			}
			User user = new User(usuario.getEmail(), usuario.getSenha(), papeisUser);
			return user;
		}else {
			throw new UsernameNotFoundException("O usuário não foi encontrado!");
		}
		
		
	}

}

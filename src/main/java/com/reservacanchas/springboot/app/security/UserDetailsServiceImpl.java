package com.reservacanchas.springboot.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.reservacanchas.springboot.app.models.entities.Usuario;
import com.reservacanchas.springboot.app.models.repositories.IUsuarioDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUsuarioDAO usuarioDAO;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioDAO
			.findOneByEmail(email)
			.orElseThrow( ()-> new UsernameNotFoundException("El usuario con email".concat(email).concat(" no existe.")));
		return new UserDetailsImpl(usuario);
	}
	
}

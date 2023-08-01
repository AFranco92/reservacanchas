package com.reservacanchas.springboot.app.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reservacanchas.springboot.app.models.entities.Usuario;
import com.reservacanchas.springboot.app.models.repositories.IUsuarioDAO;
import com.reservacanchas.springboot.app.services.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {
	
	static final int STRENGTH = 10;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) this.usuarioDAO.findAll();
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		Usuario usuarioNuevo = new Usuario();
		if(usuario != null) {
			String encodedPassword = new BCryptPasswordEncoder().encode(usuario.getPassword());
			usuario.setPassword(encodedPassword);
			usuario.setEnabled(true);
			usuarioNuevo = this.usuarioDAO.save(usuario);
		}
		return usuarioNuevo;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return this.usuarioDAO.findByUsername(username);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return this.usuarioDAO.findById(id).orElse(null);
	}

}

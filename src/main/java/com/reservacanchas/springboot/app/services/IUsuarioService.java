package com.reservacanchas.springboot.app.services;

import java.util.List;

import com.reservacanchas.springboot.app.models.entities.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	public Usuario save(Usuario usuario);
	public Usuario findById(Long id);
	public Usuario findByUsername(String username);
	
}

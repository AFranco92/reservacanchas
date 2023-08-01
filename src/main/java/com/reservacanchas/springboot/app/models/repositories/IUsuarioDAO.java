package com.reservacanchas.springboot.app.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reservacanchas.springboot.app.models.entities.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);
	
	@Query("SELECT u FROM Usuario u WHERE u.email = :email")
	Optional<Usuario> findOneByEmail(String email);

}

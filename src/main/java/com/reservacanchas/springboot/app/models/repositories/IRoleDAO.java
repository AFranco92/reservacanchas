package com.reservacanchas.springboot.app.models.repositories;

import org.springframework.data.repository.CrudRepository;
import com.reservacanchas.springboot.app.models.entities.Role;

public interface IRoleDAO extends CrudRepository<Role, Long> {
	
	public Role findByRole(String role);

}

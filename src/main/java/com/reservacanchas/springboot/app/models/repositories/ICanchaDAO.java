package com.reservacanchas.springboot.app.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reservacanchas.springboot.app.models.entities.Cancha;

public interface ICanchaDAO extends CrudRepository<Cancha, Long> {

}

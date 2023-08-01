package com.reservacanchas.springboot.app.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reservacanchas.springboot.app.models.entities.Reserva;

public interface IReservaDAO extends CrudRepository<Reserva, Long> {

}

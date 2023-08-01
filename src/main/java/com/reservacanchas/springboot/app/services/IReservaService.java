package com.reservacanchas.springboot.app.services;

import java.util.List;

import com.reservacanchas.springboot.app.models.entities.Reserva;
import com.reservacanchas.springboot.app.utils.inputs.ReservaInput;

public interface IReservaService {

	public List<Reserva> findAll();
	public Reserva save(ReservaInput reservaInput);
	public void deleteById(Long id);
	
}

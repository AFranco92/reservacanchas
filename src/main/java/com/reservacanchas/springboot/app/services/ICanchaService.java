package com.reservacanchas.springboot.app.services;

import java.util.Date;
import java.util.List;

import com.reservacanchas.springboot.app.models.entities.Cancha;

public interface ICanchaService {

	public List<Cancha> findAll();
	public Cancha save(Cancha cancha);
	public void deleteById(Long id);
	public Cancha findById(Long id);
	public boolean available(Cancha cancha, Date date);
	
}

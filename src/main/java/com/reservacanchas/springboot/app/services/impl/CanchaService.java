package com.reservacanchas.springboot.app.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservacanchas.springboot.app.models.entities.Cancha;
import com.reservacanchas.springboot.app.models.entities.Reserva;
import com.reservacanchas.springboot.app.models.repositories.ICanchaDAO;
import com.reservacanchas.springboot.app.services.ICanchaService;

@Service
public class CanchaService implements ICanchaService {
	
	@Autowired
	private ICanchaDAO canchaDAO;

	@Override
	public List<Cancha> findAll() {
		return (List<Cancha>) this.canchaDAO.findAll();
	}

	@Override
	public Cancha save(Cancha cancha) {
		return this.canchaDAO.save(cancha);
	}

	@Override
	public void deleteById(Long id) {
		this.canchaDAO.deleteById(id);
	}
	
	@Override
	public Cancha findById(Long id) {
		return this.canchaDAO.findById(id).orElse(null);
	}

	@Override
	public boolean available(Cancha cancha, Date date) {
		if(cancha != null && !cancha.isReservada()) {
			for(Reserva r : cancha.getReservas()) {
				if(r.getFecha().equals(date)) {
					return false;
				}
			}
		}
		return true;
	}


}

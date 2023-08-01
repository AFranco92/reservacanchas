package com.reservacanchas.springboot.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservacanchas.springboot.app.models.entities.Cancha;
import com.reservacanchas.springboot.app.models.entities.Reserva;
import com.reservacanchas.springboot.app.models.entities.Usuario;
import com.reservacanchas.springboot.app.models.repositories.IReservaDAO;
import com.reservacanchas.springboot.app.services.ICanchaService;
import com.reservacanchas.springboot.app.services.IReservaService;
import com.reservacanchas.springboot.app.services.IUsuarioService;
import com.reservacanchas.springboot.app.utils.inputs.ReservaInput;

@Service
public class ReservaService implements IReservaService {
	
	@Autowired
	private IReservaDAO reservaDAO;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private ICanchaService canchaService;

	@Override
	public List<Reserva> findAll() {
		return (List<Reserva>) this.reservaDAO.findAll();
	}

	@Override
	public Reserva save(ReservaInput reservaInput) {
		Reserva reserva = new Reserva();
		Reserva reservaCreada = null;
		Usuario usuario = this.usuarioService.findById(reservaInput.getUsuarioId());
		Cancha cancha = this.canchaService.findById(reservaInput.getCanchaId());
		if(	usuario != null && 
			cancha != null 	&&
			this.canchaService.available(cancha, reservaInput.getFecha())
		) {
			reserva.setCancha(cancha);
			reserva.setFecha(reservaInput.getFecha());
			reservaCreada = this.reservaDAO.save(reserva);
			this.updateUsuarioAndCancha(usuario, cancha, reservaCreada);
		}
		return reservaCreada;
	}

	@Override
	public void deleteById(Long id) {
		this.reservaDAO.deleteById(id);
	}
	
	private void updateUsuarioAndCancha(Usuario usuario, Cancha cancha, Reserva reserva) {
		usuario.setReserva(reserva);
		cancha.setReservada(true);
		this.usuarioService.save(usuario);
		this.canchaService.save(cancha);
	}
	
}

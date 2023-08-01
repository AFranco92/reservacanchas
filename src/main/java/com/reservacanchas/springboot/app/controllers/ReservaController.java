package com.reservacanchas.springboot.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservacanchas.springboot.app.models.entities.Reserva;
import com.reservacanchas.springboot.app.services.IReservaService;
import com.reservacanchas.springboot.app.utils.inputs.ReservaInput;

@RestController
@RequestMapping("/api")
public class ReservaController {
	
	@Autowired
	private IReservaService reservaService;
	
	@GetMapping("/reservas/all")
	public List<Reserva> findAll() {
		return this.reservaService.findAll();
	}
	
	@PostMapping("/reservas")
	public Reserva save(@RequestBody ReservaInput reserva) {
		return this.reservaService.save(reserva);
	}
	
	@DeleteMapping("/reservas/{id}")
	public void deleteById(@PathVariable Long id) {
		this.reservaService.deleteById(id);
	}
	
}

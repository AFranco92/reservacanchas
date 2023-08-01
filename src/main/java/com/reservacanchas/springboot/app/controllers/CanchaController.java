package com.reservacanchas.springboot.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservacanchas.springboot.app.models.entities.Cancha;
import com.reservacanchas.springboot.app.services.ICanchaService;

@RestController
@RequestMapping("/api")
public class CanchaController {
	
	@Autowired
	private ICanchaService canchaService;

	@GetMapping("/canchas/all")
	public List<Cancha> findAll() {
		return this.canchaService.findAll();
	}
	
	@PostMapping("/canchas")
	public Cancha save(@Valid Cancha cancha, BindingResult result) {
		return this.canchaService.save(cancha);
	}
	
	@DeleteMapping("/canchas/{id}")
	public void delete(@PathVariable Long id) {
		this.canchaService.deleteById(id);
	}
	
}

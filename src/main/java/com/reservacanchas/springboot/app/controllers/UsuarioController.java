package com.reservacanchas.springboot.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservacanchas.springboot.app.models.entities.Usuario;
import com.reservacanchas.springboot.app.services.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;

	@PostMapping("/usuarios/save")
	public ResponseEntity<?> save(@Valid @RequestBody Usuario usuario, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		Usuario usuarioNuevo = null;
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		usuarioNuevo = this.usuarioService.save(usuario);
		response.put("mensaje", "El usuario ha sido creado con éxito.");
		response.put("usuario", usuarioNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Usuario usuario = null;
		usuario = this.usuarioService.findById(id);
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	
}
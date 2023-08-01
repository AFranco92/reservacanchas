package com.reservacanchas.springboot.app.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoCancha {
	FUTBOL_5("futbol_5", 10), 
	FUTBOL_8("futbol_8", 16);
	
	private String tipo;
	private int capacidad;

	TipoCancha(String tipo, int capacidad) {
		this.tipo = tipo;
		this.capacidad = capacidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	@JsonCreator
	public static TipoCancha getTipoCanchaFromCapacidad(Integer capacidad) {
	    for (TipoCancha tipo : TipoCancha.values()) {
	        if (tipo.getCapacidad() == capacidad) {
	 	       return tipo;
	        }
	    }
	    return null;
	}
}

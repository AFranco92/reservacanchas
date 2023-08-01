package com.reservacanchas.springboot.app.utils.inputs;

import java.util.Date;

public class ReservaInput {
	
	private Long usuarioId;
	private Long canchaId;
	private Date fecha;
	
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Long getCanchaId() {
		return canchaId;
	}
	public void setCanchaId(Long canchaId) {
		this.canchaId = canchaId;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}

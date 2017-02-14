package com.web.enums;

public enum CodigoRespuesta {
	EXITO("OK"),
	ERROR("ERROR");

	private String nombre;

	CodigoRespuesta(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}

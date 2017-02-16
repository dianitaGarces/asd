package com.asd.activos.enums;

public enum CodigoRespuesta {
	EXITO("Operación realizada con exito."),
	ERROR("Error, por favor comuniquese con el administrador."),
	NREG("No se encontraron registros");

	private String nombre;

	CodigoRespuesta(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}

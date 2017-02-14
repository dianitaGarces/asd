package com.activos.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable{
	
	  private static final long serialVersionUID = 11L;

	public String codigo;

	public String mensaje;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("mensaje: " + mensaje + ";");
		buffer.append("codigo: " + codigo);
		return buffer.toString();
	}


}
package com.activos.dto;

import java.io.Serializable;
import java.sql.Date;

public class ActivoDTO extends BaseDTO implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	public String nombre;

	public Integer serial;

	public String descripcion;

	public Integer alto;

	public Integer ancho;

	public Integer largo;

	public Integer peso;

	public Date fecha;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getAlto() {
		return alto;
	}

	public void setAlto(Integer alto) {
		this.alto = alto;
	}

	public Integer getAncho() {
		return ancho;
	}

	public void setAncho(Integer ancho) {
		this.ancho = ancho;
	}

	public Integer getLargo() {
		return largo;
	}

	public void setLargo(Integer largo) {
		this.largo = largo;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	  public String toString() {
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("Nombre: " + nombre + ";");
	        buffer.append("serial: " + serial);
	        buffer.append("descripcion: " + descripcion);
	        buffer.append("alto: " + alto);
	        buffer.append("ancho: " + ancho);
	        buffer.append("largo: " + largo);
	        buffer.append("peso: " + peso);
	        buffer.append("fecha: " + fecha);
	        return buffer.toString();
	    }


}
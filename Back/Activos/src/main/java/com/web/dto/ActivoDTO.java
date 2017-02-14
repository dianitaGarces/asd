package com.web.dto;


import java.io.Serializable;
import java.sql.Date;


public class ActivoDTO extends BaseDTO implements Serializable  {

	private static final long serialVersionUID = 1L;

	public Integer id;
	
	public String nombre;

	public Integer serial;

	public String descripcion;

	public Integer alto;

	public Integer ancho;

	public Integer largo;

	public Integer peso;

	public String fecha_compra;
	
	public String fecha_baja;

	public Integer id_tipo;
	
	public Integer id_estado;
	
	public String estado;
	
	public String tipo;

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

	

	public String getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(String fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public String getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(String fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public Integer getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		return buffer.toString();
	}


}
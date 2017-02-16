package com.asd.activos.dominio;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_activo")
public class Activo  implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	
	public String nombre;

	public Integer serial;

	public String descripcion;

	public Integer alto;

	public Integer ancho;

	public Integer largo;

	public Integer peso;

	public Date fecha_compra;
	
	public Date fecha_baja;

	public Integer id_tipo;
	
	public Integer id_estado;
	
	
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


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


	public Date getFecha_compra() {
		return fecha_compra;
	}


	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}


	public Date getFecha_baja() {
		return fecha_baja;
	}


	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}


	public Integer getId_tipo() {
		return id_tipo;
	}


	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}


	public Integer getId_estado() {
		return id_estado;
	}


	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	



	@Override
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
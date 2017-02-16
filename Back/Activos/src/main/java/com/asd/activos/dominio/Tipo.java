package com.asd.activos.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_tipo") 
public class Tipo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_tipo")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_tipo;

    private String descripcion;
    private String nombre;
    
    
    
    public Integer getId_tipo() {
		return id_tipo;
	}



	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}



	public String getdescripcion() {
		return descripcion;
	}



	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("descripcion: " + descripcion + ";");
        buffer.append("Nombre: " + nombre);
        return buffer.toString();
    }
}
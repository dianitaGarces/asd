package com.asd.activos.dominio;

import java.io.Serializable;
import java.util.List;

public class ListaDTO extends BaseDTO implements Serializable{
	
	 private static final long serialVersionUID = 3L;

	List<?> lista;

	public List<?> getLista() {
		return lista;
	}

	public void setLista(List<?> lista) {
		this.lista = lista;
	}
	
	
	
}

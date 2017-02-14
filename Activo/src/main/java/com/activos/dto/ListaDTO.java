package com.activos.dto;

import java.io.Serializable;
import java.util.List;

public class ListaDTO extends BaseDTO implements Serializable{
	
	 private static final long serialVersionUID = 3L;

	List<ActivoDTO> lista;

	public List<ActivoDTO> getLista() {
		return lista;
	}

	public void setLista(List<ActivoDTO> lista) {
		this.lista = lista;
	}
	
	
	
}

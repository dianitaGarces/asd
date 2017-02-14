package com.web.servicios;

import java.io.Serializable;

import com.web.dto.ActivoDTO;
import com.web.dto.BaseDTO;
import com.web.dto.ListaDTO;

public interface ServicioActivo extends Serializable {
	
	public BaseDTO agregarActivo(ActivoDTO activo);

	public BaseDTO actualizaActivo(ActivoDTO activo) ;

	public ListaDTO consultarActivo(String fecha, String serial, String tipo) ;

	public ListaDTO consultarTipoActivo();
}

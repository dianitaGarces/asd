package com.activos.logica;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import com.activos.dto.ActivoDTO;
import com.activos.dto.BaseDTO;
import com.activos.dto.ListaDTO;

public interface ServicioActivo extends Serializable {
	
	public BaseDTO agregarActivo(ActivoDTO activo);

	public BaseDTO actualizaActivo(ActivoDTO activo) ;

	public ListaDTO consultarActivo(String fecha, Integer serial, String tipo) ;
	
	public ListaDTO consultarActivo();

}

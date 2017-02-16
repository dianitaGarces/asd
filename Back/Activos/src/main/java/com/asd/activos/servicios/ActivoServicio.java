package com.asd.activos.servicios;

import java.io.Serializable;
import java.util.List;

import com.asd.activos.dominio.Activo;
import com.asd.activos.dominio.BaseDTO;
import com.asd.activos.dominio.Tipo;

public interface ActivoServicio extends Serializable {

    public List<Tipo> getTipoActivo() ;
    
    public List<Activo> getActivo(Integer serial, String fecha, String tipo) ;
    
    public BaseDTO agregarActivo(Activo activo) ;
    
	public BaseDTO actualizarActivo(Activo activo) ;

}
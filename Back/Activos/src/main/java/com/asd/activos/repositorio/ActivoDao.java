package com.asd.activos.repositorio;

import java.util.List;

import com.asd.activos.dominio.Activo;
import com.asd.activos.dominio.BaseDTO;
import com.asd.activos.dominio.Tipo;

public interface ActivoDao {

    public List<Tipo> getTipoActivo();
    
    public List<Activo> getActivo(Integer serial, String fecha, String tipo) ;
    
    public BaseDTO agregarActivo(Activo activo) ;
    
    public BaseDTO actualizar(Activo activo) ;
  
}
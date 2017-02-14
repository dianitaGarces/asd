package com.activos.logica;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activos.dto.ActivoDTO;
import com.activos.dto.BaseDTO;
import com.activos.dto.ListaDTO;
import com.activos.enums.CodigoRespuesta;
import com.activos.mapper.ConsultaActivo;
import com.activos.mapper.TransaccionalActivo;

@Service("servicioActivo")
public class ServicioActivoImpl  implements ServicioActivo{

	private static final long serialVersionUID = 2L;

	@Autowired
	ConsultaActivo consultaActivo;

	@Override
	public BaseDTO agregarActivo(ActivoDTO activo) {
		BaseDTO base=new BaseDTO();
		try{
			TransaccionalActivo transaccionalActivo= new TransaccionalActivo();
			transaccionalActivo.agregarActivo(activo);
			base.setCodigo(CodigoRespuesta.EXITO.getNombre());
		}catch(Exception e){
			base.setCodigo(CodigoRespuesta.ERROR.getNombre());
		}
		return base;
	}

	@Override
	public BaseDTO actualizaActivo(ActivoDTO activo) {
		BaseDTO base=new BaseDTO();
		try{
			TransaccionalActivo transaccionalActivo= new TransaccionalActivo();
			transaccionalActivo.actualizarActivo(activo);
			base.setCodigo(CodigoRespuesta.EXITO.getNombre());
		}catch(Exception e){
			base.setCodigo(CodigoRespuesta.ERROR.getNombre());
		}
		return base;
	}

	@Override
	public ListaDTO consultarActivo(String fecha, Integer serial, String tipo) {
		ListaDTO respuesta = new ListaDTO();
		List<ActivoDTO> lista=new ArrayList<ActivoDTO>();
		try{
			lista = consultaActivo.consultarAcivo(fecha, serial, tipo);
			respuesta.setLista(lista);
			respuesta.setCodigo(CodigoRespuesta.EXITO.getNombre());
			respuesta.setMensaje(CodigoRespuesta.EXITO.getNombre());
		}catch(Exception e){
			lista = null;
			respuesta.setCodigo(CodigoRespuesta.ERROR.getNombre());
		}
		return respuesta;
	}
	
	@Override
	public ListaDTO consultarActivo() {
		ListaDTO respuesta = new ListaDTO();
		List<ActivoDTO> lista=new ArrayList<ActivoDTO>();
		try{
			//lista = consultaActivo.obtenerActivo();
			//respuesta.setLista(lista);
			Integer cont = consultaActivo.contar();
			respuesta.setCodigo(CodigoRespuesta.EXITO.getNombre());
			respuesta.setMensaje(CodigoRespuesta.EXITO.getNombre());
		}catch(Exception e){
			lista = null;
			respuesta.setCodigo(CodigoRespuesta.ERROR.getNombre());
			System.err.println("Error consultando: "+e);
		}
		return respuesta;
	}

}
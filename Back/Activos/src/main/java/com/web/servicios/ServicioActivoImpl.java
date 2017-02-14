package com.web.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.dto.ActivoDTO;
import com.web.dto.BaseDTO;
import com.web.dto.ListaDTO;

@Service
public class ServicioActivoImpl implements ServicioActivo {


	private static final long serialVersionUID = 1L;


	public BaseDTO agregarActivo(ActivoDTO activo) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseDTO actualizaActivo(ActivoDTO activo) {
		// TODO Auto-generated method stub
		return null;
	}


	public ListaDTO consultarActivo(String fecha, String serial, String tipo) {
		ListaDTO respuesta = new ListaDTO();
		List<ActivoDTO> lista=new ArrayList<ActivoDTO>();
		try{
			ActivoDTO filtro = new ActivoDTO();
			if(tipo != null)
			{
				if(tipo != "")
				filtro.setId_tipo(Integer.parseInt(tipo));
			}
			if(serial!= null){
				if(serial != "")
				filtro.setSerial(Integer.parseInt(serial));
			}
			if(fecha != null) {
				if(tipo != "")
				filtro.setFecha_compra(fecha);
			}			
			
			//lista = consultaActivo.obtenerActivoFiltro(filtro);
			respuesta.setLista(lista);
			respuesta.setCodigo("OK");
			//respuesta.setMensaje(CodigoRespuesta.EXITO.getNombre());
		}catch(Exception e){
			lista = null;
			respuesta.setCodigo("Error");
		}
		return respuesta;
	}

	public ListaDTO consultarTipoActivo() {
		// TODO Auto-generated method stub
		return null;
	}

}

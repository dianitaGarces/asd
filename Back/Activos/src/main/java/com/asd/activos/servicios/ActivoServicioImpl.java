package com.asd.activos.servicios;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asd.activos.dominio.Activo;
import com.asd.activos.dominio.BaseDTO;
import com.asd.activos.dominio.Tipo;
import com.asd.activos.enums.CodigoRespuesta;
import com.asd.activos.repositorio.ActivoDao;

@Component
public class ActivoServicioImpl implements ActivoServicio {

	private static final long serialVersionUID = 1L;

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ActivoDao productDao;

	/**
	 * Metodo encargado de validar el activo y llamar
	 * al metodo de BD para insertar
	 */
	public BaseDTO agregarActivo(Activo activo) {
		BaseDTO respuesta = new BaseDTO();
		try{
			productDao.agregarActivo(activo);
			respuesta.setCodigo(CodigoRespuesta.EXITO.name());
			respuesta.setMensaje(CodigoRespuesta.ERROR.getNombre());
		}catch (Exception e) {
			respuesta.setCodigo(CodigoRespuesta.ERROR.name());
			respuesta.setMensaje(CodigoRespuesta.ERROR.getNombre());
			logger.error("Error insertando"+e.getMessage());
		}
		return respuesta;
	}
	/**
	 *Metodo encargado de validar el activo y llamar
	 * al metodo de BD para actualizar
	 */
	public BaseDTO actualizarActivo(Activo activo) {

		BaseDTO respuesta = new BaseDTO();
		try{
			productDao.actualizar(activo);
			respuesta.setCodigo(CodigoRespuesta.EXITO.name());
			respuesta.setMensaje(CodigoRespuesta.ERROR.getNombre());
		}catch (Exception e) {
			respuesta.setCodigo(CodigoRespuesta.ERROR.name());
			respuesta.setMensaje(CodigoRespuesta.ERROR.getNombre());
			logger.error("Error insertando"+e.getMessage());
		}
		return respuesta;
	}

	public List<Tipo> getTipoActivo() {
		return productDao.getTipoActivo();
	}

	public List<Activo> getActivo(Integer serial, String fecha, String tipo) {
		if(serial != null){
			if(serial.equals("")){
				serial = null;
			}
		}
		if(fecha != null){
			if(fecha.equals("")){
				fecha = null;
			}
		}
		if(tipo != null){
			if(tipo.equals("")){
				tipo = null;
			}
		}
		return productDao.getActivo( serial,  fecha,  tipo) ;
	}


}
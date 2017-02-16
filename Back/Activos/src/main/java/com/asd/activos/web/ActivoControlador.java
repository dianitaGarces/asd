package com.asd.activos.web;


import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asd.activos.dominio.Activo;
import com.asd.activos.dominio.BaseDTO;
import com.asd.activos.dominio.ListaDTO;
import com.asd.activos.dominio.Tipo;
import com.asd.activos.enums.CodigoRespuesta;
import com.asd.activos.servicios.ActivoServicio;

@Controller
public class ActivoControlador {

	protected final Log logger = LogFactory.getLog(getClass());


	private static final String PATH_CONSULTA_ACTIVO = "/Activos";
	private static final String PATH_CONSULTA_TIPO_ACTIVO = "/consultarTipoActivo";
	private static final String PATH_AGREGAR_ACTIVO = "/agregarActivo";	
	private static final String PATH_ACTUALIZAR_ACTIVO = "/actualizarActivo";


	@Autowired
	private ActivoServicio activoServicio;

	/**
	 * Servicio que  consulta los activos disponibles
	 * haciendo llamado a la clase de servicios 
	 * @param model
	 * @param principal 
	 * @param fecha fecha de compra
	 * @param tipo tipo de activo a consultar
	 * @param serial serial del activo
	 * @return 200 consulta exitosa, 400 sin información y 500 otro tipo de error
	 * @throws Exception
	 */	
	@RequestMapping(value = PATH_CONSULTA_ACTIVO, params={"fecha","tipo","serial"},  
			method = RequestMethod.GET , 
			produces="application/json; charset=UTF-8",
			headers = "Accept="+MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaDTO> consultarActivo(ModelMap model, Principal principal, @RequestParam String fecha,@RequestParam String tipo, 
			@RequestParam Integer serial) throws Exception{
		ListaDTO respuesta = new ListaDTO();
		try {
			String now = (new Date()).toString();

			List<Activo> lista= this.activoServicio.getActivo(serial, fecha, tipo);
			if(lista.isEmpty()){
				respuesta.setCodigo(CodigoRespuesta.NREG.name());
				respuesta.setMensaje(CodigoRespuesta.NREG.getNombre());
			}
			else{
				respuesta.setLista(lista);
				respuesta.setCodigo(CodigoRespuesta.EXITO.name());
				respuesta.setMensaje(CodigoRespuesta.EXITO.getNombre());
			}
		} catch (Exception e) {

			respuesta =  new ListaDTO();
			respuesta.setCodigo(CodigoRespuesta.ERROR.name());
			respuesta.setMensaje(CodigoRespuesta.ERROR.getNombre());
			logger.error(respuesta.getMensaje(), e);
		}
		if(respuesta.getCodigo().equals(CodigoRespuesta.EXITO.name())){
			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.OK);
		}else if(respuesta.getCodigo().equals(CodigoRespuesta.NREG.name())){
			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.NOT_FOUND);
		}
		else{
			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	/**
	 * Servicio que  consulta los activos disponibles
	 * haciendo llamado a la clase de servicios 
	 * @param model
	 * @param principal 
	 * @param fecha fecha de compra
	 * @param tipo tipo de activo a consultar
	 * @param serial serial del activo
	 * @return 200 consulta exitosa, 400 sin información y 500 otro tipo de error
	 * @throws Exception
	 */
	@RequestMapping(value = PATH_CONSULTA_TIPO_ACTIVO,   
			method = RequestMethod.GET , produces="application/json; charset=UTF-8",
			headers = "Accept="+MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaDTO> consultarTipo(ModelMap model, Principal principal) throws Exception{
		ListaDTO respuesta = new ListaDTO();
		try{
			String now = (new Date()).toString();
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("now", now);
			myModel.put("tb_tipo", this.activoServicio.getTipoActivo());

			List<Tipo> lista= this.activoServicio.getTipoActivo();

			if(lista.isEmpty()){
				respuesta.setCodigo(CodigoRespuesta.NREG.name());
				respuesta.setMensaje(CodigoRespuesta.NREG.getNombre());
			}
			else{
				respuesta.setLista(lista);
				respuesta.setCodigo(CodigoRespuesta.EXITO.name());
				respuesta.setMensaje(CodigoRespuesta.EXITO.getNombre());
			}
		} catch (Exception e) {

			respuesta =  new ListaDTO();
			respuesta.setCodigo(CodigoRespuesta.ERROR.name());
			respuesta.setMensaje(CodigoRespuesta.ERROR.getNombre());
			logger.error(respuesta.getMensaje(), e);
		}
		if(respuesta.getCodigo().equals(CodigoRespuesta.EXITO.name())){
			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.OK);
		}else if(respuesta.getCodigo().equals(CodigoRespuesta.NREG.name())){
			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.NOT_FOUND);
		}
		else{
			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Metodo encrgado de insertar nuevos activos.
	 * @param model
	 * @param principal
	 * @param dto: objeto tipo Activo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = PATH_AGREGAR_ACTIVO,  
			method = RequestMethod.POST, 
			produces="application/json; charset=UTF-8",
			headers = "Accept="+MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseDTO> crearActivo(ModelMap model, Principal principal, @RequestBody Activo dto) throws Exception{

		BaseDTO respuesta = new BaseDTO();
		try {
			respuesta = activoServicio.agregarActivo(dto);
			respuesta.setCodigo(CodigoRespuesta.EXITO.name());
			respuesta.setMensaje(CodigoRespuesta.EXITO.getNombre());
		} catch (Exception e) {
			respuesta.setCodigo(CodigoRespuesta.ERROR.name());
			respuesta.setMensaje(CodigoRespuesta.ERROR.getNombre());
			logger.error("Agregando activo", e);
		}
		if(!respuesta.getCodigo().equals(CodigoRespuesta.ERROR.name())){
			return new ResponseEntity<BaseDTO>(respuesta, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<BaseDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/**
	 * Metodo que realiza la actualizacion de un activo,
	 * este se encarga de validar que exista el activo
	 * y que actualice la información
	 * @param model
	 * @param principal
	 * @param dto: con objeto tipo activo.
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = PATH_ACTUALIZAR_ACTIVO,  
			method = RequestMethod.PUT, 
			produces="application/json; charset=UTF-8",
			headers = "Accept="+MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseDTO> actualizarActivo(ModelMap model, 
			Principal principal, @RequestBody Activo dto) throws Exception{
		BaseDTO respuesta = new BaseDTO();
		try {
			respuesta = activoServicio.actualizarActivo(dto);
			respuesta.setCodigo(CodigoRespuesta.EXITO.name());
			respuesta.setMensaje(CodigoRespuesta.EXITO.getNombre());
		} catch (Exception e) {
			respuesta.setCodigo(CodigoRespuesta.ERROR.name());
			respuesta.setMensaje(CodigoRespuesta.ERROR.getNombre());
			logger.error("Actualizando activo: ", e);
		}
		if(!respuesta.getCodigo().equals(CodigoRespuesta.ERROR.name())){
			return new ResponseEntity<BaseDTO>(respuesta, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<BaseDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
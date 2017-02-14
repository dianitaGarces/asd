package com.activos.rest;

import com.activos.dto.ListaDTO;
import com.activos.enums.CodigoRespuesta;
import com.activos.logica.ServicioActivo;
import com.activos.logica.ServicioActivoImpl;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ActivoRest {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ServicioActivo servicioActivo;


	private static final String PATH_CONSULTA_ACTIVO = "/consultarActivo.htm";

	@RequestMapping(value = PATH_CONSULTA_ACTIVO, params={"fecha","tipo","serial"},  
			method = RequestMethod.GET, headers = "Accept="+MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaDTO> consultarActivo(ModelMap model, Principal principal, @RequestParam String fecha,@RequestParam String tipo, 
			@RequestParam Integer serial) throws Exception{
		ListaDTO respuesta = new ListaDTO();
		respuesta = servicioActivo.consultarActivo();
		logger.info("Returning hello view");
		if(respuesta.getCodigo().equals(CodigoRespuesta.EXITO.getNombre())){
			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.OK);
		}else{
			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	public void agregarActivo() {
	}

	public void actualizarActivo() {
	}

	

	@RequestMapping(value = PATH_CONSULTA_ACTIVO, params={""},  
			method = RequestMethod.GET, headers = "Accept="+MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaDTO> consultarActivo(ModelMap model, Principal principal) throws Exception{
		ListaDTO respuesta = new ListaDTO();
		respuesta = servicioActivo.consultarActivo();
		logger.info("Returning hello view");
		if(respuesta.getCodigo().equals(CodigoRespuesta.EXITO.getNombre())){
			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.OK);
		}else{
			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	 @RequestMapping(value="/hello.htm")
	    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        logger.info("Returning hello view");

	        return new ModelAndView("hello.jsp");
	    }
}
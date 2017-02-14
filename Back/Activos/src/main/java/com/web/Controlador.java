package com.web;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.dto.ListaDTO;
import com.web.servicios.ServicioActivo;


@Controller
public class Controlador {

	protected final Log logger = LogFactory.getLog(getClass());

	
	private static final String PATH_CONSULTA_ACTIVO = "/Activos";
	private static final String PATH_CONSULTA_TIPO_ACTIVO = "api/consultarTipoActivo";
	private static final String PATH_AGREGAR_ACTIVO = "api/agregarActivo";	
	private static final String PATH_ACTUALIZAR_ACTIVO = "api/actualizarActivo";

	@Autowired
	private ServicioActivo servicio;
	
	@RequestMapping(value="/hello.htm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String now = (new Date()).toString();
		servicio.consultarActivo(null, null, null);
        logger.info("Returning hello view with " + now);

        return new ModelAndView("WEB-INF/views/hello.jsp", "now", now);

        
	}

	@RequestMapping(value = PATH_CONSULTA_ACTIVO, params={"fecha","tipo","serial"},  
			method = RequestMethod.GET)
	public ResponseEntity<ListaDTO> consultarActivo(ModelMap model, Principal principal, @RequestParam String fecha,@RequestParam String tipo, 
			@RequestParam String serial) throws Exception{
		ListaDTO respuesta = new ListaDTO();

		respuesta = servicio.consultarActivo(fecha,serial, tipo);

		if(respuesta.getCodigo().equals("OK")){
			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.OK);
		}else{
			return new ResponseEntity<ListaDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
package com.asd.activos.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asd.activos.dominio.Activo;
import com.asd.activos.dominio.BaseDTO;
import com.asd.activos.dominio.Tipo;
import com.asd.activos.enums.CodigoRespuesta;

@Repository(value = "productDao")
public class JPAActivoDao implements ActivoDao {

	private EntityManager em = null;
	protected final Log logger = LogFactory.getLog(getClass());

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	/**
	 * Encargado de consultar los tipos de activos que se encuentran en la base de datos.
	 */
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Tipo> getTipoActivo() {
		List<Tipo> lista = null;
		try{
			lista=em.createQuery("select p from Tipo p").getResultList();
		}catch(Exception e){
			logger.error("Error bd al consultar tipo: ",e);
		}
		return  lista;
	}

	/**
	 * Encargado de consultar los activos que se encuentran en la base de datos.
	 */
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Activo> getActivo(Integer serial, String fecha, String tipo) {
		List<Activo> lista = null;
		try{
			String sql=null, sql2=null , sql3=null;
			/*
			if(serial!= null)
				sql = " serial = "+serial;
			if( fecha!= null )
				sql2 = " fecha = "+fecha;
			if( tipo!= null)
				sql3 = " id_tipo = "+tipo;

			if(sql != null && sql2!= null)
				sql = " where "+sql+" and  "+sql2;
			if(sql != null && sql3!= null)
				sql = " where "+sql+" and  "+sql3;*/


			lista=em.createQuery("select p from Activo p "
					+ " where id_tipo = ifnull("+tipo+",id_tipo) "
					+ " and fecha_compra = ifnull("+fecha+",fecha_compra) "
					+ " and serial = ifnull("+serial+",serial)").getResultList();			

			//List<Activo> lista=em.createQuery("select p, t from Activo p, Tipo t where t.id_tipo = p.id_tipo").getResultList();
		}catch(Exception e){
			logger.error("Error bd al consultar activo: ",e);
		}
		return  lista;
	}


	/**
	 * Encargado de actualizar los activos.
	 */
	@Transactional(readOnly = false)
	public BaseDTO actualizar(Activo activo) {
		BaseDTO rpta = new BaseDTO();
		try{		
			em.merge(activo);
			rpta.setCodigo(CodigoRespuesta.EXITO.name());
		}catch(Exception e){
			logger.error("Error al actualizar BD: ",e);
			rpta.setCodigo(CodigoRespuesta.ERROR.name());
		}
		return rpta;
	}


	/**
	 * Encargado de insertar los activos.
	 */
	@Transactional(readOnly = false)
	public BaseDTO agregarActivo(Activo activo) {
		BaseDTO rpta = new BaseDTO();
		try{		
			em.getTransaction().begin();
			em.persist(activo);
			em.getTransaction().commit();
			rpta.setCodigo(CodigoRespuesta.EXITO.name());			
		}catch(Exception e){
			logger.error("Error al insertar bd : ",e);
			rpta.setCodigo(CodigoRespuesta.ERROR.name());
		}
		return rpta;
	}


}

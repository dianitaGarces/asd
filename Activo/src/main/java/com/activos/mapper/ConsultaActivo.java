package com.activos.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.activos.dto.ActivoDTO;
import com.activos.logica.ServicioActivoImpl;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.annotation.*;
import org.mybatis.spring.mapper.*;

@Mapper
public interface ConsultaActivo {


	@Select(" select ID, SERIAL, NOMBRE, DESCRIPCION, PESO, ALTO, ANCHO, LARGO, FECHA_COMPRA, "
			+ " ID_TIPO, ID_ESTADO"
			+ " from tb_activo ")
	public List<ActivoDTO> consultarAcivo(String fecha, Integer serial, String tipo) ;

	@Select(" select SERIAL, NOMBRE, DESCRIPCION, PESO, ALTO, ANCHO, LARGO "
			+ " from tb_activo ")
	public List<ActivoDTO> obtenerActivo();
	
	@Select(" select count(1) "
			+ " from tb_activo ")
	public Integer contar();

}
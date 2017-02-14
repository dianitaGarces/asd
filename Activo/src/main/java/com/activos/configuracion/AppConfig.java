package com.activos.configuracion;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@EnableTransactionManagement
@Configuration
@MapperScan("com.activos.mapper")
public class AppConfig{



	@Bean(destroyMethod="")
	public DataSource getDataSource() {

		System.out.println("Entra a conexion a base de datos ");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@Diana:1521:bdorcl");
		dataSource.setUsername("sys");
		dataSource.setPassword("Diana");

		return dataSource;		
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {

		return new DataSourceTransactionManager(getDataSource());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		return sessionFactory.getObject();
	}


	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(20971520);
		return resolver;
	}

}

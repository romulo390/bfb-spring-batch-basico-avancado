package com.udemy.primeiroprojetospringbatch.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.udemy.primeiroprojetospringbatch.config.QueriesEnvironment;
import com.udemy.primeiroprojetospringbatch.dominio.Cliente;
import com.udemy.primeiroprojetospringbatch.mapper.ClienteRowMapper;

@Component
public class ClienteDao extends JdbcDaoSupport {

	@Autowired
	private QueriesEnvironment queries;

	public NamedParameterJdbcTemplate jdbcTemplate;

	public ClienteDao(@Qualifier("appDataSource") DataSource dataSource, QueriesEnvironment queries) {
		super.setDataSource(dataSource);
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.queries = queries;		
	}
	
	public List<Cliente> getClientes(){
		List<Cliente> queryResult = jdbcTemplate.query(queries.getQueryCliente(), new ClienteRowMapper());
		return queryResult;
	}
}

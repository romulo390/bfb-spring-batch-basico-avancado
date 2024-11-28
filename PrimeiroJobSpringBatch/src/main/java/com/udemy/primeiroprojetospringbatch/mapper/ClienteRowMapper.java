package com.udemy.primeiroprojetospringbatch.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.udemy.primeiroprojetospringbatch.dominio.Cliente;

public class ClienteRowMapper implements RowMapper<Cliente> {

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setNome(rs.getString("nome"));
		cliente.setSobrenome(rs.getString("sobrenome"));
		cliente.setIdade(rs.getString("idade"));
		cliente.setEmail(rs.getString("email"));
				
		return cliente;
	}

}

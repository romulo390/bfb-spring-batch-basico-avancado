package com.udemy.primeiroprojetospringbatch.reader;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.udemy.primeiroprojetospringbatch.config.QueriesEnvironment;
import com.udemy.primeiroprojetospringbatch.dao.ClienteDao;
import com.udemy.primeiroprojetospringbatch.dominio.Cliente;
import com.udemy.primeiroprojetospringbatch.mapper.ClienteRowMapper;

@Configuration
public class JdbcCursorReaderConfig implements ItemReader<Cliente> {
	
	private List<Cliente> clientes;
	private int index = 0;
	
	@Autowired
	private QueriesEnvironment queries;

	public NamedParameterJdbcTemplate jdbcTemplate;

	public JdbcCursorReaderConfig(@Qualifier("springDataSource") DataSource dataSource, QueriesEnvironment queries) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.queries = queries;		
	}
	
	@Override
	public Cliente read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		Cliente clienteRequest = null;
		if(clientes != null && index < clientes.size()) {
			clienteRequest = clientes.get(index);
			index ++;
		}else {
			index = 0;
		}
		return clienteRequest;
	}
	
	@BeforeStep
	public void getClientes(){
		this.clientes = jdbcTemplate.query(queries.getQueryCliente(), new ClienteRowMapper());
	}
//	
//	@Bean
//	@Qualifier(Constants.JOB2_STEP_READER_NAME)
//	public JdbcCursorItemReader<Cliente> jdbcCursorItemReader(
//			@Qualifier("appDataSource") DataSource dataSource){
//		return new JdbcCursorItemReaderBuilder<Cliente>()
//				.name("jdbcCursorItemReader")
//				.dataSource(dataSource)
//				.sql(NamedParameterUtils.substituteNamedParameters(queries.getQueryCliente(),))
//				//.sql("queryCliente")
//				.rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
//				.build();
//	}
}

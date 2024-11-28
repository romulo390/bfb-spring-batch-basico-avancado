package com.udemy.primeiroprojetospringbatch.step;

import javax.sql.DataSource;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udemy.primeiroprojetospringbatch.config.QueriesEnvironment;
import com.udemy.primeiroprojetospringbatch.constants.Constants;
import com.udemy.primeiroprojetospringbatch.dao.ClienteDao;
import com.udemy.primeiroprojetospringbatch.dominio.Cliente;
import com.udemy.primeiroprojetospringbatch.reader.JdbcCursorReaderConfig;

@Configuration
public class JdbcCursorReaderStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	private DataSource dataSource;
	private QueriesEnvironment query;
	
	@Autowired
	private ClienteDao clienteDao;
	
	public JdbcCursorReaderStepConfig(StepBuilderFactory stepBuilderFactory, DataSource dataSource, QueriesEnvironment query) {
		super();
		this.stepBuilderFactory = stepBuilderFactory;
		this.dataSource = dataSource;
		this.query =query;
	}



	@Bean
	@Qualifier(Constants.JOB2_STEP_NAME)
	public Step jdbcCursorReaderStep(
			//@Qualifier(Constants.JOB2_STEP_READER_NAME) ItemReader<Cliente> jdbcCursorItemReader, 
									 @Qualifier(Constants.JOB2_STEP_WRITER_NAME) ItemWriter<Cliente> jdbcCursorWriter) {
		
		clienteDao = new ClienteDao(dataSource, query);
		return stepBuilderFactory
				.get("jdbcCursorReaderStep")
				.<Cliente, Cliente>chunk(1)
				.reader(new JdbcCursorReaderConfig(dataSource, query))
				.writer(jdbcCursorWriter)
				//.faultTolerant()
				//.skip(Exception.class)
				//.skipLimit(2)
				.build();
	}
}

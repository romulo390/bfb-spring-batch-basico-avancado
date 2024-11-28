package com.udemy.primeiroprojetospringbatch.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udemy.primeiroprojetospringbatch.constants.Constants;
import com.udemy.primeiroprojetospringbatch.dominio.Cliente;

@Configuration
public class JdbcCursorWriterConfig {
	
	@Bean
	@Qualifier(Constants.JOB2_STEP_WRITER_NAME)
	public ItemWriter<Cliente> jdbcCursorWriter() {
		return clientes -> clientes.forEach(System.out::println);
	}
}

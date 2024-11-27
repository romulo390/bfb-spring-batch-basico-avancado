package com.udemy.primeiroprojetospringbatch.reader;



import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.udemy.primeiroprojetospringbatch.dominio.Cliente;

@Configuration
public class ItemReaderLeitroArquivoDelimitado {

	
	@Bean
	@StepScope
	public FlatFileItemReader<Cliente> leituraArquivoDelimitadoReader(
			@Value("#{jobParameters['arquivoClientes']}") Resource arquivoCliente ){
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("leituraArquivoDelimitadoReader")
				.resource(arquivoCliente)
				.delimited()
				.names(new String[] {"nome","sobrenome","idade","email"})
				.targetType(Cliente.class)
				.build();
	}
}

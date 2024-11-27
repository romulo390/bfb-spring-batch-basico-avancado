package com.udemy.primeiroprojetospringbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udemy.primeiroprojetospringbatch.dominio.Cliente;

@Configuration
public class StepLeitorArqDelimitado {

	private StepBuilderFactory stepBuilderFactory;
	
	public StepLeitorArqDelimitado(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory =stepBuilderFactory;
	}
	
	@Bean
	public Step executeStepLeitorArqDelimitado(ItemReader<Cliente> leituraArquivoDelimitadoReader,
										ItemWriter<Cliente> leituraArquivoDelimitadoWriter){
		return stepBuilderFactory
				.get("executeStepLeitorArqDelimitado")
				.<Cliente, Cliente>chunk(10)
				.reader(leituraArquivoDelimitadoReader)
				.writer(leituraArquivoDelimitadoWriter)
				.build();		
	} 
	
}

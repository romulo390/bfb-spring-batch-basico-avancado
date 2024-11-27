package com.udemy.primeiroprojetospringbatch.config;

import java.util.Arrays;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@EnableBatchProcessing
//@Configuration
public class ParImparBatchConfig {

	@Autowired
	private JobBuilderFactory jbbf;
	
	@Autowired
	private StepBuilderFactory stbf;
	
	@Bean
	public Job imprimirParImparJob() {
		return jbbf.get("imprimirParImparJob")
				.start(imprimirParImparStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	private Step imprimirParImparStep() {
		return stbf.get("imprimirParImparStep")
				.<Integer, String>chunk(1)//Integer 'Ler' e String 'Escreve'
				.reader(contaAteDezReader())
				.processor(parOuImparProcessor())
				.writer(imprimeWriter())
				.build();
	}
	
	public IteratorItemReader<Integer> contaAteDezReader() {
		List<Integer> numeroDeUmAteDez = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		return new IteratorItemReader<Integer>(numeroDeUmAteDez.iterator());
	}
	
	public FunctionItemProcessor<Integer, String> parOuImparProcessor() {
		return new FunctionItemProcessor<Integer, String>
		(item -> item % 2  == 0 ? String.format("Item %s eh par", item): String.format("Item %s eh impar", item));
	}

	public ItemWriter<String> imprimeWriter() {
		return write -> write.forEach(System.out::println);
	}
}

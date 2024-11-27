package com.udemy.primeiroprojetospringbatch.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udemy.primeiroprojetospringbatch.dominio.Cliente;

@Configuration
public class ItemWriterLeitorArquivoDelimitado {

	
	@Bean
	ItemWriter<Cliente> leituraArquivoDelimitadoWriter(){
		return items -> items.forEach(System.out::println);
	}
}

package com.udemy.primeiroprojetospringbatch.config;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



//@Data
@Configuration
@ConfigurationProperties("queries")
@PropertySource(value = "classpath:queries.yml", factory = YamlPropertySourceFactory.class)
public class QueriesEnvironment {
	
	private String queryCliente;
	
	

	public String getQueryCliente() {
		return queryCliente;
	}

	public void setQueryCliente(String queryCliente) {
		this.queryCliente = queryCliente;
	}
	
	
	
}

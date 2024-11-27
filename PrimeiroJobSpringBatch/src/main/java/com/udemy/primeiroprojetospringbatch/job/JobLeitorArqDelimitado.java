package com.udemy.primeiroprojetospringbatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udemy.primeiroprojetospringbatch.constants.Constants;

@Configuration
@EnableBatchProcessing
public class JobLeitorArqDelimitado {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	@Qualifier(Constants.JOB1_NAME)
	Job executeJobLeitorArqDelimitado(Step executeStepLeitorArqDelimitado) {
		return jobBuilderFactory.get(Constants.JOB1_NAME)
				.start(executeStepLeitorArqDelimitado)
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
}

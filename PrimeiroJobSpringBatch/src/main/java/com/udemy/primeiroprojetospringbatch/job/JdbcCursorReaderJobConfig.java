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
public class JdbcCursorReaderJobConfig {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Bean
	@Qualifier(Constants.JOB2_NAME)
	public Job jdbcCursorReaderJob(@Qualifier(Constants.JOB2_STEP_NAME) Step jdbcCursorReaderStep) {
		return jobBuilderFactory
				.get(Constants.JOB2_NAME)
				.start(jdbcCursorReaderStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}

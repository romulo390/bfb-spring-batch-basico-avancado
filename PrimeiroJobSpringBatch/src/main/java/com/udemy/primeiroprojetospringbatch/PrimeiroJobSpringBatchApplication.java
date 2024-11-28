package com.udemy.primeiroprojetospringbatch;

import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.primeiroprojetospringbatch.constants.Constants;

@SpringBootApplication
public class PrimeiroJobSpringBatchApplication {

	public static void main(String[] args) {
		if(Objects.nonNull(args)) {
			for (int i = 0; i < args.length; i++) {
				if(args[i].trim().startsWith("job")) {
					if (args[i].equalsIgnoreCase(Constants.JOB1_NAME)) {						
						args[i] = Constants.JOB1_NAME;
					}else if(args[i].equalsIgnoreCase("jdbcCursorReaderJob")) {
						args[i] = "jdbcCursorReaderJob";
					}
				}
				System.setProperty("spring.batch.job.names", args[i]);
			}
		}
		
		SpringApplication.run(PrimeiroJobSpringBatchApplication.class, args);
	}
}

package com.udemy.primeiroprojetospringbatch.tasklet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
//@StepScope
public class ImprimeOlaTasklet implements Tasklet {
//   
//	@Value("#{jobParameters['nome']}")
//    private String nome;
   
    //arquivoClientes=file:files/clientes.txt

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        
//    	org.springframework.batch.core.StepExecution se = 
    						//chunkContext.getStepContext().getStepExecution();
//    	String dt = se.getJobParameters().getString("nome");
    	
    	
//    	//System.out.println("Data atual: "+date);
//    	LocalDate localDate = LocalDate.now();
//    	//localDate  = LocalDate.parse;
//    	LocalDate localDateAntigo = LocalDate.of(2023, 5,5);
//    	
//    	Period periodo = Period.between(localDateAntigo, localDate);
    	

//    	System.out.println("Data atual: "+localDate);
//    	localDate  = LocalDate.parse(dt,DateTimeFormatter.ofPattern("uuuu-MM-dd"));
//    	System.out.println("Data passada por parametro: "+ localDate);
//    	//localDate  = LocalDate.parse(dt,SimpleDateFormat.format("uuuu-MM-dd"));
//    	
//         java.sql.Date date = java.sql.Date.valueOf(localDate);
//      
//         SimpleDateFormat formatador = new SimpleDateFormat("uuuu-MM-dd");
//        String dataFormatada = formatador.format (date);
//        System.out.println("Data formatada corretamente: "+ dataFormatada);
    	
    //	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");
    	    	
//    	LocalDate localDate = LocalDate.now(); //
//    	if(nome != null && !nome.isEmpty()) {
//    		localDate = LocalDate.parse(this.nome, DateTimeFormatter.BASIC_ISO_DATE);
//    		///System.out.println("Data com parse: "+date);
//    	}
//    		dataTrmsDate  = LocalDate.parse(dt,DateTimeFormatter.ofPattern("uuuu-MM-dd"));
//    	
    	
    	
    	
     //System.out.println(String.format("Olá!"+ localDate));
    	System.out.println("Ola Mundo!!");
		return RepeatStatus.FINISHED;
    }
    
}

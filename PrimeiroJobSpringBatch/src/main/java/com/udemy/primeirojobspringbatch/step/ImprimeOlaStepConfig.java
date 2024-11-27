package com.udemy.primeirojobspringbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimeOlaStepConfig {
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	public Step imprimeOlaStep(Tasklet imprimeOlaTasklet) {
		return this.stepBuilderFactory
				.get("imprimeOlaStep")
				.tasklet(imprimeOlaTasklet)
				.build();
	}
	
	
//	@Bean
//	public Step imprimirParImparStep(){
//		return stepBuilderFactory
//				.get("imprimirParImprarStep")
//				.<Integer, String>chunk(1)
//				.reader(contarAteDezReader())
//				.processor(parOuImparProcessor())
//				.writer(imprimWriter())
//				.build();
//	}
//	
//	public IteratorItemReader<Integer> contarAteDezReader(){
//		List<Integer> numerosDeUmAteDez = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//		return new IteratorItemReader<Integer>(numerosDeUmAteDez.iterator());
//	}
//	
//	public FunctionItemProcessor<Integer, String> parOuImparProcessor(){
//		return new FunctionItemProcessor<Integer, String>
//		(item -> item % 2 == 0 ? String.format("Item %s é Par", item): String.format("Item %s é Impar", item));
//	}
//	
//	public ItemWriter<String> imprimWriter(){
//		return items-> items.forEach(System.out::println);
//	}
	


//	@Bean
//	@StepScope
//	public Tasklet imprimeOlaTasklet(@Value("#{jobParameters['nome']}") String nome) {
//		return new Tasklet() {
//			
//			@Override
//			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//				System.out.println("Olá,"+ nome);
//				return RepeatStatus.FINISHED;
//			}
//		};
//	}

}

package com.devsuperior.springbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
@Configuration
public class PrintHelloStepConfig {

	/**
     * Configura um Step do Spring Batch.
     * 
     * @param jobRepository o repositório de jobs que armazena o estado e metadados do Step
     * @param transactionManager o gerenciador de transações para controle de commit e rollback
     * @return uma instância configurada de Step
     */
    @Bean
    public Step printHelloStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,Tasklet printHelloTasklet) {
        return new StepBuilder("step", jobRepository) // Cria um Step com o nome "step" usando o repositório especificado
                .tasklet(printHelloTasklet, transactionManager) // Configura o gerenciador de transações para o Step
                .build(); // Constrói o Step
    }
}

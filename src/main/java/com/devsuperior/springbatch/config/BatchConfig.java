package com.devsuperior.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

    /**
     * Configura um Job do Spring Batch.
     * 
     * @param jobRepository o repositório de jobs que armazena o estado e metadados do Job
     * @param step o Step que será executado como parte deste Job
     * @return uma instância configurada de Job
     */
    @Bean
    public Job job(JobRepository jobRepository, Step PrintHelloStep) {
        return new JobBuilder("job", jobRepository) // Cria um Job com o nome "job" usando o repositório especificado
                .start(PrintHelloStep) // Define o Step inicial deste Job
                .incrementer(new RunIdIncrementer())// incrementa...
                .build(); // Constrói o Job
    }

    
}

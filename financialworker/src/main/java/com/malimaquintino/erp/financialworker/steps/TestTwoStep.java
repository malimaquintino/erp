package com.malimaquintino.erp.financialworker.steps;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class TestTwoStep {
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step testTwo() {
        return stepBuilderFactory
                .get("testTwo")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("Test two !!!!!!!!");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }
}

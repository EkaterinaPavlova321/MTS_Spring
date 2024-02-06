package ru.mts.hw6;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


@Configuration
public class Config {

    @Bean
    @Scope("prototype")
    public CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl();
    }

    @Bean
    public AnimalsRepository animalsRepository() {
        return new AnimalsRepositoryImpl();
    }

    @Bean
    public CreateAnimalServiceBeanPostProcessor createAnimalServiceBeanPostProcessor(){
        return new CreateAnimalServiceBeanPostProcessor();
    }
}

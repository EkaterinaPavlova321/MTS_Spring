package ru.mts.hw6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.hw6.Bpp.CreateAnimalServiceBeanPostProcessor;
import ru.mts.hw6.repository.AnimalsRepository;
import ru.mts.hw6.repository.AnimalsRepositoryImpl;
import ru.mts.hw6.service.CreateAnimalService;
import ru.mts.hw6.service.CreateAnimalServiceImpl;


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

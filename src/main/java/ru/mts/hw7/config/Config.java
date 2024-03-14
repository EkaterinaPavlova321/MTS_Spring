package ru.mts.hw7.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.mts.animalstarter.bpp.CreateAnimalServiceBeanPostProcessor;
import ru.mts.animalstarter.service.CreateAnimalService;
import ru.mts.animalstarter.service.CreateAnimalServiceImpl;
import ru.mts.hw7.repository.AnimalsRepository;
import ru.mts.hw7.repository.AnimalsRepositoryImpl;


@Configuration
public class Config {



    @Bean(initMethod = "initialize")
    public AnimalsRepository animalsRepository() {
        return new AnimalsRepositoryImpl();
    }


    @Bean
    @Scope("prototype")
    public CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl();
    }

//    @Bean
//    public AnimalsRepository animalsRepository() {
//        return new AnimalsRepositoryImpl();
//    }

    @Bean
    public CreateAnimalServiceBeanPostProcessor createAnimalServiceBeanPostProcessor(){
        return new CreateAnimalServiceBeanPostProcessor();
    }
}

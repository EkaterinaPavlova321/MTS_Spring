package ru.mts.animalstarter.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.animalstarter.bpp.CreateAnimalServiceBeanPostProcessor;
import ru.mts.animalstarter.service.CreateAnimalService;
import ru.mts.animalstarter.service.CreateAnimalServiceImpl;


//@ComponentScan(basePackages = {"ru.mts.animalstarter.service"})
//@ComponentScan("ru.mts.animalstarter")
@ComponentScan(basePackages = {"ru.mts.animalstarter.service", "ru.mts.hw7.repository"})

@Configuration
public class Config {

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

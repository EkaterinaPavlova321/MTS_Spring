package ru.mts.animalstarter.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import ru.mts.animalstarter.service.CreateAnimalService;
import ru.mts.animalstarter.animalFactory.AnimalType;

public class CreateAnimalServiceBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CreateAnimalService) {
            // Инициализируем поле AnimalType с помощью логики (например, установим случайный тип)
            AnimalType[] types = AnimalType.values();
            ((CreateAnimalService) bean).setAnimalType();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

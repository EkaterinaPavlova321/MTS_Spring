package ru.mts.hw6.Bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import ru.mts.hw6.AnimalFactory.AnimalType;
import ru.mts.hw6.service.CreateAnimalService;

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

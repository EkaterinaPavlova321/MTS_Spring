package ru.mts.hw7.sheduler;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ru.mts.animalstarter.entity.Animal;
//import ru.mts.hw7.entity.Animal;
import ru.mts.hw7.repository.AnimalsRepository;

@Component
@EnableScheduling
public class AnimalScheduler {


    private final AnimalsRepository animalsRepository;



    public AnimalScheduler(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    @Scheduled(fixedRate = 60000) // Метод будет вызываться раз в минуту
    public void printEveryMinute() {
        System.out.println("Calling AnimalsRepository methods:");


        String[] Names = animalsRepository.getNameAnimals();
        for (String name : Names) {
            System.out.println(name);
        }
        // Вызов методов AnimalsRepository и вывод результатов
        System.out.println("Names of animals born in a leap year:");
        String[] leapYearNames = animalsRepository.findLeapYearNames();
        for (String name : leapYearNames) {
            System.out.println(name);
        }

        System.out.println("Animals older than 10 years:");
        Animal[] olderAnimals = animalsRepository.findOlderAnimal(10);
        for (Animal animal : olderAnimals) {
            System.out.println(animal);
        }

        System.out.println("Duplicates:");
        animalsRepository.printDuplicate();
    }
}

package ru.mts.hw7.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.mts.animalstarter.service.CreateAnimalService;

import ru.mts.animalstarter.entity.Animal;

import javax.annotation.PostConstruct;
//import jakarta.annotation.PostConstruct;


import java.util.*;


@Repository
//@Service
//@Component
public class AnimalsRepositoryImpl implements AnimalsRepository {
    private final List<Animal> animalsList = new ArrayList<>(); // Инициализируем список здесь

    @Autowired
    private CreateAnimalService createAnimalService;

    public AnimalsRepositoryImpl() {}

    @PostConstruct
    public void initialize() {
        // Заполняем хранилище животными с использованием CreateAnimalService
        Animal[] newAnimals = (Animal[]) createAnimalService.createAnimals(10);
        for (Animal animal : newAnimals) {
            animalsList.add(animal);
        }
    }

    @Override
    public String[] findLeapYearNames() {
        List<String> leapYearNames = new ArrayList<>();
        for (Animal animal : animalsList) {
            if (animal.getBirthDate().getYear() % 4 == 0) {
                leapYearNames.add(animal.getName());
            }
        }
        return leapYearNames.toArray(new String[0]);
    }

    @Override
    public Animal[] findOlderAnimal(int age) {
        List<Animal> olderAnimals = new ArrayList<>();
        for (Animal animal : animalsList) {
            if ((2023 - animal.getBirthDate().getYear()) > age) {
                olderAnimals.add(animal);
            }
        }
        return olderAnimals.toArray(new Animal[0]);
    }

    @Override
    public Set<Animal> findDuplicate() {
        Set<Animal> duplicateAnimals = new HashSet<>();
        Set<Animal> uniqueAnimals = new HashSet<>();

        for (Animal animal : animalsList) {
            if (!uniqueAnimals.add(animal)) {
                duplicateAnimals.add(animal);
            }
        }
        return duplicateAnimals;
    }

    @Override
    public void printDuplicate() {
        Set<Animal> duplicateAnimals = findDuplicate();
        if (!duplicateAnimals.isEmpty()) {
            System.out.println("Дубликаты животных:");
            for (Animal animal : duplicateAnimals) {
                System.out.println(animal + ", количество: " + Collections.frequency(animalsList, animal));
            }
        } else {
            System.out.println("Дубликаты животных не найдены");
        }
    }


    public String[] getNameAnimals(){
        List<String> listNames = new ArrayList<>();
        if (animalsList.isEmpty()){
            System.out.println("empty");
        }
        else {
            for (Animal animal : animalsList) {
                listNames.add(animal.getName());
            }
        }
        return listNames.toArray(new String[0]);
    }
}

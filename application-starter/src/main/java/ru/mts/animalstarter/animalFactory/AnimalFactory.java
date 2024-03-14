package ru.mts.animalstarter.animalFactory;

import ru.mts.animalstarter.entity.*;
import ru.mts.animalstarter.service.RandomDate;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static ru.mts.animalstarter.service.CreateAnimalService.random;
import static ru.mts.animalstarter.service.CreateAnimalService.*;

public class AnimalFactory {
    public Animal createAnimal() {
        Animal animal = null;
        int breedIndex = random.nextInt(3);
        int nameIndex = random.nextInt(10);
        int charactersIndex = random.nextInt(5);
        int animalIndex = random.nextInt(4);


        switch (AnimalType.values()[animalIndex]) {

            case DOG:
                animal = new Dog(dogBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(200).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                break;
            case CAT:
                animal = new Cat(catBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                break;
            case WOLF:
                animal = new Wolf(wolfBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                break;
            case SHARK:
                animal = new Shark(sharkBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(3000).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                break;

        }
        System.out.println("Created: " + animal.getBreed() + " - " + animal.getName() + ", cost = " + animal.getCost() + ", dateBith: " + animal.getBirthDate());


        return animal;
    }
}

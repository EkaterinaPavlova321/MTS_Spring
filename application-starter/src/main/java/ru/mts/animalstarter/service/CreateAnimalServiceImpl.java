package ru.mts.animalstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.mts.animalstarter.entity.*;
import ru.mts.animalstarter.animalFactory.AnimalType;
import ru.mts.animalstarter.entity.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;


//@Component
public class CreateAnimalServiceImpl implements CreateAnimalService {

//    private AnimalType animalType;
//
//    public AnimalType getAnimalType() {
//        return animalType;
//    }
//
//    public void setAnimalType() {
//        AnimalType[] animalTypes = AnimalType.values();
//        Random random = new Random();
//        this.animalType = animalTypes[random.nextInt(animalTypes.length)];
//    }
//    public Animal[] createAnimals(int numberOfAnimals){
//        Animal[] animals = new Animal[numberOfAnimals];
//
//
//        for (int i = 0; i < numberOfAnimals; i++){
//            int breedIndex = random.nextInt(3);
//            int nameIndex = random.nextInt(10);
//            int charactersIndex = random.nextInt(5);
//            int animalIndex = random.nextInt(4);
//
//
//            Animal animal;
//
//            switch (AnimalType.values()[animalIndex]) {
//
//                case DOG:
//                    animals[i] = new Dog(dogBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(200).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
//                    break;
//                case CAT:
//                    animals[i] = new Cat(catBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
//                    break;
//                case WOLF:
//                    animals[i] = new Wolf(wolfBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
//                    break;
//                case SHARK:
//                    animals[i] = new Shark(sharkBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(3000).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
//                    break;
//
//            }
//            System.out.println("Created: " + animals[i].getBreed() + " - " + animals[i].getName() + ", cost = " + animals[i].getCost() + ", dateBith: " + animals[i].getBirthDate());
//        }
//
//        return animals;
//    }
//
//
//
//    // Переопределенный метод для создания 10 уникальных животных с использованием цикла do-while
//    @Override
//    public Animal[] createUniqueAnimals() {
//        Animal[] animals = new Animal[10];
//        int count = 0;
//        do {
//
//            int breedIndex = random.nextInt(3);
//            int nameIndex = random.nextInt(10);
//            int charactersIndex = random.nextInt(5);
//            int animalIndex = random.nextInt(4);
//
//
//            Animal animal;
//
//            switch (AnimalType.values()[animalIndex]) {
//
//                case DOG:
//                    animals[count] = new Dog(dogBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(200).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
//                    break;
//                case CAT:
//                    animals[count] = new Cat(catBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
//                    break;
//                case WOLF:
//                    animals[count] = new Wolf(wolfBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
//                    break;
//                case SHARK:
//                    animals[count] = new Shark(sharkBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(3000).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
//                    break;
//
//            }
//            System.out.println("Created: " + animals[count].getBreed() + " - " + animals[count].getName() + " cost = " + animals[count].getCost() + ", dateBith: " + animals[count].getBirthDate());
//            count++;
//        } while (count < 10);
//        return animals;
//    }


    @Autowired
    private Environment environment;
    private AnimalType animalType;

    Random random = new Random();

    @Value("${animal.cat.names}")
    private String catNames;

    @Value("${animal.dog.names}")
    private String dogNames;

    String[] characters = {"kind", "aggressive", "angry", "friendly", "agile"};

    public Animal createAnimal() {
        Animal animal = null;
        int breedIndex = random.nextInt(3);
        int charactersIndex = random.nextInt(5);
        int animalIndex = random.nextInt(4);

        String[] namesArray;
        if (AnimalType.values()[animalIndex] == AnimalType.CAT) {
            namesArray = catNames.split(",");
        } else {
            namesArray = dogNames.split(",");
        }
        String randomName = namesArray[random.nextInt(namesArray.length)];

        switch (AnimalType.values()[animalIndex]) {
            case DOG:
                animal = new Dog(dogBreeds[breedIndex], randomName, BigDecimal.valueOf(200).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                break;
            case CAT:
                animal = new Cat(catBreeds[breedIndex], randomName, BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                break;
            case WOLF:
                animal = new Wolf(wolfBreeds[breedIndex], randomName, BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                break;
            case SHARK:
                animal = new Shark(sharkBreeds[breedIndex], randomName, BigDecimal.valueOf(3000).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                break;
        }
        System.out.println("Created: " + animal.getBreed() + " - " + animal.getName() + ", cost = " + animal.getCost() + ", dateBirth: " + animal.getBirthDate());
        return animal;
    }

    public Animal[] createAnimals(int numberOfAnimals) {
        Animal[] animals = new Animal[numberOfAnimals];
        for (int i = 0; i < numberOfAnimals; i++) {
            animals[i] = createAnimal();
        }
        return animals;
    }

    public void setAnimalType() {
        String animalType = environment.getProperty("animal.type");
        if (animalType != null) {
            switch (animalType.toLowerCase()) {
                case "dog":
                    this.animalType = AnimalType.DOG;
                    break;
                case "cat":
                    this.animalType = AnimalType.CAT;
                    break;
                case "wolf":
                    this.animalType = AnimalType.WOLF;
                    break;
                case "shark":
                    this.animalType = AnimalType.SHARK;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid animal type specified in application.properties");
            }
        } else {
            throw new IllegalArgumentException("Animal type not specified in application.properties");
        }
    }

}

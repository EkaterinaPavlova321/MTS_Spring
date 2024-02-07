package ru.mts.hw6.service;

import ru.mts.hw6.animalFactory.AnimalType;
import ru.mts.hw6.entity.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    private AnimalType animalType;

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType() {
        AnimalType[] animalTypes = AnimalType.values();
        Random random = new Random();
        this.animalType = animalTypes[random.nextInt(animalTypes.length)];
    }
    public Animal[] createAnimals(int numberOfAnimals){
        Animal[] animals = new Animal[numberOfAnimals];


        for (int i = 0; i < numberOfAnimals; i++){
            int breedIndex = random.nextInt(3);
            int nameIndex = random.nextInt(10);
            int charactersIndex = random.nextInt(5);
            int animalIndex = random.nextInt(4);


            Animal animal;

            switch (AnimalType.values()[animalIndex]) {

                case DOG:
                    animals[i] = new Dog(dogBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(200).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;
                case CAT:
                    animals[i] = new Cat(catBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;
                case WOLF:
                    animals[i] = new Wolf(wolfBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;
                case SHARK:
                    animals[i] = new Shark(sharkBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(3000).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;

            }
            System.out.println("Created: " + animals[i].getBreed() + " - " + animals[i].getName() + ", cost = " + animals[i].getCost() + ", dateBith: " + animals[i].getBirthDate());
        }

        return animals;
    }



    // Переопределенный метод для создания 10 уникальных животных с использованием цикла do-while
    @Override
    public Animal[] createUniqueAnimals() {
        Animal[] animals = new Animal[10];
        int count = 0;
        do {

            int breedIndex = random.nextInt(3);
            int nameIndex = random.nextInt(10);
            int charactersIndex = random.nextInt(5);
            int animalIndex = random.nextInt(4);


            Animal animal;

            switch (AnimalType.values()[animalIndex]) {

                case DOG:
                    animals[count] = new Dog(dogBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(200).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;
                case CAT:
                    animals[count] = new Cat(catBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;
                case WOLF:
                    animals[count] = new Wolf(wolfBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;
                case SHARK:
                    animals[count] = new Shark(sharkBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(3000).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;

            }
            System.out.println("Created: " + animals[count].getBreed() + " - " + animals[count].getName() + " cost = " + animals[count].getCost() + ", dateBith: " + animals[count].getBirthDate());
            count++;
        } while (count < 10);
        return animals;
    }
}

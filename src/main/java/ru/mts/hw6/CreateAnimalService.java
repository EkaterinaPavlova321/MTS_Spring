package ru.mts.hw6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Интерфейс с методом по созданию 10 уникальных животных
 */

public interface CreateAnimalService {

    Random random = new Random();
    String[] catBreeds = {"Siamese", "Maine Coon", "Persian"};
    String[] dogBreeds = {"Golden Retriever", "Labrador", "Shepherd"};
    String[] sharkBreeds = {"Grreat White", "Tiger Shark", "Hammerhead"};
    String[] wolfBreeds = {"Gray", "Artic", "Red"};

    String[] names = {"Scaly", "Milana", "Rocket", "Buda", "Buba", "Mayout", "Yanix", "Bob", "Max", "Sam"};
    String[] characters = {"kind", "aggresive", "angry", "friendly", "agile"};


    default Animal[] createUniqueAnimals(){

        Animal[] animals = new Animal[10];
        int count = 0;
        while (count < 10){

            int breedIndex = random.nextInt(3);
            int nameIndex = random.nextInt(10);
            int charactersIndex = random.nextInt(5);
            int animalIndex = random.nextInt(4);


            Animal animal;

            switch (AnimalType.values()[animalIndex]){

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
            count++;
        }
        return animals;

    }

    Animal[] createAnimals(int numberOfAnimals);

    void setAnimalType();
}



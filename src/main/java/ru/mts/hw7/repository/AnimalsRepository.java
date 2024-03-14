package ru.mts.hw7.repository;

//import ru.mts..entity.Animal;

import ru.mts.animalstarter.entity.Animal;
//import ru.mts.hw7.entity.Animal;

import java.util.Set;

public interface AnimalsRepository {

    /**
     * Метод, который находит всех животных, рожденных
     * в високосный год
     */
    String[] findLeapYearNames();

    /**
     * Метод, который ныходит животных, которые старше
     * возраста, поступающего на вход
     */
    Animal[] findOlderAnimal(int age);

    /**
     * Метод, которй выводит на экран дубликаты животных
     */
    Set<Animal> findDuplicate();

    /**
     * Метод, который выводит на экрах дубликаты
     */

    void printDuplicate();

    String[] getNameAnimals();
}

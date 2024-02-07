package ru.mts.hw6.repository;

import ru.mts.hw6.entity.Animal;

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
}

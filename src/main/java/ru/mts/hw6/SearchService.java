package ru.mts.hw6;

import java.util.Map;

public interface SearchService {

    /**
     * Метод, который находит всех животных, рожденных
     * в високосный год
     */
    String[] findLeapYearNames(Animal[] animals);

    /**
     * Метод, который ныходит животных, которые старше
     * возраста, поступающего на вход
     */
    Animal[] findOlderAnimal(Animal[] animals, int n);

    /**
     * Метод, которй выводит на экран дубликаты животных
     */
    Map<Animal, Integer> findDuplicate(Animal[] animals);
}

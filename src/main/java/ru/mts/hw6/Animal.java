package ru.mts.hw6;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Animal {

    /**
     *Метод для получения поля Breed
     */
    String getBreed();

    /**
     *Метод для получения поля Name
     */
    String getName();

    /**
     *Метод для получения поля Cost
     */
    BigDecimal getCost();

    /**
     *Метод для получения поля Character
     */
    String getCharacter();

    /**
     *Метод для получения поля BirthDate
     */
    LocalDate getBirthDate();

}
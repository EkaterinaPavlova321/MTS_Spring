package ru.mts.animalstarter.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Shark extends Predator {

    public Shark(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }
}

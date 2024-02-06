package ru.mts.hw6;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Wolf extends Predator {
    public Wolf(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }
}
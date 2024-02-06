package ru.mts.hw6;

import java.time.LocalDate;
import java.util.Random;

/**
 * Класс с методом для создания рандомной даты в промежутке от 1969 до 2015
 */

public class RandomDate {
    public static LocalDate dateGenerator() {
        Random ry = new Random();
        Random rm = new Random();
        Random rd = new Random();
        int year = 1969 + ry.nextInt(2015-1969+1);
        int month = 1 + rm.nextInt(12);
        int day = 1 + rd.nextInt(31);

        if (month==2 && day>28){
            day = day - 3;
        } else {
            if((month%2==0 && month != 8 ) && day==31 ){
                day = day -1;
            }
        }
        return LocalDate.of(year, month,day);
    }
}

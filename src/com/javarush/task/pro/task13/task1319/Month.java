package com.javarush.task.pro.task13.task1319;

/* 
Месяцы в сезоне
*/

import java.util.Arrays;

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    //напишите тут ваш код
    public static Month[] getWinterMonths() {
        Month[] winterMonths = new Month[3];
        System.arraycopy(values(), 11, winterMonths, 0, 1);
        System.arraycopy(values(), 0, winterMonths, 1, 2);
        return winterMonths;
    }

    public static Month[] getSpringMonths() {
        Month[] winterMonths = new Month[3];
        System.arraycopy(values(), 2, winterMonths, 0, 3);
        return winterMonths;
    }

    public static Month[] getSummerMonths() {
        Month[] winterMonths = new Month[3];
        System.arraycopy(values(), 5, winterMonths, 0, 3);
        return winterMonths;
    }

    public static Month[] getAutumnMonths() {
        Month[] winterMonths = new Month[3];
        System.arraycopy(values(), 8, winterMonths, 0, 3);
        return winterMonths;
    }
}

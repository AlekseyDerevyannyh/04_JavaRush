package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1984, Calendar.FEBRUARY, 4);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код

        return switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1 -> "воскресенье";
            case 2 -> "понедельник";
            case 3 -> "вторник";
            case 4 -> "среда";
            case 5 -> "четверг";
            case 6 -> "пятница";
            case 7 -> "суббота";
            default -> "ошибка!";
        };
    }
}

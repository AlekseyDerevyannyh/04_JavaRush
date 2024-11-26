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
        String day;
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                day = "воскресенье";
            case 2:
                day = "понедельник";
            case 3:
                day = "вторник";
            case 4:
                day = "среда";
            case 5:
                day = "четверг";
            case 6:
                day = "пятница";
            case 7:
                day = "суббота";
            default:
                day = "ошибка!";
        }

        return day;
    }
}

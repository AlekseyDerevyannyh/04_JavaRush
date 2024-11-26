package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date("Feb 04 1984");

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        //напишите тут ваш код
        String day;
        switch (date.getDay()) {
            case 0:
                day = "воскресенье";
            case 1:
                day = "понедельник";
            case 2:
                day = "вторник";
            case 3:
                day = "среда";
            case 4:
                day = "четверг";
            case 5:
                day = "пятница";
            case 6:
                day = "суббота";
            default:
                day = "ошибка!";
        }
        return day;
    }
}

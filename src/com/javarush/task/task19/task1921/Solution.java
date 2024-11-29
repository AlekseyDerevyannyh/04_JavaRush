package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        if (args.length != 1) {
            return;
        }
        String fileName = args[0];

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                addPerson(fileReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addPerson(String line) {
        String[] words = line.split(" ");
        if (words.length < 4) {
            return;
        }
        int year;
        int month;
        int day;
        try {
            year = Integer.parseInt(words[words.length - 1]);
            month = Integer.parseInt(words[words.length - 2]);
            day = Integer.parseInt(words[words.length - 3]);
        } catch (NumberFormatException e) {
            return;
        }
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        String name = line.substring(0, line.lastIndexOf(" " + day + " " +  month + " " + year));
        PEOPLE.add(new Person(name, calendar.getTime()));
    }
}

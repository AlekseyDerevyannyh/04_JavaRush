package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            switch (args[0]) {
                case "-c":
                    try {
                        System.out.println(createPerson(args[1], args[2], args[3]));
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new IllegalArgumentException("Неправильный формат аргументов!");
                    }
                    break;
                case "-r":
                    try {
                        System.out.println(readPerson(args[1]));
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new IllegalArgumentException("Неправильный формат аргументов!");
                    }
                    break;
                case "-u":
                    try {
                        updatePerson(args[1], args[2], args[3], args[4]);
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Неправильный формат аргументов!");
                    }
                    break;
                case "-d":
                    try {
                        deletePerson(args[1]);
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Неправильный формат аргументов!");
                    }
                    break;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Неправильный формат аргументов!");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int createPerson(String name, String sex, String bd) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            Date birthDate = formatter.parse(bd);
            if (sex.equals("м")) {
                allPeople.add(Person.createMale(name, birthDate));
                return allPeople.size() - 1;
            } else if (sex.equals("ж")) {
                allPeople.add(Person.createFemale(name, birthDate));
                return allPeople.size() - 1;
            } else {
                throw new IllegalArgumentException("Неправильный формат пола!");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Неправильный формат даты рождения!");
        }
    }

    public static String readPerson(String id) {
        Person person;
        try {
            person = allPeople.get(Integer.parseInt(id));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Человек с идентификатором '%s' не найден!", id));
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(person.getName());
        stringBuilder.append(" ");
        stringBuilder.append(person.getSex().equals(Sex.MALE) ? "м" : "ж");
        stringBuilder.append(" ");
        stringBuilder.append(formatter.format(person.getBirthDate()));
        return stringBuilder.toString();
    }

    public static void updatePerson(String id, String name, String sex, String bd) {
        Person person;
        try {
            person = allPeople.get(Integer.parseInt(id));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Человек с идентификатором '%s' не найден!", id));
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            if (sex.equals("м")) {
                person.setSex(Sex.MALE);
            } else if (sex.equals("ж")) {
                person.setSex(Sex.FEMALE);
            } else {
                throw new IllegalArgumentException("Неправильный формат пола!");
            }
            person.setName(name);
            person.setBirthDate(formatter.parse(bd));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Неправильный формат даты рождения!");
        }
    }

    public static void deletePerson(String id) {
        Person person;
        try {
            person = allPeople.get(Integer.parseInt(id));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Человек с идентификатором '%s' не найден!", id));
        }
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
    }
}

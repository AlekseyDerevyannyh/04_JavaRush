package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args == null || args.length < 1) {
            throw new IllegalArgumentException("Неправильный формат аргументов!");
        }

        switch (args[0]) {
            case "-c":
                if ((args.length - 1) % 3 == 0) {
                    for (int i = 1; i < args.length; i += 3) {
                        try {
                            synchronized (allPeople) {
                                System.out.println(createPerson(args[i], args[i + 1], args[i + 2]));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new IllegalArgumentException("Неправильный формат аргументов!");
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Неправильный формат аргументов!");
                }
                break;
            case "-i":
                if (args.length > 1) {
                    for (int i = 1; i < args.length; i++) {
                        try {
                            synchronized (allPeople) {
                                System.out.println(readPerson(args[i]));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new IllegalArgumentException("Неправильный формат аргументов!");
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Неправильный формат аргументов!");
                }
                break;
            case "-u":
                if ((args.length - 1) % 4 == 0) {
                    for (int i = 1; i < args.length; i += 4) {
                        try {
                            synchronized (allPeople) {
                                updatePerson(args[i], args[i + 1], args[i + 2], args[i + 3]);
                            }
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Неправильный формат аргументов!");
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Неправильный формат аргументов!");
                }
                break;
            case "-d":
                if (args.length > 1) {
                    for (int i = 1; i < args.length; i++) {
                        try {
                            synchronized (allPeople) {
                                deletePerson(args[i]);
                            }
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Неправильный формат аргументов!");
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Неправильный формат аргументов!");
                }
                break;
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

package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        //напишите тут ваш код
        grades.put("Ivan Ivanov", 4.3);
        grades.put("Ivan Poklakov", 3.3);
        grades.put("Katya Reshetnikova", 2.5);
        grades.put("Poytr Petrov", 4.8);
        grades.put("Sidor Sidorov", 3.9);
    }
}

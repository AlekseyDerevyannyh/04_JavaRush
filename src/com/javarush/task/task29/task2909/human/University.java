package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        if (students.isEmpty())
            return null;
        double maxAverageGrade = students.get(0).getAverageGrade();
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > maxAverageGrade) {
                maxAverageGrade = students.get(i).getAverageGrade();
            }
        }
        return getStudentWithAverageGrade(maxAverageGrade);
    }

    public Student getStudentWithMinAverageGrade() {
        if (students.isEmpty())
            return null;
        double minAverageGrade = students.get(0).getAverageGrade();
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < minAverageGrade) {
                minAverageGrade = students.get(i).getAverageGrade();
            }
        }
        return getStudentWithAverageGrade(minAverageGrade);
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
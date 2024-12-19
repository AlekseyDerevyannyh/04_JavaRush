package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/

public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person() {
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            children = (List) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Person> childrens = new ArrayList<>();
        childrens.add(new Person("Ivan", "Ivanov", 18));
        childrens.add(new Person("Katya", "Konstantinova", 30));

        Person mother = new Person("Mother", "Mother", 50);
        Person father = new Person("Father", "Father", 60);
        Person person = new Person("Petya", "Petrov", 40);
        person.setMother(mother);
        person.setFather(father);
        person.setChildren(childrens);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("file"));
        person.writeExternal(outputStream);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("file"));
        Person newPerson = new Person();
        newPerson.readExternal(inputStream);
        inputStream.close();
        System.out.println(person);
        System.out.println(newPerson);
        System.out.println("end!");
    }
}

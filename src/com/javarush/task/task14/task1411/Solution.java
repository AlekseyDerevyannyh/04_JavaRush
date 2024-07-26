package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = reader.readLine();

        String[] keys = new String[]{"user", "loser", "coder", "proger"};
        while (Arrays.asList(keys).contains(key)) {
            if (key.equals(keys[0])) {
                person = new Person.User();
            } else if (key.equals(keys[1])) {
                person = new Person.Loser();
            } else if (key.equals(keys[2])) {
                person = new Person.Coder();
            } else if (key.equals(keys[3])) {
                person = new Person.Proger();
            }
            doWork(person);
            key = reader.readLine();
        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person != null) {
            if (person instanceof Person.User) {
                ((Person.User) person).live();
            } else if (person instanceof Person.Loser) {
                ((Person.Loser) person).doNothing();
            } else if (person instanceof Person.Coder) {
                ((Person.Coder) person).writeCode();
            } else if (person instanceof Person.Proger) {
                ((Person.Proger) person).enjoy();
            }
        }
    }
}

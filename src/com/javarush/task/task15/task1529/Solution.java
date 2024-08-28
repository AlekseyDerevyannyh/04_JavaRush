package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            if (input.equals("helicopter")) {
                result = new Helicopter();
            } else if (input.equals("plane")) {
                int numberOfPassengers = reader.read();
                result = new Plane(numberOfPassengers);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

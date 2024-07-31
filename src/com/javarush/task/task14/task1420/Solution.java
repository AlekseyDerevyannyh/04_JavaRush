package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number1 = Integer.parseInt(reader.readLine());
            int number2 = Integer.parseInt(reader.readLine());
            int nod = 1;
            if (number1 > 0 && number2 > 0) {
                for (int i = 2; i <= Math.min(number1, number2); i ++) {
                    if (number1 % i == 0 && number2 % i == 0 && i > nod) {
                        nod = i;
                    }
                }
                System.out.println(nod);
            } else {
                System.out.println("Error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        if (number < 1 || number > 3000) {
            return;
        }
        System.out.printf("%d =", number);
        int power = 0;

        do {
            int quotient = number / 3;
            int remainder = number % 3;
            if (remainder > 1) {
                quotient = (number + 1) / 3;
                remainder = -1;
            }
            if (remainder < 0) {
                System.out.printf(" - %d", power(3, power));
            } else if (remainder > 0) {
                System.out.printf(" + %d", power(3, power));

            }
            number = quotient;
            power ++;
        } while (number != 0);
        System.out.println();
    }

    public static int power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}
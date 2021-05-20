package com.company;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the principal:");
        int number = scanner.nextInt();

        String className = (number % 5 == 0 && number % 3 == 0) ? "FizzBuzz"
                : (number % 5 == 0) ? "Fizz" : (number % 3 == 0) ? "Buzz" : String.valueOf(number);
        System.out.print(className);
    }
}

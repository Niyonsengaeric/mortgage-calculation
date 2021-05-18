package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR =12;
        final byte PERCENT =100;

        Scanner scanner = new Scanner(System.in);

		System.out.print("enter the principal:");
    	int principal = scanner.nextInt();

        System.out.print("enter annual rate:");
        float rate = scanner.nextFloat();
        float monthlyRate = (rate/PERCENT)/ MONTHS_IN_YEAR;


        System.out.print("enter period:");
        byte period = scanner.nextByte();
        int n = period * 12;
        int numberOfPayments = period * MONTHS_IN_YEAR;


	    System.out.println("your principal is " + principal);
        System.out.println("your montly rate is " + monthlyRate);
        System.out.println("period " + period);
        System.out.println("number of times " + n);



//        calculation of mortgage payments with an equation p((r(1+r)power n)/(1+r)power n - 1))

//        / Math.pow((1 + monthlyRate), n) - 1 )
        double mortgagePayment = principal * (monthlyRate * Math.pow(1 + monthlyRate, n ) / (Math.pow(1 + monthlyRate, n) - 1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgagePayment);
        System.out.println("you Mortgage Payment will be: " + mortgagePayment);
        System.out.println("Mortgage Payment with currency: " + mortgageFormatted);
    }
}

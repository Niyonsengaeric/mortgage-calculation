package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        float rate = 0;
        float monthlyRate = 0;
        byte period = 0;
        int n = 0;
        int principal = 0;
        while (true) {
            System.out.print("enter the principal ($1K - $1M):");
            principal = scanner.nextInt();
            if (principal >= 1_000 && principal <= 1_000_000)
                break;
            System.out.println("enter a number between 1000 and 1000000");
        }

        while (true) {
            System.out.print("enter annual rate:");
            rate = scanner.nextFloat();
            if (rate > 0 && rate <= 30)
                break;
            System.out.println("rate must be greater than zero and less or equal to 30");
        }

        while (true) {
            System.out.print("enter period:");
            period = scanner.nextByte();
            if (period > 1 && period <= 30)
                break;
            System.out.println("Period must be greater or equal to one and equal or less to 30");
        }
        System.out.println("your principal is " + principal);
        System.out.println("your montly rate is " + monthlyRate);
        System.out.println("period " + period);
        System.out.println("number of times " + n);

        // calculation of mortgage payments with an equation p((r(1+r)power
        // n)/(1+r)power n - 1))

        // / Math.pow((1 + monthlyRate), n) - 1 )

        double mortgagePayment = calculateMortgage(principal, rate, period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgagePayment);
        System.out.println("you Mortgage Payment will be: " + mortgagePayment);
        System.out.println("Mortgage Payment with currency: " + mortgageFormatted);
    }

    public static double calculateMortgage(int principal, float rate, byte period) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int n = period * 12;
        float monthlyRate = (rate / PERCENT) / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (period * MONTHS_IN_YEAR);
        double mortgagePayment = principal
                * (monthlyRate * Math.pow(1 + monthlyRate, n) / (Math.pow(1 + monthlyRate, n) - 1));
        return mortgagePayment;
    }
}

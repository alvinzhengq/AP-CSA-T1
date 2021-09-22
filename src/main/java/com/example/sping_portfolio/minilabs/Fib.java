package com.example.sping_portfolio.minilabs;
import java.util.Scanner;

public class Fib {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        long a = 1, b = 1;

        System.out.println("Enter number of fib sequence you want: ");
        int n = s.nextInt();

        if(n <= 2) {
            System.out.println(1);
        } else {
            for(int i = 0; i < n-2; i++) {
                long tmp = a+b;
                a = b; b = tmp;
            }
        }

        System.out.println("Num Loops: " + (n-2));
        System.out.println("Next fib num: " + b);
    }
}

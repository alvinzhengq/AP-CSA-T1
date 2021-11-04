package com.example.sping_portfolio.controllers;

public class ArithmeticRecursion {
    static int first = 1;
    static int diff = 2;

    public static int getNthElement(int n) {
        if (n == 1) {
            System.out.print(first + " ");
            return first;
        }
        else {
            int x = getNthElement(n - 1) + diff;
            System.out.print(x + " ");
            return x;
        }
    }

    public static void main (String[] args) {
        getNthElement(5);
    }
}

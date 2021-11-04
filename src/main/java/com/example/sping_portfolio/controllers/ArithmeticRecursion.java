package com.example.sping_portfolio.controllers;

public class ArithmeticRecursion {
    int first;
    int diff;
    int N;
    String result;

    // constructor
    public ArithmeticRecursion(int N, int first, int diff) {
        this.N = N;
        this.first = first;
        this.diff = diff;
    }

    public String genSeq() {
        result = "";
        getNthElement(N);
        return result;
    }

    public int getNthElement(int n) {
        if (n == 1) {
            result += first + " ";
            return first;
        }
        else {
            int x = getNthElement(n - 1) + diff;
            result += x + " ";
            return x;
        }
    }

    public static void main (String[] args) {
        ArithmeticRecursion seq = new ArithmeticRecursion(6, 7, 1);
        System.out.println(seq.genSeq());
    }
}

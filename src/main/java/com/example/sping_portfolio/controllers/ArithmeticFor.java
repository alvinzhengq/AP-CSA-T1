package com.example.sping_portfolio.controllers;

public class ArithmeticFor {

    int first;
    int diff;
    int N;

    // constructor
    public ArithmeticFor(int N, int first, int diff) {
        this.N = N;
        this.first = first;
        this.diff = diff;
    }

    public String genSeq() {
        String result = "";
        // let's first store all elements in an array
        int[] arr = new int[N];
        arr[0] = first;
        for (int i = 1; i < N; i++) {
            arr[i] = first + i * diff;
        }
        // Now print all elements
        for (int i = 0; i < N; i++) {
            result += arr[i] + " ";
        }

        return result;
    }

    public static void main(String[] args) {
        ArithmeticFor seq = new ArithmeticFor(6, 7, 1);
        System.out.println(seq.genSeq());
    }
}

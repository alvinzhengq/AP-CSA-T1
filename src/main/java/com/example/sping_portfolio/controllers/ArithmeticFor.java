package com.example.sping_portfolio.controllers;

public class ArithmeticFor {
    public static void main(String[] args) {
        int first = 7;
        int diff = 1;
        int N = 6;

        // let's first store all elements in an array
        int[] arr = new int[N];
        arr[0] = first;
        for (int i = 1; i < N; i++) {
            arr[i] = first + i * diff;
        }
        // Now print all elements
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

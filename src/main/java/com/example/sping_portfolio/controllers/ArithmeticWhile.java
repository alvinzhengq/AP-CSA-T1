package com.example.sping_portfolio.controllers;

public class ArithmeticWhile {
    int first;
    int diff;
    int N;

    // constructor
    public ArithmeticWhile(int N, int first, int diff) {
        this.N = N;
        this.first = first;
        this.diff = diff;
    }

    public String genSeq() {
        String result = "";
        // let's first store all elements in an array
        int[] arr = new int[N];
        arr[0] = first;
        int i = 1;
        while (i < N) {
            arr[i] = first + i * diff;
            i++;
        }
        // Now print all elements
        int j = 0;
        while (j < N) {
            result += arr[j] + " ";
            j++;
        }

        return result;
    }


    public static void main(String[] args) {
        ArithmeticWhile seq = new ArithmeticWhile(6, 7, 1);
        System.out.println(seq.genSeq());
    }
}

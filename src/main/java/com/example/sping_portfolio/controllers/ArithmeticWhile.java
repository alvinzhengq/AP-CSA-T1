package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class ArithmeticWhile {
        public static void main(String[] args) {
            int first = 3;
            int diff = 5;
            int N = 4;

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
                System.out.print(arr[j] + " ");
                j++;
            }
        }
    }

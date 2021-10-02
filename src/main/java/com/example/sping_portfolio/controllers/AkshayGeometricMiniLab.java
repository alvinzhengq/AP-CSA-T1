package com.example.sping_portfolio.controllers;
import java.lang.Math;

abstract class AkshayGeometricMiniLab {
    int initial, constant, i;
    public AkshayGeometricMiniLab(int initialNum, int constantMultiplier, int iterationNum) {
        initial = initialNum;
        constant = constantMultiplier;
        i = iterationNum;
    }
}

class ImplementationOne extends AkshayGeometricMiniLab {

    public ImplementationOne(int initial, int constant, int i) {
        super(initial, constant, i);
    }

    public double GeoSeq() {
        double finalNum = initial * Math.pow(constant, i-1);
        System.out.println(finalNum);
        return finalNum;
    }

}

class ImplementationTwo extends AkshayGeometricMiniLab {

    public ImplementationTwo(int initial, int constant, int i) {
        super(initial, constant, i);
    }

    public double GeoSeq() {
        int j;
        double currentNum = initial;
        double previousNum = initial;
        for (j = 0; j < i-1; j++) {
            previousNum = currentNum;
            currentNum = previousNum * constant;
        }
        System.out.println(currentNum);
        return currentNum;
    }
}

class ImplementationThree extends AkshayGeometricMiniLab {

    public ImplementationThree(int initial, int constant, int i) {
        super(initial, constant, i);
    }

    public double GeoSeq() {
        int j = 0;
        double multiplyByNum = Math.pow(constant, i-1);
        double finalNum = initial * multiplyByNum;
        return finalNum;
    }
}

class ImplementationFour extends AkshayGeometricMiniLab {

    public ImplementationFour(int initial, int constant, int i) {
        super(initial, constant, i);
    }

    public double GeoSeq() {
        int j = 0;
        double currentNum = initial;
        double previousNum = initial;
        while (j < i-1) {
            previousNum = currentNum;
            currentNum = previousNum * constant;
            j++;
        }
        System.out.println(currentNum);
        return currentNum;
    }
}

//class Main {
//    public static void main(String[] args) {
//        ImplementationOne io = new ImplementationOne(1, 2, 3);
//        io.GeoSeq();
//        ImplementationTwo io2 = new ImplementationTwo(1, 2,3);
//        io2.GeoSeq();
//        ImplementationThree io3 = new ImplementationThree(1, 2, 3);
//        io3.GeoSeq();
//        ImplementationFour io4 = new ImplementationFour(1, 2, 3);
//        io4.GeoSeq();
//    }
//}

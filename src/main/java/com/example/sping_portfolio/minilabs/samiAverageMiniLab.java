package com.example.sping_portfolio.minilabs;

public class samiAverageMiniLab {
    public static void main(String[] args){
        int scoreOne = 90;

        int scoreTwo = 94;

        int scoreThree = 99;

        int scoreFour = 45;

        int scoreFive = 30;

        double weight = 0.2;
        double weightTwo = 0.1;
        double weightThree = 0.1;
        double weightFour = 0.2;
        double weightFive = 0.4;


        double averageOne = ((weight)*(scoreOne) + (weightTwo)*(scoreTwo))/2;
        double averageTwo = ((weightThree)*(scoreThree) + (weightFour)*(scoreFour))/2;
        double averageThree = (averageOne + averageTwo + (weightFive)*(scoreFive))/3;



        System.out.println("Score One is " +scoreOne);
        System.out.println("Score Two is " +scoreTwo);
        System.out.println("Score Three is " +scoreThree);
        System.out.println("Score Four is " +scoreFour);
        System.out.println("Score Five is " +scoreFive);

        System.out.println("Average of Score One with 20% weight and Score Two with 10% weight is " +averageOne);
        System.out.println("Average of Score Three with 10% weight and Score Three with 20% weight is " +averageOne);
        System.out.println("Average of all scores with (10%, 20%, 20% 10%, and 40%) respective weights is  " +averageThree);
    }

}

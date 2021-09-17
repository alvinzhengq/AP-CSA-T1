package com.example.sping_portfolio.minilabs;

public class SusMiniLab {
    public static class AmongUs {
        int numOfImposters;
        int numOfCrewmates;

        public AmongUs(int _numOfImposters, int _numOfCrewmates) {
            numOfImposters = _numOfImposters;
            numOfCrewmates = _numOfCrewmates;
        }

        public boolean isCrewmateWin() {
            if (!(numOfCrewmates > numOfImposters)) {
                return false;
            } else {
                return true;
            }
        }

    }
    public static void main(String[] args) {
        AmongUs GameOne = new AmongUs(2, 4);
        System.out.println(GameOne.isCrewmateWin());

        AmongUs GameTwo = new AmongUs(2, 2);
        System.out.println(GameTwo.isCrewmateWin());
    }
}

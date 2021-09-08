package com.example.sping_portfolio.minilabs;

public class ClassMiniLab {
    public static class ESportsTeam {
        private String name;
        private int numMembers;
        private String game;

        public ESportsTeam(String _name, String _game, int _numMembers) {
            name = _name;
            game = _game;
            numMembers = _numMembers;
        }

        public boolean isCompleteTeam() {
            if(numMembers > 5) {
                return true;
            }else {
                return false;
            }
        }

        public String getGame() {
            return game;
        }
    }

    public static void main(String args[]) {
        ESportsTeam Cloud9 = new ESportsTeam("Cloud9", "League of Legends", 6);
        System.out.println(Cloud9.getGame());

        ESportsTeam Fnatic = new ESportsTeam("Fnatic", "Rainbow Six Siege", 3);
        System.out.println(Fnatic.isCompleteTeam());
    }
}


import javax.swing.JOptionPane;

/**
 *
 * @author Markus aka Flydiverny
 */

public class config {
        public final static int dices = 5;
        public final static int rollPool = 6;
        public static int players;
        public static int cP = 0;   //Current Player
        public final static int maxRolls = 3;
        public final static int bonusLimit = 63;
        public final static int bonus = 50;
        private static player player[];

        private static int getPlayerCount(window window) {
            int playerCount = 1;
            boolean bad = true;
            String output = "How many players do you want?\n" +
                            "The game supports 1-10 players.";
            
            while(bad || playerCount == 0 || playerCount > 10) {
                try {
                    playerCount = Integer.parseInt(JOptionPane.showInputDialog(window,output));
                    bad = false;
                } catch(NumberFormatException e) {
                    bad = true;
                }
                if(bad || playerCount == 0 || playerCount > 10)
                output = "How many players do you want?\n" +
                         "The game supports 1-10 players.\n" +
                         "Please do only enter numbers between 1-10.";
            }

            return playerCount;
        }

        public static player[] createPlayers(window window) {
            cP = 0;
            players = getPlayerCount(window);
            player = new player[players];
            for(int i = 0; i < players; i++) {
                player[i] = new player();
                String name = "";
                while(name.equals("")) {
                    name = JOptionPane.showInputDialog(window,"Please enter the name for Player (" + (i+1) + "/" + players + ")" );
                }
                player[i].name = name;
            }

            return player;
        }
} //End Class

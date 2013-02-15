/**
 *
 * @author Markus aka Flydiverny
 */

import javax.swing.JLabel;

public class player {
    public String name;
    public dice dice[] = new dice[config.dices];
    public tipGen tips = new tipGen(this);
    public int rollCount = 0;
    public int score[] = new int[18];
    public boolean taken[] = new boolean[18];

    public JLabel lblScore[] = {
                                        new JLabel("-"),    //Ones
                                        new JLabel("-"),    //Twos
                                        new JLabel("-"),    //Threes
                                        new JLabel("-"),    //Fours
                                        new JLabel("-"),    //Fives
                                        new JLabel("-"),    //Sixes
                                        new JLabel("-"),    //Sum
                                        new JLabel("-"),    //Bonus
                                        new JLabel("-"),    //One Pair
                                        new JLabel("-"),    //Two Pair
                                        new JLabel("-"),    //Three-of-a-kind
                                        new JLabel("-"),    //Four-of-a-kind
                                        new JLabel("-"),    //Small Straight
                                        new JLabel("-"),    //Large Straight
                                        new JLabel("-"),    //Full House
                                        new JLabel("-"),    //Chance
                                        new JLabel("-"),    //Yahtzee
                                        new JLabel("-")    //Grand Total
    };
    
    public player() {
        init();
    }

    private void init() {
        for(int i = 0; i < config.dices; i++) {
            dice[i] = new dice();
        }
        taken[6] = true;
        taken[7] = true;
        taken[17] = true;
    }

    public void reroll() {
        for(int i = 0; i < config.dices; i++) {
                dice[i].reroll();
        }
        rollCount++;
    }

} //End Class

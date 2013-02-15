/**
 *
 * @author Markus aka Flydiverny
 */

import javax.swing.JOptionPane;

public class score {
    final static int ONES       = 0;
    final static int TWOS       = 1;
    final static int THREES     = 2;
    final static int FOURS      = 3;
    final static int FIVES      = 4;
    final static int SIXES      = 5;
    final static int SUM        = 6;
    final static int BONUS      = 7;
    final static int ONE_PAIR   = 8;
    final static int TWO_PAIR   = 9;
    final static int TRI_KIND   = 10;
    final static int FOUR_KIND  = 11;
    final static int SMSTRAIGHT = 12;
    final static int LGSTRAIGHT = 13;
    final static int FULLHOUSE  = 14;
    final static int CHANCE     = 15;
    final static int YAHTZEE    = 16;
    final static int GRANDTOTAL = 17;

    private static player player[];
    private static boolean error = false;
    private static window window;

    public static void setPlayers(player playerIn[]) {
        player = playerIn;
    }

    public static void selectThis(int doWhat) {
        error = false;

        switch(doWhat) {
            case ONES:
                singleNumbers(ONES);
                break;
            case TWOS:
                singleNumbers(TWOS);
                break;
            case THREES:
                singleNumbers(THREES);
                break;
            case FOURS:
                singleNumbers(FOURS);
                break;
            case FIVES:
                singleNumbers(FIVES);
                break;
            case SIXES:
                singleNumbers(SIXES);
                break;
            case ONE_PAIR:
                Pair(ONE_PAIR);
                break;
            case TWO_PAIR:
                Pair(TWO_PAIR);
                break;
            case TRI_KIND:
                Pair(TRI_KIND);
                break;
            case FOUR_KIND:
                Pair(FOUR_KIND);
                break;
            case SMSTRAIGHT:
                smallStraight();
                break;
            case LGSTRAIGHT:
                largeStraight();
                break;
            case FULLHOUSE:
                Pair(FULLHOUSE);
                break;
            case CHANCE:
                chance();
                break;
            case YAHTZEE:
                Pair(YAHTZEE);
                break;
        }

        updateLabels(doWhat);
    }
    private static int pairCount = 0;

    private static void largeStraight() {
        int highestDice = 0;
        int lowestDice = 6;

        @SuppressWarnings("unused")
		int pair[][] = findPairs();

        for(int i = 0; i < config.dices; i++) {
            if(player[config.cP].dice[i].cV > highestDice)
                highestDice = player[config.cP].dice[i].cV;
            if(player[config.cP].dice[i].cV < lowestDice)
                lowestDice = player[config.cP].dice[i].cV;
        }

        if(pairCount == 0 && highestDice == 6 && lowestDice == 2
           || pairCount == 0 && highestDice == 5 && lowestDice == 1) {
            player[config.cP].score[LGSTRAIGHT] = 40;
        }
        else
            showError(LGSTRAIGHT);
    }

    private static void smallStraight() {
        int tempDices[] = new int[config.dices];
        for(int i = 0; i < config.dices; i++) {
            tempDices[i] = player[config.cP].dice[i].cV;
        }

        tempDices = reOrder(tempDices);

        for(int i = 0; i < config.dices-1; i++) {
            int temp = 0;
            if( tempDices[i] == tempDices[i+1] ) {
                temp = tempDices[i];

                for( int x = i; x < config.dices-1; x++) {
                    tempDices[x] = tempDices[x+1];
                }

                tempDices[4] = temp;
            }
        }

        if( ((tempDices[0] == 1) && (tempDices[1] == 2) && (tempDices[2] == 3) && (tempDices[3] == 4)) ||
            ((tempDices[0] == 2) && (tempDices[1] == 3) && (tempDices[2] == 4) && (tempDices[3] == 5)) ||
            ((tempDices[0] == 3) && (tempDices[1] == 4) && (tempDices[2] == 5) && (tempDices[3] == 6)) ||
            ((tempDices[1] == 1) && (tempDices[2] == 2) && (tempDices[3] == 3) && (tempDices[4] == 4)) ||
            ((tempDices[1] == 2) && (tempDices[2] == 3) && (tempDices[3] == 4) && (tempDices[4] == 5)) ||
            ((tempDices[1] == 3) && (tempDices[2] == 4) && (tempDices[3] == 5) && (tempDices[4] == 6)) ) {
                player[config.cP].score[SMSTRAIGHT] = 30;
            }
        else
                showError(SMSTRAIGHT);
    }

    public static int[][] findPairs() {
        int pair[][] = new int[config.dices][2];
        pairCount = 0;
        boolean matchedDices[] = new boolean[config.dices];

        for(int i = 0; i < config.dices; i++) {
            for(int z = 0; z < config.dices; z++) {
                if(player[config.cP].dice[i].cV == player[config.cP].dice[z].cV && i != z) {
                    if(!matchedDices[z]) {
                        for(int x = 0; x < config.dices; x++) {
                            if(player[config.cP].dice[i].cV == pair[x][0]) {
                                pair[x][1] += 1;
                                break;
                            }
                            else if(x == config.dices-1) {
                                pair[pairCount][0] = player[config.cP].dice[i].cV;
                                pair[pairCount][1] += 1;
                                pairCount++;
                                break;
                            }
                        }
                    }
                    matchedDices[z] = true;
                }
            }
        }

        return pair;
    }

    public static void debug(int pair[][]) {
        //DEBUGSHIT
        String output = "";
        for(int i = 0; i < config.dices; i++) {
            output += "Pair[" + i + "][0]: " + pair[i][0] + "\n";
            output += "Pair[" + i + "][1]: " + pair[i][1] + "\n";
        }
        JOptionPane.showMessageDialog(null,output);
    }

    private static void Pair(int whatPair) {
        int pair[][] = findPairs();
        //debug(pair);

        switch(whatPair) {
            case ONE_PAIR:
                if(pairCount >= 1) {
                    if(pair[0][0] > pair[1][0])
                        player[config.cP].score[ONE_PAIR] = pair[0][0]*2;
                    else if(pair[0][0] < pair[1][0])
                        player[config.cP].score[ONE_PAIR] = pair[1][0]*2;
                } else
                    showError(ONE_PAIR);
                break;

            case TWO_PAIR:
                if(pairCount >= 2)
                    player[config.cP].score[TWO_PAIR] = pair[0][0]*2+pair[1][0]*2;
                else
                    showError(TWO_PAIR);
                break;

            case TRI_KIND:
                if(pair[0][1] >= 3)
                    player[config.cP].score[TRI_KIND] = pair[0][0]*3;
                else if(pair[1][1] >= 3)
                    player[config.cP].score[TRI_KIND] = pair[1][0]*3;
                else
                    showError(TRI_KIND);
                break;

            case FOUR_KIND:
                if(pair[0][1] >= 4)
                    player[config.cP].score[FOUR_KIND] = pair[0][0]*4;
                else
                    showError(FOUR_KIND);
                break;
                
            case FULLHOUSE:
                if(pair[0][1] >= 3 && pair[1][1] >= 2 || pair[1][1] >= 3 && pair[0][1] >= 2)
                    player[config.cP].score[FULLHOUSE] = 25;
                else
                    showError(FULLHOUSE);
                break;

            case YAHTZEE:
                if(pair[0][1] == config.dices && pair[0][0] != 0)
                    player[config.cP].score[YAHTZEE] = 50;
                else
                    showError(YAHTZEE);
                break;
        }
    }

    private static void singleNumbers(int whichNumber) {
        int goodDices = 0;
        int targetDice = whichNumber+1;

        for(int i = 0; i < config.dices; i++) {
            if(player[config.cP].dice[i].cV == targetDice)
                goodDices++;
        }
        if(goodDices > 0)
            player[config.cP].score[whichNumber] = goodDices*targetDice;
        else
            showError(whichNumber);
    }

    private static void chance() {
        int score = 0;
        for(int i = 0; i < config.dices; i++) {
            score += player[config.cP].dice[i].cV;
        }

        if(player[config.cP].score[CHANCE] == 0)
            player[config.cP].score[CHANCE] = score;
        else
            showError(CHANCE);
    }

    private static int[] reOrder(int[] intIn) {
        int x = intIn.length;
        int tempNum;
        for(int z = 0; z < x; z++) {
            for(int i = 0; i+1 < x; i++) {
                if(intIn[i] > intIn[i+1]) {
                tempNum = intIn[i];
                    intIn[i] = intIn[i+1];
                    intIn[i+1] = tempNum;
                }
            }
        }
        return intIn;
    } //End reOrder

    private static void updateLabels(int doWhat) {
        if(!error) {

            player[config.cP].score[SUM] = 0;
            player[config.cP].score[GRANDTOTAL] = 0;
            player[config.cP].taken[doWhat] = true;

            for(int i = 0; i < SUM; i++) {
               player[config.cP].score[SUM] += player[config.cP].score[i];
            }

            if(player[config.cP].score[SUM] >= config.bonusLimit) {
                player[config.cP].score[BONUS] = config.bonus;
            }

            for(int i = SUM; i < GRANDTOTAL; i++) {
               player[config.cP].score[GRANDTOTAL] += player[config.cP].score[i];
            }

            for(int i = 0; i < player[config.cP].score.length; i++) {
                if(player[config.cP].score[i] > 0)
                    player[config.cP].lblScore[i].setText(String.valueOf(player[config.cP].score[i]));
                else if(player[config.cP].taken[i] && i != BONUS)
                    player[config.cP].lblScore[i].setText("x");
            }
            
            if(config.cP == (config.players-1)) {
                int scoresTaken = 0;
                
                for(int i = 0; i < player[config.cP].score.length; i++) {
                    if(player[config.cP].taken[i])
                        scoresTaken++;
                }

                if(scoresTaken == player[config.cP].score.length) {
                    askForNewGame();
                }
            }
            
            playerControl.nextPlayer();
        }
    }

    private static void showError(int errorType) {
        error = true;
        String output = "";
        
        switch(errorType) {
            case ONES:
                output = "You don't roll any dices which shows ONE.";
                break;
            case TWOS:
                output = "You didn't roll any dices which shows TWO.";
                break;
            case THREES:
                output = "You didn't roll any dices which shows THREE.";
                break;
            case FOURS:
                output = "You didn't roll any dices which shows FOUR.";
                break;
            case FIVES:
                output = "You didn't roll any dices which shows FIVE.";
                break;
            case SIXES:
                output = "You didn't roll any dices which shows SIX.";
                break;
            case ONE_PAIR:
                output = "You don't have any pairs.";
                break;
            case TWO_PAIR:
                output = "You don't have two pairs.";
                break;
            case TRI_KIND:
                output = "You don't have Three of the same dice.";
                break;
            case FOUR_KIND:
                output = "You don't have Four of any dice.";
                break;
            case SMSTRAIGHT:
                output = "You don't have a Small Straight.";
                break;
            case LGSTRAIGHT:
                output = "You don't have a Large Straight.";
                break;
            case FULLHOUSE:
                output = "You don't have a Full House.";
                break;
            case CHANCE:
                output = "You have already used your chance.";
                break;
            case YAHTZEE:
                output = "All your dices doesn't match.";
                break;
        }

        askForCross(errorType,output);
    }

    private static void askForCross(int crossWhat,String input) {
        String output = input + "\n" + "Do you want to delete this field?";
        Object[] dialogButtons = {"Keep", "Remove"};
        int answer;
        answer = JOptionPane.showOptionDialog(window, output, "Keep or Delete?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, dialogButtons, dialogButtons[0]);

        switch(answer) {
                case 0:
                    break;
                case 1:
                    player[config.cP].taken[crossWhat] = true;
                    player[config.cP].lblScore[crossWhat].setForeground(java.awt.Color.RED);
                    error = false;
                    break;
        }
    }

    private static void askForNewGame() {
        String output = "This was the last round, for the last player.\n" +
                        "Do you want to start a new game?";
        Object[] dialogButtons = {"New Game", "Cancel"};
        int answer;
        answer = JOptionPane.showOptionDialog(window, output, "New game?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, dialogButtons, dialogButtons[0]);

        switch(answer) {
                case 0:
                    window.newGame();
                    break;
                case 1:
                    break;
        }
    }

    public static void setWindow(window winIn) {
        window = winIn;
    }
} //End Class

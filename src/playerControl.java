/**
 *
 * @author Markus aka Flydiverny
 */

public class playerControl {
    private static dicePanel dP;
    private static scorePanel sP;
    private static player player[];

    public static void nextPlayer() {
        player[config.cP].rollCount = 0;
        
        dP.removeDices();
        player[config.cP].tips.clearTips();

        if(config.cP < config.players)
            config.cP = config.cP+1;
        if(config.cP == config.players)
            config.cP = 0;

        updateUi();
    }

    public static void updateUi() {
        dP.currentPlayer.setText(player[config.cP].name);
        dP.showDices();
        dP.roll.setEnabled(true);

        showButtons(false);
    }

    public static void showButtons(boolean show) {
        if(show) {
            for(int i = 0; i < sP.buttons.length; i++) {
                if(player[config.cP].taken[i])
                    sP.buttons[i].setEnabled(false);
                else
                    sP.buttons[i].setEnabled(true);
            }
        }
        if(!show) {
            for(int i = 0; i < sP.buttons.length; i++) {
                    sP.buttons[i].setEnabled(false);
            }
        }
    }

    public static void setDicePanel(dicePanel dPin) {
        dP = dPin;
    }

    public static void setPlayers(player playerIn[]) {
        player = playerIn;
    }

    public static void setScorePanel(scorePanel sPin) {
        sP = sPin;
    }
}

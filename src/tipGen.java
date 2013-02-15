/**
 *
 * @author Flydiverny
 */

import javax.swing.JTextArea;

public class tipGen {

    private player player;
    private JTextArea txtField;
    private String logg[] = new String[7];

    public tipGen(player pIn) {
        player = pIn;
    }

    public void setTextField(JTextArea txtIn) {
        txtField = txtIn;
    }

    public void createTips() {
        String output = "";
        int pairs[][];
        pairs = score.findPairs();
        //score.debug(pairs);

        int equalDices = 0;
        int pairLoc = 0;
        int highestValue = 0;

        for(int i = 0; i < config.dices; i++) {
            if((pairs[i][1] > equalDices ||
               (pairs[i][0] > highestValue && pairs[i][1] >= equalDices))
               && !player.taken[(pairs[i][0]-1)]) {
                pairLoc = i;
                highestValue = pairs[i][0];
                equalDices = pairs[i][1];
                output = "You should keep your " + pairs[pairLoc][1] + " dices of " + pairs[pairLoc][0] + ".";
            }
        }

        if(!output.equals(""))
            updateField(output);
    }

    private void updateField(String newLog) {
        String output = "";

        if(logg[0] != null && !logg[0].equals(newLog)) {
            for(int i = (logg.length-1); i > 0; i--) {
                logg[i] = logg[i-1];
            }
        }

        logg[0] = newLog;

        for(int i = 0; i < logg.length; i++) {
            if(i == 0 && logg[i] != null)
                output = output + logg[i];
            else if(logg[i] != null && i != 0)
                output = output + "\n" + logg[i];
        } 
        
        txtField.setText(output);
    }

    public void clearTips() {
        for(int i = 0; i < logg.length; i++) {
            logg[i] = null;
        }

        txtField.setText("");
    }

}

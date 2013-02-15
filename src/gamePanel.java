/**
 *
 * @author Markus aka Flydiverny
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class gamePanel extends JPanel {
    public player player[];
    public scorePanel scorePanel;
    public dicePanel dicePanel;

    public gamePanel(window window) {
        this.setVisible(false);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);

        player = config.createPlayers(window);
        playerControl.setPlayers(player);
        scorePanel = new scorePanel(player);
        dicePanel = new dicePanel(player);
        for(int i = 0; i < config.players; i++) {
            player[i].tips.setTextField(dicePanel.textField);
        }
        dicePanel.setPreferredSize(new Dimension(800,200));
        scorePanel.setPreferredSize(new Dimension(800,348));

        this.add(scorePanel, BorderLayout.NORTH);
        this.add(dicePanel, BorderLayout.SOUTH);
        scorePanel.setVisible(true);
        dicePanel.setVisible(true);
    }
}



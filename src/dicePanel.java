/**
 *
 * @author Markus aka Flydiverny
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class dicePanel extends JPanel {
    
    private JLabel titleLbl         = new JLabel("Dices for");
    public JLabel currentPlayer     = new JLabel("");
    public JButton roll             = new JButton("Roll Dices");
    private JButton changePlayerBTN = new JButton("ChangePlayer");

    private JPanel nP = new JPanelBG(gV.BROWN_GRADIENT);
    public JPanel cP = new JPanel();
    private JPanel sP = new JPanel();
    private player player[];
    private JScrollPane textScroll = new JScrollPane();
    public JTextArea textField = new JTextArea();

    public dicePanel(player pIn[]) {
        this.setVisible(false);
        this.setLayout(new BorderLayout(1,1));
        this.setBackground(Color.BLACK);

        player = pIn;
        playerControl.setDicePanel(this);
        currentPlayer = new JLabel(player[config.cP].name);

        add(nP, BorderLayout.NORTH);
            nP.setPreferredSize(new Dimension(800,20));
            nP.setAlignmentX(TOP_ALIGNMENT);
        add(cP, BorderLayout.WEST);
            cP.setPreferredSize(new Dimension(70*config.dices,200));
        add(sP, BorderLayout.EAST);
            sP.setPreferredSize(new Dimension(800-70*config.dices,200));

        sP.add(textScroll);
            textScroll.setPreferredSize(new Dimension(800-70*config.dices-50,150));
            textScroll.setVisible(true);
        textScroll.add(textField);
            textField.setBackground(new java.awt.Color(204, 204, 204));
            textField.setEditable(false);
            textField.setFont(new java.awt.Font("DialogInput", 0, 14));
            textField.setFocusable(false);
            textScroll.setViewportView(textField);

        nP.add(titleLbl);
            titleLbl.setPreferredSize(new Dimension(53,10));
        nP.add(currentPlayer);
            currentPlayer.setPreferredSize(new Dimension(100,10));

        showDices();
        playerControl.showButtons(false);

        roll.setPreferredSize(new Dimension(300,45));
        roll.addActionListener(rollButton);
        changePlayerBTN.setPreferredSize(new Dimension(300,45));
        changePlayerBTN.addActionListener(changePlayer);
    }

    java.awt.event.ActionListener rollButton = new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
            player[config.cP].reroll();
            rollTimer.start();
            roll.setEnabled(false);
            playerControl.showButtons(false);
        }
    };
    
    java.awt.event.ActionListener rollEvent = new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(player[config.cP].rollCount == config.maxRolls)
                    roll.setEnabled(false);
                else
                    roll.setEnabled(true);
                
                playerControl.showButtons(true);
                player[config.cP].tips.createTips();
                rollTimer.stop();
            }
    };

    Timer rollTimer = new Timer(gV.rollDelay*gV.rollRepeats+(config.dices*10), rollEvent);
    
    java.awt.event.ActionListener changePlayer = new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
            playerControl.nextPlayer();
        }
    };

    public void showDices() {
        for(int i = 0; i < config.dices; i++) {
            player[config.cP].dice[i] = new dice();
            cP.add(player[config.cP].dice[i].label);
        }

        for(int i = 0; i < config.dices; i++) {
            cP.add(player[config.cP].dice[i].locker);
        }

        cP.add(roll);
        //cP.add(changePlayerBTN);
    }

    public void removeDices() {
        for(int i = 0; i < config.dices; i++) {
            player[config.cP].dice[i].label.setVisible(false);
            player[config.cP].dice[i].locker.setVisible(false);
        }
        cP.removeAll();
    }
    
} //End Class

/**
 *
 * @author Markus aka Flydiverny
 */

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class scorePanel extends JPanel {
    //Upper labels
    private JLabel lblTypes[] = {   new JLabel("Ones"),
                                    new JLabel("Twos"),
                                    new JLabel("Threes"),
                                    new JLabel("Fours"),
                                    new JLabel("Fives"),
                                    new JLabel("Sixes"),
                                    new JLabel("Sum"),
                                    new JLabel("Bonus"),
                                    new JLabel("One Pair"),
                                    new JLabel("Two Pairs"),
                                    new JLabel("Three-of-a-Kind"),
                                    new JLabel("Four-of-a-Kind"),
                                    new JLabel("Small Straight"),
                                    new JLabel("Large Straight"),
                                    new JLabel("Full House"),
                                    new JLabel("Chance"),
                                    new JLabel("Yahtzee"),
                                    new JLabel("Grand Total"),
    };

    public JButton buttons[] = {   new JButton("Pick"),  //Ones
                                    new JButton("Pick"),  //Twos
                                    new JButton("Pick"),  //Threes
                                    new JButton("Pick"),  //Fours
                                    new JButton("Pick"),  //Fives
                                    new JButton("Pick"),  //Sixes
                                    new JButton("Pick"),  //Sum
                                    new JButton("Pick"),  //Bonus
                                    new JButton("Pick"),  //One Pair
                                    new JButton("Pick"),  //Two Pair
                                    new JButton("Pick"),  //Three-of-a-kind
                                    new JButton("Pick"),  //Four-of-a-kind
                                    new JButton("Pick"),  //Small Straight
                                    new JButton("Pick"),  //Large Straight
                                    new JButton("Pick"),  //Full House
                                    new JButton("Pick"),  //Chance
                                    new JButton("Pick"),  //Yahtzee
                                    new JButton("Pick")  //Grand Total
    };
    private JLabel playerNames[] = new JLabel[config.players];

    private player[] player;

    private JPanel nWrap = new JPanel();
        private JPanel nWrap_eP = new JPanelBG(gV.BLACK_GRADIENT);
        private JPanel nWrap_wP = new JPanelBG(gV.BLACK_GRADIENT);
        private JPanel nWrap_cP = new JPanelBG(gV.BLACK_GRADIENT);

    private JPanel sWrap = new JPanel();
        private JPanel sWrap_eP = new JPanelBG(gV.BLACK_GRADIENT);
        private JPanel sWrap_wP = new JPanelBG(gV.BLACK_GRADIENT);
        private JPanel sWrap_cP = new JPanelBG(gV.BLACK_GRADIENT);

    private JPanel container = new JPanel();

    private JPanel upWrap = new JPanel();
        private JPanel upWrap_eP = new JPanel();
        private JPanel upWrap_wP = new JPanel();
        private JPanel upWrap_cP = new JPanel();

    private JPanel lowWrap = new JPanel();
        private JPanel lowWrap_eP = new JPanel();
        private JPanel lowWrap_wP = new JPanel();
        private JPanel lowWrap_cP = new JPanel();

    private JPanel sumWrap = new JPanel();
        private JPanel sumWrap_eP = new JPanel();
        private JPanel sumWrap_wP = new JPanel();
        private JPanel sumWrap_cP = new JPanel();

    //private JPanel wrap = new JPanel();

    public scorePanel(player pIn[]) {
        this.setVisible(false);
        player = pIn;
        playerControl.setScorePanel(this);
        score.setPlayers(player);
        init();
    }

    public void init() {
        
        setLayout(new BorderLayout(1,1));
        setBackground(Color.BLACK);

        //NORTH WRAP - WP PLAYERS - CP PLAYERNAMES - EP EMPTY
        add(nWrap, BorderLayout.NORTH);
            nWrap.setLayout(new BorderLayout());
            nWrap.setPreferredSize(new Dimension(800,15));
            nWrap.setBackground(Color.BLACK);

        nWrap.add(nWrap_cP, BorderLayout.CENTER);
            nWrap_cP.setPreferredSize(new Dimension(592,15));
            nWrap_cP.setLayout(new GridLayout(1,config.players));
            nWrap_cP.setBackground(Color.GRAY);

        nWrap.add(nWrap_wP, BorderLayout.WEST);
            nWrap_wP.setPreferredSize(new Dimension(100,15));
            nWrap_wP.setBackground(Color.GRAY);
            nWrap_wP.setLayout(new GridLayout(1,1));

        nWrap.add(nWrap_eP, BorderLayout.EAST);
            nWrap_eP.setPreferredSize(new Dimension(100,15));
            nWrap_eP.setBackground(Color.GRAY);

        //NORTH WRAP - WP GRANDTOTAL - CP SCORES - EP EMPTY
        add(sWrap, BorderLayout.SOUTH);
            sWrap.setLayout(new BorderLayout());
            sWrap.setPreferredSize(new Dimension(600,15));
            sWrap.setBackground(Color.BLACK);

        sWrap.add(sWrap_cP, BorderLayout.CENTER);
            sWrap_cP.setPreferredSize(new Dimension(592,15));
            sWrap_cP.setLayout(new GridLayout(1,config.players));
            sWrap_cP.setBackground(Color.GRAY);

        sWrap.add(sWrap_wP, BorderLayout.WEST);
            sWrap_wP.setPreferredSize(new Dimension(100,15));
            sWrap_wP.setBackground(Color.GRAY);
            sWrap_wP.setLayout(new GridLayout(1,1));

        sWrap.add(sWrap_eP, BorderLayout.EAST);
            sWrap_eP.setPreferredSize(new Dimension(100,15));
            sWrap_eP.setBackground(Color.GRAY);

        //CONTAINER FOR LABELS - SCORE - BUTTON
        add(container, BorderLayout.CENTER);
        container.setLayout(new BorderLayout(1,1));
        container.setBackground(Color.BLACK);
        container.setPreferredSize(new Dimension(800,338));

        //UPPER SCORES
        container.add(upWrap, BorderLayout.NORTH);
        upWrap.setLayout(new BorderLayout(1,1));
        upWrap.setBackground(Color.BLACK);
        upWrap.setPreferredSize(new Dimension(800,114));

            upWrap.add(upWrap_cP, BorderLayout.CENTER);
                upWrap_cP.setPreferredSize(new Dimension(592,114));
                upWrap_cP.setLayout(new GridLayout(6,config.players));
                upWrap_cP.setBackground(Color.LIGHT_GRAY);

            upWrap.add(upWrap_wP, BorderLayout.WEST);
                upWrap_wP.setPreferredSize(new Dimension(100,114));
                upWrap_wP.setLayout(new GridLayout(6,1));

            upWrap.add(upWrap_eP, BorderLayout.EAST);
                upWrap_eP.setPreferredSize(new Dimension(100,114));
                upWrap_eP.setLayout(new GridLayout(6,1));

        container.add(sumWrap, BorderLayout.CENTER);
        sumWrap.setLayout(new BorderLayout(1,1));
        sumWrap.setBackground(Color.BLACK);
        sumWrap.setPreferredSize(new Dimension(800,38));
            
            sumWrap.add(sumWrap_cP, BorderLayout.CENTER);
                sumWrap_cP.setPreferredSize(new Dimension(592,38));
                sumWrap_cP.setLayout(new GridLayout(2,config.players));
                sumWrap_cP.setBackground(Color.GRAY);

            sumWrap.add(sumWrap_wP, BorderLayout.WEST);
                sumWrap_wP.setPreferredSize(new Dimension(100,38));
                sumWrap_wP.setBackground(Color.GRAY);
                sumWrap_wP.setLayout(new GridLayout(2,1));

            sumWrap.add(sumWrap_eP, BorderLayout.EAST);
                sumWrap_eP.setPreferredSize(new Dimension(100,38));
                sumWrap_eP.setBackground(Color.GRAY);

        //LOWER SCORES
        container.add(lowWrap, BorderLayout.SOUTH);
        lowWrap.setLayout(new BorderLayout(1,1));
        lowWrap.setBackground(Color.BLACK);
        lowWrap.setPreferredSize(new Dimension(800,171));
        
            lowWrap.add(lowWrap_wP, BorderLayout.WEST);
                lowWrap_wP.setPreferredSize(new Dimension(100,171));
                lowWrap_wP.setLayout(new GridLayout(9,1));

            lowWrap.add(lowWrap_eP, BorderLayout.EAST);
                lowWrap_eP.setPreferredSize(new Dimension(100,171));
                lowWrap_eP.setLayout(new GridLayout(9,1));

            lowWrap.add(lowWrap_cP, BorderLayout.CENTER);
                lowWrap_cP.setPreferredSize(new Dimension(592,171));
                lowWrap_cP.setLayout(new GridLayout(9,config.players));
                lowWrap_cP.setBackground(Color.LIGHT_GRAY);

            nWrap_wP.add(new JLabel("Players")).setForeground(Color.WHITE);
        for(int i = 0; i < playerNames.length; i++) {
            playerNames[i] = new JLabel(player[i].name);
            nWrap_cP.add(playerNames[i]).setForeground(Color.WHITE);
        }

        for(int i = 0; i < 6; i++) {
            upWrap_wP.add(lblTypes[i]);
            for(int y = 0; y < config.players; y++) {
                upWrap_cP.add(player[y].lblScore[i]);
            }
                upWrap_eP.add(buttons[i]);
                buttons[i].setText(lblTypes[i].getText());
                buttons[i].setFont(gV.lockerFont);
        }

        for(int i = 8; i < 17; i++) {
            lowWrap_wP.add(lblTypes[i]);
            for(int y = 0; y < config.players; y++) {
                lowWrap_cP.add(player[y].lblScore[i]);
            }
                lowWrap_eP.add(buttons[i]);
                buttons[i].setText(lblTypes[i].getText());
                buttons[i].setFont(gV.lockerFont);
        }

            sWrap_wP.add(lblTypes[score.GRANDTOTAL]).setForeground(Color.WHITE);
        for(int y = 0; y < config.players; y++) {
            sWrap_cP.add(player[y].lblScore[score.GRANDTOTAL]).setForeground(Color.WHITE);
        }

            sumWrap_wP.add(lblTypes[score.SUM]).setForeground(Color.WHITE);
        for(int y = 0; y < config.players; y++) {
            sumWrap_cP.add(player[y].lblScore[score.SUM]).setForeground(Color.WHITE);
        }
 
            sumWrap_wP.add(lblTypes[score.BONUS]).setForeground(Color.WHITE);
        for(int y = 0; y < config.players; y++) {
            sumWrap_cP.add(player[y].lblScore[score.BONUS]).setForeground(Color.WHITE);
        }

        createButtonListeners();
    }

    java.awt.event.ActionListener button[] = new java.awt.event.ActionListener[buttons.length];

    public void createButtonListeners() {
        for(int i = 0; i < buttons.length; i++) {
                final int x = i;
                button[i] = new java.awt.event.ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                        score.selectThis(x);
                     }
                };
            buttons[i].addActionListener(button[i]);
        }
    }

    public void removeButtonListeners() {
        for(int i = 0; i < buttons.length; i++) {
            buttons[i].removeActionListener(button[i]);
        }
    }
}  //End Class
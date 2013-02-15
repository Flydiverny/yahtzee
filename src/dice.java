/**
 *
 * @author Markus aka Flydiverny
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;

public class dice {

    public int cV;
    private boolean locked = false;
    private boolean konamiCode = false;
    public JButton locker = new JButton("Lock");
    public JLabel label = new JLabel(gV.icon[0]);

    public dice(){
        cV = 0;
        locker.addActionListener(lockButton);
        locker.setPreferredSize(new Dimension(64,30));
        locker.setFont(gV.lockerFont);
        locker.setMargin(gV.lockerInsets);
        locker.setEnabled(false);
        label.addMouseListener(lockMouse);
    }
    
    private int timerRepeats;
    private ActionListener rollEvent = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rollDice();
                timerRepeats++;
                if(timerRepeats == gV.rollRepeats) {
                    timerRepeats = 0;
                    locker.setEnabled(true);
                    timer.stop();
                    if(konamiCode) {
                        cV = 6;
                        showDice();
                        konamiCode = false;
                        playerControl.showButtons(true);
                    }
                }
            }
        };

    private Timer timer = new Timer(gV.rollDelay, rollEvent);
    public void reroll() {
        timer.start();
        locker.setEnabled(false);
    }

    public void konamiCode() {
        konamiCode = true;
        reroll();
    }

    private void rollDice() {
        if(!locked) {
            cV = (int) (Math.random() * config.rollPool) + 1;
            showDice();
        }
    }

    private void showDice() {
        label.setIcon(gV.icon[cV]);
    }

    ActionListener lockButton = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            lockButton();
        }
    };

    MouseListener lockMouse = new java.awt.event.MouseListener() {
        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
            lockButton();
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    };

    private void lockButton() {
        if(locker.isEnabled()) {
            if(!locked) {
                locked = true;
                locker.setText("Unlock");
                label.setIcon(gV.grayIcon[cV]);
            }
            else if(locked) {
                locked = false;
                locker.setText("Lock");
                label.setIcon(gV.icon[cV]);
            }
        }
    }

} //End Class
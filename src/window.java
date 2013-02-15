/**
 *
* @author Markus aka Flydiverny
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class window extends JFrame {
    public gamePanel gamePanel;
    
    public window(String title) {
        this.setTitle(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0,0,800,600);
        this.setPreferredSize(new Dimension(800,600));
        this.setResizable(false);
        this.setJMenuBar(createMenu());
        this.setVisible(true);
        this.addKeyListener(konamiCodeListener);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        score.setWindow(this);
        newGame();
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        menuBar.add(menuFile);
            menuFile.add(menuFileNewGame);
                menuFileNewGame.addActionListener(menuEvents);
            menuFile.add(menuFileExit);
                menuFileExit.addActionListener(menuEvents);
        menuBar.add(menuHelp);
            menuHelp.add(menuHelpRules);
            menuHelp.add(menuHelpAbout);

        return menuBar;
    }

    private JMenu menuFile = new JMenu("File");
        private JMenuItem menuFileNewGame = new JMenuItem("New Game", KeyEvent.VK_N);
        private JMenuItem menuFileExit = new JMenuItem("Exit");
    private JMenu menuHelp = new JMenu("Help");
        private JMenuItem menuHelpRules = new JMenuItem("Rules");
        private JMenuItem menuHelpAbout = new JMenuItem("About");
            
    java.awt.event.ActionListener menuEvents = new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == menuFileExit)
                System.exit(0);
            if(e.getSource() == menuFileNewGame)
                newGame();
        }
    };

    public void newGame() {
        if(this.isAncestorOf(gamePanel)) {
            gamePanel.setVisible(false);
            this.remove(gamePanel);
            gamePanel = null;
        }
        
        gamePanel = new gamePanel(this);
        gamePanel.setPreferredSize(new Dimension(800,600));
        add(gamePanel,BorderLayout.CENTER);
        gamePanel.setVisible(true);
        this.pack();
    }
    
    private int konamiCode[] = { 
        java.awt.event.KeyEvent.VK_UP,
        java.awt.event.KeyEvent.VK_UP,
        java.awt.event.KeyEvent.VK_DOWN,
        java.awt.event.KeyEvent.VK_DOWN,
        java.awt.event.KeyEvent.VK_LEFT,
        java.awt.event.KeyEvent.VK_RIGHT,
        java.awt.event.KeyEvent.VK_LEFT,
        java.awt.event.KeyEvent.VK_RIGHT,
        java.awt.event.KeyEvent.VK_B,
        java.awt.event.KeyEvent.VK_A,
    };
    private int keyClicks = 0;

    java.awt.event.KeyListener konamiCodeListener = new java.awt.event.KeyListener() {
        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
            if(konamiCode[keyClicks] == e.getKeyCode())
                keyClicks++;
            else
                keyClicks = 0;

            if(keyClicks == konamiCode.length) {
                for(int i = 0; i < config.dices; i++) {
                    gamePanel.player[config.cP].dice[i].konamiCode();
                }
                keyClicks = 0;
            }
        }

        public void keyReleased(KeyEvent e) {
        }
    };
    

} //End Class
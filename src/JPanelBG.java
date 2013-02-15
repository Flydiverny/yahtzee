/**
 *
 * @author Markus aka Flydiverny
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

class JPanelBG extends JPanel {
    private Image img;

    public JPanelBG(String img) {
        this(gV.createImageIcon(img, "asdf").getImage());
    }

    public JPanelBG(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
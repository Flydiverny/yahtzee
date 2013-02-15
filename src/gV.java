/**
 *
 * @author Markus aka Flydiverny
 */

import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.GrayFilter;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class gV {
    public static Insets lockerInsets = new Insets(2,2,2,2);
    public static Font lockerFont = new java.awt.Font("Verdana", Font.PLAIN, 11);
    public static Font infoFont = new Font("Verdana", Font.BOLD, 11);
    public static Font scoreFont = new Font("Verdana", Font.PLAIN, 11);
    public static int rollRepeats = 20;
    public static int rollDelay = 70;

    public static String BROWN_GRADIENT = "img/brownGradient.png";
    public static String BROWN_GRADIENT30 = "img/brownGradient30.png";
    public static String BLACK_GRADIENT = "img/blackGradient.png";
    public static String BLACK_GRADIENT_BIG = "img/blackGradientBIG.png";

    public static ImageIcon icon[] = {createImageIcon("img/d0c.png","One"),
                                createImageIcon("img/d1c.png","One"),
                                createImageIcon("img/d2c.png","Two"),
                                createImageIcon("img/d3c.png","Three"),
                                createImageIcon("img/d4c.png","Four"),
                                createImageIcon("img/d5c.png","Five"),
                                createImageIcon("img/d6c.png","Six"),
                                createImageIcon("img/d7c.png","Seven"),
                                createImageIcon("img/d8c.png","Eight"),
                                createImageIcon("img/d9c.png","Nine"),};

    private static Image normalImg[] = {
                                icon[0].getImage(),
                                icon[1].getImage(),
                                icon[2].getImage(),
                                icon[3].getImage(),
                                icon[4].getImage(),
                                icon[5].getImage(),
                                icon[6].getImage(),
                                icon[7].getImage(),
                                icon[8].getImage(),
                                icon[9].getImage(),
    };

    private static Image grayImg[] = {
                                GrayFilter.createDisabledImage(normalImg[0]),
                                GrayFilter.createDisabledImage(normalImg[1]),
                                GrayFilter.createDisabledImage(normalImg[2]),
                                GrayFilter.createDisabledImage(normalImg[3]),
                                GrayFilter.createDisabledImage(normalImg[4]),
                                GrayFilter.createDisabledImage(normalImg[5]),
                                GrayFilter.createDisabledImage(normalImg[6]),
                                GrayFilter.createDisabledImage(normalImg[7]),
                                GrayFilter.createDisabledImage(normalImg[8]),
                                GrayFilter.createDisabledImage(normalImg[9]),
    };

    public static Icon grayIcon[] = {
                                new ImageIcon(grayImg[0]),
                                new ImageIcon(grayImg[1]),
                                new ImageIcon(grayImg[2]),
                                new ImageIcon(grayImg[3]),
                                new ImageIcon(grayImg[4]),
                                new ImageIcon(grayImg[5]),
                                new ImageIcon(grayImg[6]),
                                new ImageIcon(grayImg[7]),
                                new ImageIcon(grayImg[8]),
                                new ImageIcon(grayImg[9]),
    };

    protected static ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = gV.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}

package control;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class idPanel extends JPanel {
    Image idcard;

    /**
     * This method is used to draw the id panel
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        try {
            idcard= ImageIO.read(new File("src/image/idcard.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(idcard,450,0,300,200,null);

    }
}

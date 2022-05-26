package boundary;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class botBar extends JPanel {
    Image bottom;

    @Override
    public void paint(Graphics g){
        super.paint(g);
        try {
            bottom = ImageIO.read(new File("bottom.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bottom,0,0,1200,80,null);
    }

}

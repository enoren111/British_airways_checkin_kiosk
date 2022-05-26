package boundary;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class topBar extends JPanel {
    Image head2;
    Image sky;
    @Override
    public void paint(Graphics g){
        super.paint(g);
        try {
            head2 = ImageIO.read(new File("ba_masterbrand_positive.png"));
            sky = ImageIO.read(new File("topsky.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(sky,0,0,this.getWidth(),this.getHeight(),null);
        g.drawImage(head2,10,8,300,45,null);
    }
}

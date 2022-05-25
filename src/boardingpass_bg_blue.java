import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class boardingpass_bg_blue extends JPanel {
    Image boarding_bg;
    String name,counter_num;

    public boardingpass_bg_blue(String name, String counter_num){
        this.name=name;
        this.counter_num=counter_num;
    }


    @Override
    public void paint(Graphics g2) {
        super.paint(g2);
        try {
            boarding_bg= ImageIO.read(new File("boardingpass_blue.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics2D g = (Graphics2D) g2;
        Font font1=new Font("Century", Font.PLAIN,55);
        Font font2=new Font("Montserrat", Font.PLAIN,35);
        Font font3=new Font("Montserrat", Font.PLAIN,15);

        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(font1);
        g.drawImage(boarding_bg,50,5,290,550,null);

        g.drawString("CITY",55,70);
        g.drawString("CITY",135,130);

        g.setFont(font2);
        g.drawString(name,55,200);

        g.setFont(font3);
        g.setColor(Color.gray);
        g.drawString("Name",57,220);

        g.setFont(font2);
        g.setColor(Color.BLACK);
        g.drawString(counter_num,55,300);

        g.setFont(font3);
        g.setColor(Color.gray);
        g.drawString("Check-In Counter",57,320);

    }
}

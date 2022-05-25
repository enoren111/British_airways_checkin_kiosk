import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class boardingpass_bg_yellow extends JPanel {
    Image boarding_bg;
    String name,carry_num;

    public boardingpass_bg_yellow(String name,String carry_num){
        this.name=name;
        this.carry_num=carry_num;
    }

    @Override
    public void paint(Graphics g2) {
        super.paint(g2);
        try {
            boarding_bg= ImageIO.read(new File("boardingpass_yellow.png"));
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
        g.drawString(carry_num,55,300);

        g.setFont(font3);
        g.setColor(Color.gray);
        g.drawString("Carry-On Number",57,320);
    }
}
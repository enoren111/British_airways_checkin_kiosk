package control;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class boardingpass_bg extends JPanel {
    Image boarding_bg;
    String path,sort;
    Ticket myTicket;
    Flight myFlight;

    public boardingpass_bg( String path,Ticket myTicket,Flight myFlight,String sort){
        this.path=path;
        this.myTicket=myTicket;
        this.myFlight=myFlight;
        this.sort=sort;
    }


    @Override
    public void paint(Graphics g2) {
        super.paint(g2);
        try {
            boarding_bg= ImageIO.read(new File(path));
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

        g.drawString(myFlight.getStartAcronym(),55,70);
        g.drawString(myFlight.getDestinationAcronym(),135,130);

        g.setFont(font2);
        g.drawString(myTicket.getName(),55,200);

        g.setFont(font3);
        g.setColor(Color.gray);
        g.drawString("Name",57,220);

        g.setFont(font2);
        g.setColor(Color.BLACK);
        switch (sort) {
            case "Check-In Counter: " -> g.drawString(myTicket.getCounterNumber(), 55, 300);
            case "Carry-On Number: " -> g.drawString(myTicket.getCarryOnBaggageNumber(), 55, 300);
            case "Boarding Number: " -> g.drawString(myFlight.getBoardingGate(), 55, 300);
            default -> g.drawString("Something Wrong happens!", 55, 300);
        }

        g.setFont(font3);
        g.setColor(Color.gray);
        g.drawString(sort,57,320);

    }
}

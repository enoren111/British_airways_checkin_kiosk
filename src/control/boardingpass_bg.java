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

    public boardingpass_bg(String path,Ticket myTicket,Flight myFlight,String sort){
        this.path=path;
        this.myTicket=myTicket;
        this.myFlight=myFlight;
        this.sort=sort;
    }

    /**
     * This method is used to paint the background of three tickets.
     * @param g2
     */

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
        Font font2=new Font("Montserrat", Font.BOLD,35);
        Font font3=new Font("Montserrat",Font.PLAIN,25);
        Font font4=new Font("Montserrat", Font.PLAIN,15);

        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(font1);
        g.drawImage(boarding_bg,50,5,290,550,null);

        g.drawString(myFlight.getStartAcronym(),55,70);
        g.drawString(myFlight.getDestinationAcronym(),135,130);

        g.setFont(font2);
        g.drawString(myTicket.getName(),55,200);

        switch (sort) {
            case "Gate: " -> {
                g.setFont(font3);
                g.drawString(myFlight.getFightDate(), 55, 250);
                g.drawString(myFlight.getBoardingGate(), 225, 250);
                g.drawString(myFlight.getFlightNumber(),55,320);
                g.drawString(myTicket.getSeatNumber(),225,320);
                g.drawString(myFlight.getBoardingTime(),55,390);
                g.drawString(myFlight.getFlyTime(),225,390);
                g.setFont(font4);
                g.setColor(Color.gray);
                g.drawString("Date",57,265);
                g.drawString("Gate",227,265);
                g.drawString("Flight",57,335);
                g.drawString("Seat",227,335);
                g.drawString("Boarding",57,405);
                g.drawString("Fly-Time",227,405);
            }
            case "Carry-On: " ->{
                g.setFont(font3);
                g.drawString(myTicket.getCarryOnBaggageNumber(), 55, 250);
                g.setFont(font4);
                g.setColor(Color.gray);
                g.drawString("Carry-On",57,265);
                g.setColor(Color.BLACK);
                g.drawString("Hint: ",57,320);
                g.drawString("1. Power Bank are not allowed to take.",57,340);
                g.drawString("2. Acuity things (like knives) are prohibited.",57,360);
            }
            case "Counter: " -> {
                g.setFont(font3);
                g.drawString(myTicket.getCounterNumber(), 55, 250);
                g.setFont(font4);
                g.setColor(Color.gray);
                g.drawString("Counter to Check-In",57,265);
                g.setColor(Color.BLACK);
                g.drawString("Hint: ",57,320);
                g.drawString("A-F are in the first floor.",57,340);
                g.drawString("G-T are in the second floor.",57,360);
                g.drawString("U-Z are in the third floor",57,380);
            }
            default -> g.drawString("Something Wrong happens!", 55, 300);
        }


    }

}

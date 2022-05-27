package boundary;

import control.Customer;
import control.FlightDatabase;
import control.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/** this frame is used for passenger choosing ticket after input id document
 * @author Songyun Yang
 * @version  1.0
 */
public class ChooseTicket extends MainFrame{

    private JLabel titleLabel;
    private JButton bookingNumber, idDocument, scanning;
    //use to close itself
    private final JFrame jframe = this;
    private JButton back,ticketButton;
    JPanel panel1 = new JPanel();
    Customer database=new Customer();
    FlightDatabase flightDatabase = new FlightDatabase();

    public ChooseTicket(Ticket[] ticket) {
        GridLayout gridLayout = new GridLayout(7, 1);

        panel1.setLayout(gridLayout);
        init1(ticket);
        init(panel1);
        actionEvent();

    }

    public void init1(Ticket[] ticketlist){
        //set four panel, 1 panel is use to set title, other 3 is used to contain button
        JPanel titlePanel = new JPanel();
        titleLabel=new JLabel("Please choose flight");
        titleLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
        titlePanel.add(titleLabel);
        panel1.add(titlePanel);
        int i;
        for(i=0;i<5;i++){
            if(ticketlist[i]!=null) {
                GridLayout panelLayout = new GridLayout(1, 5);
                JPanel ticketpanel = new JPanel();
                ticketpanel.setLayout(panelLayout);
                ticketpanel.add(new JPanel());
                JTextArea numbertext = new JTextArea(20,4);
                JTextArea tickettext = new JTextArea(20,4);
                //tickettext.setAlignmentX(CENTER_ALIGNMENT);
                //tickettext.setAlignmentY(CENTER_ALIGNMENT);
                tickettext.setText("   Flight Number:"+ticketlist[i].getFlightNumber()+"\n"+
                        "   From:"+flightDatabase.searchFlight(ticketlist[i].getFlightNumber()).getStart() +"  To:"+
                        flightDatabase.searchFlight(ticketlist[i].getFlightNumber()).getDestination());

                numbertext.setText("\n"+"Ticket Number:"+ticketlist[i].getBookNumber());
                //System.out.println(ticketlist[i].getBookNumber());
                tickettext.setOpaque(false);
                numbertext.setOpaque(false);
                numbertext.setFont(new Font("Arial Black", Font.BOLD, 15));
                tickettext.setFont(new Font("Arial Black", Font.BOLD, 15));
                ticketpanel.add(numbertext);
                ticketpanel.add(tickettext);

                int q=i;
                ticketButton = new JButton("Confirm");
                ticketButton.setPreferredSize(new Dimension(200,40));
                ticketButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
                ticketButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println(ticketlist[q].getBookNumber());
                        new InformationConfirm(ticketlist[q]);
                        jframe.dispose();
                    }
                });
                JPanel subpanel =new JPanel();
                ticketpanel.setLocation(100,100);
                subpanel.add(ticketButton);
                ticketpanel.add( subpanel);
                ticketpanel.add(new JPanel());
                panel1.add(ticketpanel);
            }
        }

        JPanel buttonPanel = new JPanel();
        back=new JButton("back");

        back.setPreferredSize(new Dimension(100,30));
        buttonPanel.add(back);
        panel1.add(buttonPanel);
    }

    public void actionEvent(){

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ChooseLoginWay();
                jframe.dispose();
            }
        });

    }

}


package boundary;

import control.Flight;
import control.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *  Title: MyFrame1.java
 *  Description:This is the screen showing the boarding information
 *  @author Richao, Li Tianyi, Ren
 *  @since 2022.3.27
 *  @version 5.0
 */
public class InformationConfirm extends MainFrame {

    JFrame DFrame1 = new JFrame();
    JFrame jframe = this;

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel maintainer = new JPanel();
    JPanel p5 = new JPanel();


    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;


    JButton b1;
    JButton b2;

    GridBagLayout g1 = new GridBagLayout();
    GridBagConstraints gb1 = new GridBagConstraints();
    GridBagConstraints gb2 = new GridBagConstraints();
    GridBagConstraints gb3 = new GridBagConstraints();
    GridBagConstraints gb4 = new GridBagConstraints();
    GridBagConstraints gb5 = new GridBagConstraints();

    Ticket myTicket;
    Flight myFlight;

    public  InformationConfirm(Ticket myTicket, Flight myFlight) {

        maintainer.setSize(400, 400);
        maintainer.setLocation(100, 100);
        //Frame layout design
        maintainer.setLayout(g1);

        this.myTicket=myTicket;
        this.myFlight=myFlight;
        //Set for first panel
        gb1.fill = GridBagConstraints.HORIZONTAL;
        gb1.weighty = 100;
        gb1.gridy = 1;
        //Set for second panel
        gb2.fill = GridBagConstraints.HORIZONTAL;
        gb2.weighty = 300;
        gb2.gridy = 2;
        //Set for third panel
        gb3.fill = GridBagConstraints.HORIZONTAL;
        gb3.weighty = 30;
        gb3.gridy = 4;
        //Set for forth panel
        gb4.fill = GridBagConstraints.HORIZONTAL;
        gb4.weighty = 30;
        gb4.gridy = 5;
        gb5.fill = GridBagConstraints.HORIZONTAL;
        gb5.weighty = 300;
        gb5.gridy = 3;
        FirstSet();
        SecondSet();
        ThirdSet();
        ForthSet();
        FifthSet();
        init(maintainer);
        this.setVisible(true);


    }


    public void FirstSet() {
        //The layout setting for first panel
        p1.setBorder(BorderFactory.createTitledBorder("Your flight name"));
        p1.setSize(400, 100);

        l1 = new JLabel(myTicket.getFlightNumber(), JLabel.CENTER);
        l1.setFont(new Font(null, Font.PLAIN, 40));
        l1.setForeground(Color.blue);
        p1.add(l1);
        g1.setConstraints(p1, gb1);
        maintainer.add(p1);
    }


    public void SecondSet() {
        //The layout setting for second panel
        p2.setBorder(BorderFactory.createTitledBorder("Detail Information"));
        p2.setSize(400, 400);
        l2 = new JLabel("Your Name:"+myTicket.getName());
        l3 = new JLabel("Your Book number:"+myTicket.getBookNumber());
        l4 = new JLabel("Time: 10:00~12:00");
        JLabel l7 = new JLabel("Boarding Entrance: C7");
        l2.setFont(new Font(null, Font.PLAIN, 25));
        l3.setFont(new Font(null, Font.PLAIN, 25));
        l4.setFont(new Font(null, Font.PLAIN, 25));
        l7.setFont(new Font(null, Font.PLAIN, 25));
        l2.setBorder(BorderFactory.createLineBorder(Color.black));
        l3.setBorder(BorderFactory.createLineBorder(Color.black));
        l4.setBorder(BorderFactory.createLineBorder(Color.black));
        l7.setBorder(BorderFactory.createLineBorder(Color.black));
        //Create a box to arrange three texts
        Box box3 = Box.createVerticalBox();
        box3.add(l2);
        //Creates a fixed - width interval between two text fields.
        box3.add(Box.createVerticalStrut(10));
        box3.add(l3);
        box3.add(Box.createVerticalStrut(10));
        box3.add(l4);
        box3.add(Box.createVerticalStrut(10));
        box3.add(l7);
        p2.add(box3);
        g1.setConstraints(p2, gb2);
        maintainer.add(p2);
    }
    public void FifthSet() {
        //The layout setting for second panel
        p5.setBorder(BorderFactory.createTitledBorder("Matters Needing Attention"));
        p5.setSize(400, 400);
        JLabel mna1 = new JLabel("1.Please check your personal boarding information carefully. " +
                                       "If there is any discrepancy, please contact the staff." );
        JLabel mna2 = new JLabel("2. Please keep the printed boarding pass and take your ID card " +
                                      "and boarding pass to the designated boarding gate.");
        JLabel mna3 = new JLabel("3. The upper limit for personal luggage is 4kg, " +
                                       "and the upper limit for checked luggage is 20kg.");
        JLabel mna4 = new JLabel("4. If you have any operational or other problems," +
                                       " please contact our staff or call ******* for assistance.");
        mna1.setFont(new Font(null, Font.PLAIN, 20));
        mna2.setFont(new Font(null, Font.PLAIN, 20));
        mna3.setFont(new Font(null, Font.PLAIN, 20));
        mna4.setFont(new Font(null, Font.PLAIN, 20));
        mna1.setBorder(BorderFactory.createLineBorder(Color.black));
        mna2.setBorder(BorderFactory.createLineBorder(Color.black));
        mna3.setBorder(BorderFactory.createLineBorder(Color.black));
        mna4.setBorder(BorderFactory.createLineBorder(Color.black));
        //Create a box to arrange three texts
        Box box3 = Box.createVerticalBox();
        box3.add(mna1);
        //Creates a fixed - width interval between two text fields.
        box3.add(Box.createVerticalStrut(10));
        box3.add(mna2);
        box3.add(Box.createVerticalStrut(10));
        box3.add(mna3);
        box3.add(Box.createVerticalStrut(10));
        box3.add(mna4);
        p5.add(box3);
        g1.setConstraints(p5, gb5);
        maintainer.add(p5);
    }


    public void ThirdSet() {
        //The layout setting for third panel
        p3.setSize(400, 50);
        String mySeatState=myTicket.getSeatNumber().split(",")[0];
        if(mySeatState.equals("-1")) {
            l5 = new JLabel("Click the button to print");
            l5.setFont(new Font(null, Font.PLAIN, 20));
            b2 = new JButton("print");
            b2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new boardingpass(myTicket,myFlight);
                    jframe.dispose();
                }
            });
        }
        else{
            l5 = new JLabel("Click the button to select seats and food");
            l5.setFont(new Font(null, Font.PLAIN, 20));
            b2 = new JButton("confirm");
            b2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    new FlightFrame(myTicket.getBookNumber());
                    jframe.dispose();
                }
            });
        }
        Box box3 = Box.createHorizontalBox();
        box3.add(l5);
        box3.add(Box.createHorizontalStrut(30));
        box3.add(b2);
        p3.add(box3);
        g1.setConstraints(p3, gb3);
        maintainer.add(p3);


    }

    //Set up the popover after clicking the print button
    public int Dialog2(){
        DFrame1.setLocationRelativeTo(null);
        DFrame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int result = JOptionPane.showConfirmDialog(DFrame1,"Have you checked all the information is correct?" +
                        "If you find the information incorrect, please contact the staff member. "
                ,"Confirm check in",JOptionPane.YES_NO_OPTION);
        return result;
    }

    public void ForthSet() {
        //The layout setting for forth panel
        b1 = new JButton("Exit");
        //Sets the behavior after the button is clicked
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChooseLoginWay();
                jframe.dispose();
            }
        });
        Box box4 = Box.createHorizontalBox();
        l6=new JLabel("Click this button to return to the login page ");
        l6.setFont(new Font(null, Font.PLAIN, 20));
        box4.add(l6);
        box4.add(Box.createHorizontalStrut(30));
        box4.add(b1);
        p4.add(box4);
        g1.setConstraints(p4, gb4);
        maintainer.add(p4);
    }
}



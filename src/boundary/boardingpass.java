package boundary;

import control.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** this class is used to print boarding pass, carry-on bag and check-In counter.
 * @author Tianyi Ren
 * @version  12351235
 */

public class boardingpass extends MainFrame implements ActionListener {

    JButton bt1=new JButton("Print");
    JButton bt2=new JButton("Done");

    public boardingpass(Ticket myTicket,Flight myFlight){

        /*The panel used to contain the other two panels.*/
        JPanel panel1=new JPanel();
        panel1.setLayout(new BorderLayout());

        /*Show the information of the interface.*/
        JPanel panel2=new JPanel();
        panel1.add(panel2,BorderLayout.CENTER);
        panel2.setBorder(BorderFactory.createBevelBorder(2));
        panel2.setLayout(new GridLayout(1,3,4,4));

        boardingpass_bg p1=new boardingpass_bg("src/image/boardingpass_blue.png", myTicket,myFlight,"Gate: ");
        boardingpass_bg p2=new boardingpass_bg("src/image/boardingpass_yellow.png",myTicket,myFlight,"Carry-On: ");
        boardingpass_bg p3=new boardingpass_bg("src/image/boardingpass_green.png",myTicket,myFlight,"Counter: ");

        p1.setPreferredSize(new Dimension(290,550));
        p2.setPreferredSize(new Dimension(290,550));
        p3.setPreferredSize(new Dimension(290,550));

        p1.setBackground(new Color(242,231,234) );
        p2.setBackground(new Color(242,231,234) );
        p3.setBackground(new Color(242,231,234) );

        panel2.add(p1);
        panel2.add(p2);
        panel2.add(p3);

        /*The area used to return*/
        JPanel panel3=new JPanel();
        panel1.add(panel3,BorderLayout.SOUTH);

        panel3.setBorder(BorderFactory.createBevelBorder(1));
        panel3.setPreferredSize(new Dimension(1200,38));
        panel3.setBackground(new Color(242,231,234));

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        panel3.add(bt1);
        panel3.add(bt2);

        init(panel1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt1){
            String[] options = { "OK ", "CANCEL " };
            String[] option={"OK"};
            int n =  JOptionPane.showOptionDialog(null,"Do you want to print?",
                    "Print Choice", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                    null,options,options[0]);
            if (n==1){
                JOptionPane.showOptionDialog(null,"Print Successfully","Success",
                        JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,option,option[0]);
            }
        }
        else if(e.getSource()==bt2){
                System.exit(0);
        }
    }
}

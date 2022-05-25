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
                JPanel ticketpanel = new JPanel();
                JLabel ticketLabel = new JLabel("Yor ticket booking number: "+ticketlist[i].getBookNumber());
                JLabel ticketLabel1 = new JLabel("    flight number: "+ticketlist[i].getFlightNumber());
                //System.out.println(ticketlist[i].getBookNumber());
                ticketLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
                ticketLabel1.setFont(new Font("Arial Black", Font.BOLD, 12));
                ticketpanel.add(ticketLabel);
                ticketpanel.add(ticketLabel1);

                int q=i;
                ticketButton = new JButton("Confirm");
                ticketButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println(ticketlist[q].getBookNumber());
                        new InformationConfirm(ticketlist[q].getBookNumber());
                        jframe.dispose();
                    }
                });
                ticketpanel.add(ticketButton);
                panel1.add(ticketpanel);
            }
        }

        JPanel buttonPanel = new JPanel();
        back=new JButton("back");
        back.setSize(100,30);
        buttonPanel.add(back);
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


package boundary;

import control.Customer;
import control.Flight;
import control.FlightDatabase;
import control.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/** this class is boundary. Login method of booking number, passenger input the booking number to confirm unique ticket
 * @author Songyun Yang
 * @version  1.34
 */
public class LoginWay1 extends MainFrame {

    private JButton confirm, back;
    private final JFrame jframe=this;
    private JTextField bookingNumber;
    JPanel panel1 = new JPanel();

    public LoginWay1(){
        GridLayout gridLayout = new GridLayout(3, 1);

        panel1.setLayout(gridLayout);
        init1();
        init(panel1);
        actionEvent();
        setTitle("Booking Number Login");
    }

    public void init1(){
        //set four panel, 1 panel is used to set title, other 3 is used to contain button
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();

        JLabel titleLabel = new JLabel("Please in put your booking number");
        titleLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
        Panel1.add(titleLabel);

        confirm=new JButton("confirm");
        confirm.setSize(100,30);
        Panel3.add(confirm);

        back=new JButton("back");
        back.setSize(100,30);
        Panel3.add(back);

        bookingNumber = new JTextField();
        bookingNumber.setColumns(20);
        bookingNumber.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        Panel2.add(bookingNumber);
        Panel2.setBorder(BorderFactory.createTitledBorder("bookingNumber:"));

        panel1.add(Panel1);
        panel1.add(Panel2);
        panel1.add(Panel3);
    }

    public void actionEvent(){
        confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Customer database = new Customer();
                FlightDatabase flightDatabase=new FlightDatabase();

                Ticket myTicket = database.checkBookNumber(bookingNumber.getText());


                if(myTicket==null){
                    bookingNumber.setText("");
                    bookingNumber.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red),
                            "Wrong"));
                }else {
                    Flight myFlight= flightDatabase.searchFlight(myTicket.getFlightNumber());
                    new InformationConfirm(myTicket,myFlight);
                    jframe.dispose();
                }
            }
        });

        back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new ChooseLoginWay();
                jframe.dispose();
            }
        });

    }

}

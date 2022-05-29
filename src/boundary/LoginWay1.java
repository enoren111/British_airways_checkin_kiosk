package boundary;

import control.*;

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
    Warning warning = new Warning();
    Head1 titleLabel;

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

        titleLabel = new Head1("Please in put your booking number");
        Panel1.add(titleLabel);

        confirm=new Button1("confirm");

        Panel3.add(confirm);

        back=new Button1("back");
        Panel3.add(back);


        Head2 textHead = new Head2("BookingNumber:") ;
        bookingNumber = new TextFiled1();
        Panel2.add(textHead);
        Panel2.add(bookingNumber);
        Panel2.add(warning);
        //Panel2.setBorder(BorderFactory.createTitledBorder("bookingNumber:"));

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
                    //bookingNumber.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red),"Wrong"));
                    warning.setVisible(true);
                    titleLabel.setText("Please retype.");
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/** this class is login method of booking number, passenger input the booking number to confirm unique ticket
 * @author Songyun Yang
 * @version  1.0
 */
public class LoginWay1 extends MainFrame{

    private JLabel titleLabel;
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
        //set four panel, 1 panel is use to set title, other 3 is used to contain button
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();

        titleLabel=new JLabel("Please in put your booking number");
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
                Database database = new Database();
                Ticket ticket = database.checkBookNumber(bookingNumber.getText());
                if(ticket==null){
                    bookingNumber.setText("");
                    bookingNumber.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Wrong"));
                }else {
                    new InformationConfirm(bookingNumber.getText());
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

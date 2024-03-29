package boundary;

import control.Button1;
import control.Head1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/** this class is used for passenger choosing boundary.login way, the first frame temporarily
 * @author Songyun Yang
 * @version  1.0
 */
public class ChooseLoginWay extends MainFrame {

    private JLabel titleLabel;
    private JButton bookingNumber, idDocument, scanning;
    //use to close itself
    private final JFrame jframe = this;

    JPanel panel1 = new JPanel();
    public ChooseLoginWay() {
        GridLayout gridLayout = new GridLayout(4, 1);

        panel1.setLayout(gridLayout);
        setTitle("Login");
        init1();
        init(panel1);
        actionEvent();

    }

    public void init1(){
        //set four panel, 1 panel is use to set title, other 3 is used to contain button
        JPanel titlePanel = new JPanel();
        JPanel log1Panel = new JPanel();
        JPanel log2Panel = new JPanel();
        JPanel log3Panel = new JPanel();

        titleLabel=new Head1("Please choose login way");
        titlePanel.add(titleLabel);

        bookingNumber=new Button1("Booking number");
        log1Panel.add(bookingNumber);

        idDocument=new Button1("id document");
        log2Panel.add(idDocument);

        scanning=new Button1("scan id document");
        log3Panel.add(scanning);


        panel1.add(titlePanel);
        panel1.add(log1Panel);
        panel1.add(log2Panel);
        panel1.add(log3Panel);
    }

    public void actionEvent(){

        bookingNumber.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginWay1();
                jframe.dispose();
            }
        });

        idDocument.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginWay2();
                jframe.dispose();
            }
        });

        scanning.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginWay3();
                jframe.dispose();
            }
        });
    }

}

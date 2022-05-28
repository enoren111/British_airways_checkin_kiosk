package boundary;

import control.Customer;
import control.Ticket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/** this class is use id document and surname to boundary.login. After passenger input, passenger can choose the flight
 * @author Songyun Yang
 * @version  1.234567
 */
public class LoginWay2 extends MainFrame {

    private JButton confirm, back;
    //used to close itself
    private final JFrame jframe = this;
    private JTextField Name, idDocument;
    JPanel panel1 = new JPanel();
    Warning warning = new Warning();
    Head1 titleLabel;

    public LoginWay2() {
        GridLayout gridLayout = new GridLayout(4, 1);
        panel1.setLayout(gridLayout);

        init1();
        init(panel1);
        actionEvent();
        this.setTitle("Id Document Login");
    }

    public void init1(){
        //set four panel, 1 panel is used to set title
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();
        JPanel Panel4 = new JPanel();

        titleLabel = new Head1("Please input your surname and id");
        Panel1.add(titleLabel);

        confirm=new Button1("confirm");
        Panel4.add(confirm);

        back=new Button1("back");
        Panel4.add(back);

        Name = new TextFiled1();
        idDocument = new TextFiled1();
        Panel2.add(new Head2("   surName:"));
        Panel3.add(new Head2("idDocument:"));
        Panel2.add(Name);
        Panel3.add(idDocument);
        Panel3.add(warning);

        //Panel2.setBorder(BorderFactory.createTitledBorder("Name:"));
        //Panel3.setBorder(BorderFactory.createTitledBorder("id document:"));

        panel1.add(Panel1);
        panel1.add(Panel2);
        panel1.add(Panel3);
        panel1.add(Panel4);
    }

    public void actionEvent(){

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ChooseLoginWay();
                jframe.dispose();
            }
        });

        confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Customer database = new Customer();
                Ticket[] tickets = database.checkIdDocument(Name.getText(),idDocument.getText());
                if(tickets==null){
                    idDocument.setText("");
                    //idDocument.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Wrong"));
                    warning.setVisible(true);
                    titleLabel.setText("Please retype");
                }
                else{
                    new ChooseTicket(tickets);
                    jframe.dispose();
                }
            }
        });

    }

}
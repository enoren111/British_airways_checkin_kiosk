package boundary;

import control.idPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/** this class is fake database, to test Login part
 * @author Songyun Yang
 * @version  1.0
 */
public class LoginWay3 extends MainFrame {

    private JButton confirm, back;
    private final JFrame jframe=this;
    JPanel panel1 = new JPanel();

    public LoginWay3() {
        GridLayout gridLayout = new GridLayout(3, 1);

        panel1.setLayout(gridLayout);
        init1();
        init(panel1);
        actionEvent();
        this.setTitle("Scan");
        this.setVisible(true);
    }

    public void init1(){
        //set four panel, 1 panel is used to set title, other 3 is used to contain button
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new idPanel();
        JPanel Panel3 = new JPanel();


        JLabel titleLabel = new Head1("Please in put id document on the scanning desk");
        Panel1.add(titleLabel);
        Panel1.setSize(1200,200);
        Panel1.setBackground(Color.YELLOW);

        Panel2.setSize(1200,800);
        Panel2.setBackground(Color.cyan);


        confirm=new Button1("confirm");
        Panel3.add(confirm);

        back=new Button1("back");
        Panel3.add(back);

        panel1.add(Panel1);
        panel1.add(Panel2);
        panel1.add(Panel3);
    }

    public void actionEvent(){

        confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ChooseLoginWay();
                jframe.dispose();
            }
        });

    }

}

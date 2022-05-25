import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/** this class is fake database, to test login part
 * @author Songyun Yang
 * @version  1.0
 */
public class LoginWay3 extends MainFrame{

    private JLabel titleLabel;
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
        //set four panel, 1 panel is use to set title, other 3 is used to contain button
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();

        titleLabel=new JLabel("Please in put id document on the scanning desk");
        titleLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
        Panel1.add(titleLabel);

        confirm=new JButton("confirm");
        confirm.setSize(100,30);
        Panel3.add(confirm);

        back=new JButton("back");
        back.setSize(100,30);
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

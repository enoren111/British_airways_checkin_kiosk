import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/** this class is use id document and surname to login. After passenger input, passenger can choose the flight
 * @author Songyun Yang
 * @version  1.234
 */
public class LoginWay2 extends MainFrame{

    private JLabel titleLabel;
    private JButton confirm, back;
    //use to close itself
    private final JFrame jframe = this;
    private JTextField surname, idDocument;
    JPanel panel1 = new JPanel();

    public LoginWay2() {
        GridLayout gridLayout = new GridLayout(4, 1);
        panel1.setLayout(gridLayout);

        init1();
        init(panel1);
        actionEvent();
        this.setTitle("Id Document Login");
    }

    public void init1(){
        //set four panel, 1 panel is use to set title
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();
        JPanel Panel4 = new JPanel();

        titleLabel=new JLabel("Please input your surname and id");
        titleLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
        Panel1.add(titleLabel);

        confirm=new JButton("confirm");
        confirm.setSize(100,30);
        Panel4.add(confirm);

        back=new JButton("back");
        back.setSize(100,30);
        Panel4.add(back);

        surname = new JTextField();
        surname.setColumns(20);
        idDocument = new JTextField();
        idDocument.setColumns(20);
        surname.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        idDocument.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        Panel2.add(surname);
        Panel3.add(idDocument);

        Panel2.setBorder(BorderFactory.createTitledBorder("surname:"));
        Panel3.setBorder(BorderFactory.createTitledBorder("id document:"));

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
                Database database = new Database();
                Ticket[] tickets = database.checkIdDocument(surname.getText(),idDocument.getText());
                if(tickets==null){
                    idDocument.setText("");
                    idDocument.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Wrong"));
                }else{
                    new ChooseTicket(tickets);
                    jframe.dispose();
                }
            }
        });

    }

}
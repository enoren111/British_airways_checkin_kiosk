package boundary;

import control.botBar;
import control.topBar;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public void init(JPanel contentPl){
        //This part is used to define the information related to frame.
        topBar panel1=new topBar();
        botBar panel2=new botBar();

        add(panel1,BorderLayout.NORTH);
        panel1.setBackground(Color.cyan);
        panel1.setPreferredSize(new Dimension(1200,80));

        add(panel2,BorderLayout.SOUTH);

        panel2.setBackground(Color.cyan);
        panel2.setPreferredSize(new Dimension(1200,80));

        setSize(1200,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        add(contentPl,BorderLayout.CENTER);
    }

}

//1186*602

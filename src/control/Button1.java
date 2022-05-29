package control;

import javax.swing.*;
import java.awt.*;

public class Button1 extends JButton {

    public Button1(String content){
        super(content);
        Dimension buttonSize =  new Dimension(200,40);
        this.setPreferredSize(buttonSize);
        this.setFont(new Font("Arial Black", Font.BOLD, 15));
        this.setBackground(Color.WHITE);
        //this.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
    }
}

package control;

import javax.swing.*;
import java.awt.*;

public class Head1 extends JLabel {
    public Head1(String context){
        super(context);
        this.setFont(new Font("Arial Black", Font.BOLD, 35));
        //this.setBounds(250,40,800,70);
        this.setBorder(BorderFactory.createEmptyBorder(35, 5, 5, 5));

    }
}

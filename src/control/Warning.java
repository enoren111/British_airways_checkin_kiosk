package control;

import javax.swing.*;
import java.awt.*;

public class Warning extends JLabel {

    /**
     * This method is used to show that the information input is incorrect.
     */
    public Warning(){
        super("incorrect!");
        Font font1 = new Font("Arial Black", Font.BOLD, 25);
        this.setFont(font1);
        this.setBorder(BorderFactory.createLineBorder(Color.red));
        this.setVisible(false);
    }
}

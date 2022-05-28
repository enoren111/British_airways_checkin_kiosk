package boundary;

import javax.swing.*;
import java.awt.*;

public class TextFiled1 extends JTextField {
    public TextFiled1(){
        super(10);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setFont(new Font("Arial Black", Font.PLAIN, 35));
    }
}

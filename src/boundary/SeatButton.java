package boundary;

import boundary.FlightFrame;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class SeatButton extends JButton implements ActionListener{
    public String SeatState;
    //SeatState: whether the seat has been selected; -1:selected; 0:unselected; 1:your selection;
    public String SeatType;
    //SeatType: normal type(no more extra payment); special
    public String SeatId;
    public SeatButton(String url, int x, int y, String SeatState,String SeatType, String SeatId) {
        this.SeatType = SeatType;
        this.SeatState = SeatState;
        this.SeatId = SeatId;
        this.setText(SeatId);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        URL resource = FlightFrame.class.getResource(url);
        Icon icon = new ImageIcon(resource);
        setIcon(icon);
        if (SeatType.equals("special")){
            setBounds(x,y,75,50);
        }
        else {
            setBounds(x,y,50,50);
        }


        if (SeatState == "-1") {
            this.setBackground(Color.red);
        }
        else if(SeatState == "0"){
            this.setBackground(Color.white);
        }

        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.SeatState == "0"){
            this.setBackground(Color.green);
            this.SeatState = "1";
        }
        else if (this.SeatState == "1"){
            this.setBackground(Color.white);
            this.SeatState = "0";
        }
    }

    public void changeSeatState() {
        this.setBackground(Color.red);
    }

    public String getSeatType() {
    	return this.SeatType;
    }
    
    public String getSeatId() {
    	return this.SeatId;
    }
    
    public String getSeatState() {
    	return this.SeatState;
    }
}


package entity;

import boundary.FlightFrame;
import control.Seats;
import control.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class SeatButton extends JButton implements ActionListener{
    public String SeatState;
    //SeatState: whether the seat has been selected; -1:selected; 0:unselected; 1:your selection;
    public String SeatType;
    //SeatType: normal type(no more extra payment); special
    public String SeatId;
    public ArrayList<SeatButton> seats;
    public Ticket myTicket = new Ticket("","","","","","","","","","");



    Seats SeatsDatabase;

    public SeatButton(String url, int x, int y, String SeatState,String SeatType, String SeatId) {
        this.SeatType = SeatType;
        this.SeatState = SeatState;
        this.SeatId = SeatId;
        this.setText(SeatId);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        SeatsDatabase = new Seats(myTicket.getFlightNumber());
        URL resource = FlightFrame.class.getResource(url);
        Icon icon = new ImageIcon(resource);
        setIcon(icon);
        if (SeatType.equals("special")){
            setBounds(x,y,75,50);
        }
        else {
            setBounds(x,y,50,50);
        }


        if (SeatState.equals("-1") ) {
            this.setBackground(Color.red);
        }
        else if(SeatState.equals("0")){
            this.setBackground(Color.white);
        }

        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (SeatButton seatButton:seats) {
            if (seatButton.SeatState.equals("1") ) {
                seatButton.SeatState = "0";
                seatButton.changeSeatState("white");
            }
        }
        if(this.SeatState.equals("0") ){
            this.setBackground(Color.green);
            this.SeatState = "1";

        }
        else if (this.SeatState.equals("1")){
            this.setBackground(Color.white);
            this.SeatState = "0";
        }
    }

    public void changeSeatState(String color) {
        switch (color) {
            case "red" -> this.setBackground(Color.red);
            case "white" -> this.setBackground(Color.white);
            case "green" -> this.setBackground(Color.green);
        }

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

    public void setSeats(ArrayList<SeatButton> seats) {
        this.seats = seats;
    }

    public void setMyTicket(Ticket myTicket) {
        this.myTicket = myTicket;
    }
}


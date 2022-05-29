package entity;

import control.Seat;
import control.Ticket;

import java.util.ArrayList;
import java.util.HashSet;

public class SeatsInformation {
    public String pathname;
    public ArrayList<Seat> seatList;
    public SeatsInformation(String FlightNumber){
        this.pathname = "src/SeatDataBase/"+FlightNumber+"Seat.txt";
        seatList = new ArrayList<>();
    }

}

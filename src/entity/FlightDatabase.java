package entity;

import control.Flight;
import control.Ticket;

import java.util.HashSet;

public class FlightDatabase {
    protected String pathname = "flight.txt";
    public HashSet<Flight> flightHashSet=new HashSet<Flight>();
}
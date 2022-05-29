package entity;

import control.Ticket;

import java.util.HashSet;

public class CustomerInformation {
    protected String pathname = "src/DataBase/customer.txt";
    public HashSet<Ticket> ticketHashSet=new HashSet<Ticket>();
}

package control;

import entity.CustomerInformation;

import java.io.*;
import java.util.Objects;


/** this class is fake database, to test boundary.login part
 * @author Songyun Yang
 * @version  1.0
 */

public class Customer extends CustomerInformation {
    public Customer(){
        readFile();
    }

    /**
     * This method is used to read file.
     */
    public void readFile() {
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] ticketSequence;
                ticketSequence = line.split(",");
                Ticket ticket = new Ticket(ticketSequence[0],ticketSequence[1],
                        ticketSequence[2],ticketSequence[3],ticketSequence[4],ticketSequence[5],
                        ticketSequence[6],ticketSequence[7],ticketSequence[8],ticketSequence[9]);
                ticketHashSet.add(ticket);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to delete the ticket.
     * @param bookNumber
     */
    public void delete(String bookNumber){
        Ticket deleteTicket;
        deleteTicket = checkBookNumber(bookNumber);
        ticketHashSet.remove(deleteTicket);
    }

    /**
     * This method is used to add ticket.
     * @param ticket
     */
    public void add(Ticket ticket){
        ticketHashSet.add(ticket);
    }

    /**
     * This method is used to replace the ticket.
     * @param ticket
     */
    public void replace(Ticket ticket){
        delete(ticket.getBookNumber());
        add(ticket);
    }

    /**
     * This method is used to check the book number.
     * @param bookNumber
     * @return Ticker
     */
    public Ticket checkBookNumber(String bookNumber){
        for(Ticket ticket: ticketHashSet){
            if(Objects.equals(ticket.getBookNumber(), bookNumber)){
                return ticket;
            }
        }
        return null;
    }

    /**
     * This method is used to check the id document.
     * @param surname
     * @param idDocument
     * @return
     */
    public Ticket[] checkIdDocument(String surname, String idDocument){
        Ticket[] tickets=new Ticket[10];
        int i=0;
        for(Ticket ticket: ticketHashSet){
            if(Objects.equals(ticket.getIdDocument(), idDocument)){
                String ticketName = ticket.getName();
                String[] ticketNameset = ticketName.split(" ");
                String ticketsurName = ticketNameset[ticketNameset.length-1];
                if(surname.trim().equals(ticketsurName)){
                    tickets[i] = ticket;
                    i++;
                }
            }
        }
        if(tickets[0]==null){
            return null;
        }
        return tickets;
    }

    /**
     * This method is used to write the String into the database.
     * @return true if write is a success.
     */
    public boolean write(){
        //return a boolean to represent if the writing method is success. ture is succeed
        boolean writeSucceed=true;
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(pathname));
            for(Ticket ticket: ticketHashSet ){
                out.write(ticket.toString()+"\n");
                //System.out.println(ticket.toString());
            }
            out.close();
            //System.out.println("");
        } catch (IOException e) {
            writeSucceed=false;
            e.printStackTrace();
            //System.out.println("");
        }
        return writeSucceed;
    }

}

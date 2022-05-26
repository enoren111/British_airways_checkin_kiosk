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
                        ticketSequence[6],ticketSequence[7],ticketSequence[8]);
                ticketHashSet.add(ticket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(String bookNumber){
        Ticket deleteTicket;
        deleteTicket = checkBookNumber(bookNumber);
        ticketHashSet.remove(deleteTicket);
    }

    public void add(Ticket ticket){
        ticketHashSet.add(ticket);
    }
    public void replace(Ticket ticket){
        delete(ticket.getBookNumber());
        add(ticket);
    }


    public Ticket checkBookNumber(String bookNumber){
        for(Ticket ticket: ticketHashSet){
            if(Objects.equals(ticket.getBookNumber(), bookNumber)){
                return ticket;
            }
        }
        return null;
    }

    public Ticket[] checkIdDocument(String surname, String idDocument){
        Ticket[] tickets=new Ticket[10];
        int i=0;
        for(Ticket ticket: ticketHashSet){
            if(Objects.equals(ticket.getIdDocument(), idDocument)){
                if(surname.trim().equals(ticket.getSurname())){
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

    public boolean write(){
        boolean writeSucceed=true;
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(pathname));
            for(Ticket ticket: ticketHashSet ){
                out.write(ticket.toString()+"\n");
                System.out.println(ticket.toString());
            }
            out.close();
            System.out.println("");
        } catch (IOException e) {

            writeSucceed=false;
            e.printStackTrace();
            System.out.println("");
        }
        return writeSucceed;
    }

}

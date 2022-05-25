

import java.io.*;
import java.util.HashSet;

public class Write {
    //this method is used to write in the document, and return a value of weather write in the file
    boolean writeSucceed = true;
    public Write(HashSet<Ticket> information){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\86188\\Desktop\\Software Engineering\\Groupwork\\bin\\src\\test.txt"));
            for(Ticket ticket: information ){
                out.write(ticket.toString()+"\n");
            }
            out.close();
            System.out.println("");
        } catch (IOException e) {

            writeSucceed=false;
            e.printStackTrace();
        }
    }
}

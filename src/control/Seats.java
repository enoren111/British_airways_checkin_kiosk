package control;

import entity.CustomerInformation;
import entity.SeatsInformation;

import java.io.*;
import java.util.Objects;


/** this class is fake database, to test boundary.login part
 * @author Jianyu Hu
 * @version  1.0
 */

public class Seats extends SeatsInformation {
    public Seats(String pathname){
        super(pathname);
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
                String[] seatSequence;
                seatSequence = line.split(",");
                Seat seat = new Seat(seatSequence[0],seatSequence[1]);
                seatList.add(seat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to delete the seat
     * @param SeatNumber seat number
     */
    public void delete(String SeatNumber){
        Seat deleteSeat;
        deleteSeat = checkSeatNumber(SeatNumber);
        seatList.remove(deleteSeat);
    }

    /**
     * This method is used to add seat.
     * @param seat seat added
     */
    public void add(Seat seat){
        seatList.add(seat);
    }

    /**
     * This method is used to replace seat.
     * @param seat seat replaced
     */
    public void replace(Seat seat){
        delete(seat.getSeatNumber());
        add(seat);
    }

    /**
     * This method is used to set seat.
     * @param seatNumber seat number
     */
    public void setSeat(String seatNumber){
        Seat mySeat = new Seat("0","0");
        for (Seat seat: seatList) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                seat.setSeatState("-1");
                mySeat = seat;
            }
        }
        replace(mySeat);
        write();
    }

    /**
     * This method is used to check the seat state
     * @param SeatNumber seat number
     * @return seat
     */
    public Seat checkSeatNumber(String SeatNumber){
        for(Seat seat: seatList){
            if(Objects.equals(seat.getSeatNumber(), SeatNumber)){
                return seat;
            }
        }
        return null;
    }

    /**
     * This method is used to write the file.
     * @return
     */
    public boolean write(){
        boolean writeSucceed=true;
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(pathname));
            for(Seat seat: seatList ){
                out.write(seat.toString()+"\n");

            }
            out.close();

        } catch (IOException e) {

            writeSucceed=false;
            e.printStackTrace();

        }
        return writeSucceed;
    }
}

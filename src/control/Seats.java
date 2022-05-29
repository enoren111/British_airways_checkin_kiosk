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

    public void delete(String SeatNumber){
        Seat deleteSeat;
        deleteSeat = checkSeatNumber(SeatNumber);
        seatList.remove(deleteSeat);
    }

    public void add(Seat seat){
        seatList.add(seat);
    }

    public void replace(Seat seat){
        delete(seat.getSeatNumber());
        add(seat);
    }

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

    public Seat checkSeatNumber(String SeatNumber){
        for(Seat seat: seatList){
            if(Objects.equals(seat.getSeatNumber(), SeatNumber)){
                return seat;
            }
        }
        return null;
    }

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

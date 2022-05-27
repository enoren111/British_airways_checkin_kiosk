package control;

import entity.SeatInformation;

public class Seat extends SeatInformation implements SeatInfo{
    public Seat(String seatNumber, String seatType) {
        super(seatNumber, seatType);
    }

    @Override
    public void setSeatNumber(String seatNumber) {
        this.SeatNumber = seatNumber;
    }

    @Override
    public void setSeatState(String seatState) {
        this.SeatState = seatState;
    }

    @Override
    public String getSeatNumber() {
        return SeatNumber;
    }

    @Override
    public String getSeatState() {
        return SeatState;
    }
}

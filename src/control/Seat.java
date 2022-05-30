package control;

import entity.SeatInformation;

public class Seat extends SeatInformation implements SeatInfo{
    public Seat(String seatNumber, String seatType) {
        super(seatNumber, seatType);
    }

    /**
     * This method is used to set seat number.
     * @param seatNumber the seat number.
     */
    @Override
    public void setSeatNumber(String seatNumber) {
        this.SeatNumber = seatNumber;
    }

    /**
     * This method is used to see if the seat is selected.
     * @param seatState -1 is selected, 0 is not selected.
     */
    @Override
    public void setSeatState(String seatState) {
        this.SeatState = seatState;
    }

    /**
     * This method is used to get the seat number.
     * @return seat number.
     */
    @Override
    public String getSeatNumber() {
        return SeatNumber;
    }

    /**
     * This method is used to get seat state.
     * @return seat state
     */
    @Override
    public String getSeatState() {
        return SeatState;
    }

    /**
     * This method is toString() method.
     * @return toString()
     */
    @Override
    public String toString() {
        return SeatNumber + "," + SeatState;
    }
}

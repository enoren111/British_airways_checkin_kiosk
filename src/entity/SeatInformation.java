package entity;

public class SeatInformation {
    protected String SeatNumber;
    protected String SeatState; //0 unselected; -1 selected; 1 your selection

    public SeatInformation(String SeatNumber, String SeatState) {
        this.SeatNumber = SeatNumber;
        this.SeatState= SeatState;
    }
}

package entity;

public class FlightInformation {

    protected String flightNumber;
    protected String boardingGate;
    protected String boardingTime;
    protected String start;
    protected String destination;
    protected String enterprise;
    protected String startAcronym;
    protected String destinationAcronym;

    public FlightInformation(String flight, String boardingGate, String boardingTime, String start, String destination, String enterprise,
                             String startAcronym, String destinationAcronym){
        this.flightNumber = flight;
        this.boardingGate = boardingGate;
        this.boardingTime = boardingTime;
        this.start = start;
        this.destination = destination;
        this.enterprise = enterprise;
        this.startAcronym=startAcronym;
        this.destinationAcronym=destinationAcronym;

    }
}

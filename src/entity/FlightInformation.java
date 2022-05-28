package entity;

public class FlightInformation {

    protected String flightNumber;
    protected String boardingGate;
    protected String flightDate;
    protected String start;
    protected String startAcronym;
    protected String destination;
    protected String destinationAcronym;
    protected String boardingTime;
    protected String flyTime;
    protected String duration;

    public FlightInformation(String flightNumber,String boardingGate,String flightDate,String start, String startAcronym,
                             String destination,String destinationAcronym, String boardingTime,
                             String flyTime,String duration){
        this.flightNumber = flightNumber;
        this.boardingGate = boardingGate;
        this.flightDate=flightDate;
        this.start = start;
        this.startAcronym=startAcronym;
        this.destination = destination;
        this.destinationAcronym=destinationAcronym;
        this.boardingTime = boardingTime;
        this.flyTime=flyTime;
        this.duration=duration;
    }
}

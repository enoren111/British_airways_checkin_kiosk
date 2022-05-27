package entity;

public class FlightInformation {

    protected String flightNumber;
    protected String flightDate;
    protected String boardingGate;
    protected String start;
    protected String startAcronym;
    protected String destination;
    protected String destinationAcronym;
    protected String boardingTime;
    protected String flyTime;
    protected String duration;

    public FlightInformation(String flightNumber,String flightDate,String boardingGate, String start, String startAcronym,
                             String destination,  String destinationAcronym, String boardingTime,
                             String flyTime,String duration){
        this.flightNumber = flightNumber;
        this.flightDate=flightDate;
        this.boardingGate = boardingGate;
        this.start = start;
        this.startAcronym=startAcronym;
        this.destination = destination;
        this.destinationAcronym=destinationAcronym;
        this.boardingTime = boardingTime;
        this.flyTime=flyTime;
        this.duration=duration;
    }
}

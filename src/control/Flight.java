package control;
import entity.FlightInformation;
public class Flight extends FlightInformation implements FlightInfo{


    public Flight(String flightNumber, String flightDate, String boardingGate, String start, String startAcronym,
                  String destination, String destinationAcronym, String boardingTime, String flyTime, String duration) {
        super(flightNumber, flightDate, boardingGate, start, startAcronym, destination,
                destinationAcronym, boardingTime, flyTime, duration);
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public String getFightDate(){return flightDate;}

    public String getBoardingGate() {
        return boardingGate;
    }

    public String getStart() {
        return start;
    }

    public String getStartAcronym() {
        return startAcronym;
    }

    public String getDestination() {
        return destination;
    }

    public String getDestinationAcronym() {
        return destinationAcronym;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public String getFlyTime(){return flyTime;}

    public String getDuration(){return duration;}




    public String toString(){
        String flightInform;
        flightInform = flightNumber+","+flightDate+","+boardingGate+","+start+","+startAcronym+","+destination+","+
                ","+destinationAcronym+boardingTime+","+flyTime+","+duration;
        return flightInform;
    }


}
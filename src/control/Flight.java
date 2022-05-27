package control;
import entity.FlightInformation;
public class Flight extends FlightInformation implements FlightInfo{
    public Flight(String flight, String boardingGate, String boardingTime, String start, String destination, String enterprise,
                            String startAcronym, String destinationAcronym){
        super(flight,boardingGate,boardingTime,start,destination,enterprise,startAcronym,destinationAcronym);
    }


    public String getStartAcronym() {
        return startAcronym;
    }

    public String getDestinationAcronym() {
        return destinationAcronym;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getBoardingGate() {
        return boardingGate;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public String getStart() {
        return start;
    }

    public String getDestination() {
        return destination;
    }

    public String getEnterprise() {
        return enterprise;
    }


    public String toString(){
        String flightInform;
        flightInform = flightNumber+","+boardingGate+","+boardingTime+","+start+","+destination+","+
                enterprise+","+startAcronym+","+destinationAcronym;

        return flightInform;
    }


}
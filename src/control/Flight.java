package control;
import entity.FlightInformation;
public class Flight extends FlightInformation implements FlightInfo{


    public Flight(String flightNumber,  String boardingGate,String flightDate, String start, String startAcronym,
                  String destination, String destinationAcronym, String boardingTime, String flyTime, String duration) {
        super(flightNumber,  boardingGate,flightDate, start, startAcronym, destination,
                destinationAcronym, boardingTime, flyTime, duration);
    }

    /**
     * This method is used to get the flight number
     * @return flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * This method is used to get the flight date
     * @return flight date
     */

    public String getFightDate(){return flightDate;}

    /**
     * This method is used to get the boarding number.
     * @return boarding number
     */
    public String getBoardingGate() {
        return boardingGate;
    }

    /**
     * This method is used to get the departure city.
     * @return departure city
     */
    public String getStart() {
        return start;
    }

    /**
     * This method is used to get the departure city acronym.
     * @return departure city acronym
     */
    public String getStartAcronym() {
        return startAcronym;
    }

    /**
     * This method is used to get the destination city
     * @return destination city
     */
    public String getDestination() {
        return destination;
    }

    /**
     * This method is used to get the destination acronym
     * @return destination city acronym
     */
    public String getDestinationAcronym() {
        return destinationAcronym;
    }

    /**
     * This method is used to get the boarding time.
     * @return boarding time
     */
    public String getBoardingTime() {
        return boardingTime;
    }

    /**
     * This method is used to get the fly time
     * @return fly time
     */
    public String getFlyTime(){return flyTime;}

    /**
     * This method is used to get the duration time.
     * @return duration
     */
    public String getDuration(){return duration;}

    public String toString(){
        String flightInform;
        flightInform = flightNumber+","+flightDate+","+boardingGate+","+start+","+startAcronym+","+destination+","+
                destinationAcronym+","+boardingTime+","+flyTime+","+duration;
        return flightInform;
    }

}
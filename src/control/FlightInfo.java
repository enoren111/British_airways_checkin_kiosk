package control;

public interface FlightInfo {

    /**
     *This method can be used to get the number of flight.
     * @return The String of flight number.
     */
    String getFlightNumber();

    /**
     *This method can be used to get the number of boarding.
     * @return The String of boarding gate.
     */
    String getBoardingGate();

    /**
     *This method can be used to get the time of boarding.
     * @return The String of boarding time.
     */
    String getBoardingTime();

    /**
     *This method can be used to get the start city.
     * @return The String of city name.
     */
    String getStart();

    /**
     *This method can be used to get the destination city.
     * @return The String of destination name.
     */
    String getDestination();

    /**
     *This method can be used to get the acronym of starting city.
     * @return The String of starting city acronym.
     */
    String getStartAcronym();

    /**
     *This method can be used to get the acronym of destination city.
     * @return The String of destination city acronym.
     */
    String getDestinationAcronym();

}

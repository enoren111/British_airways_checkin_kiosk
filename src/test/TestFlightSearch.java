package test;
import control.Flight;
import control.FlightDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
public class TestFlightSearch {

    @Test
    public void test(){
        FlightDatabase flightDatabase = new FlightDatabase();
        Flight f1 = new Flight("JL727","17D","June 10th","Osaka","OSA",
                "Okinawa","OKA","16:00","16:40","7");
        Assertions.assertEquals(f1.toString(), flightDatabase.searchFlight("JL727").toString());
        Assertions.assertNull(flightDatabase.searchFlight("JAS727"));
        Assertions.assertNull(flightDatabase.searchFlight(""));


    }
}

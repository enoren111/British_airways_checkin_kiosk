package control;

import entity.Flightdatabase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class FlightDatabase extends Flightdatabase {

    public  FlightDatabase(){
        loadFlight();
    }

    /**
     * This method is used to read the flight information
     */
    public void loadFlight() {
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] flightSequence;
                flightSequence = line.split(",");
                Flight flight = new Flight(flightSequence[0],flightSequence[1],flightSequence[2],flightSequence[3],
                        flightSequence[4],flightSequence[5],flightSequence[6],flightSequence[7],flightSequence[8],
                        flightSequence[9]);
                flightHashSet.add(flight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to search fligh
     * @param flightNumber the flight number
     * @return the flight corresponds to the flight number
     */
    public Flight searchFlight(String flightNumber){
        for(Flight flight: flightHashSet){
            if(Objects.equals(flight.getFlightNumber(), flightNumber)){
                return flight;
            }
        }
        return null;
    }


}

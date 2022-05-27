package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class FlightDatabase extends entity.FlightDatabase {

    public  FlightDatabase(){
        loadFlight();
    }
    public void loadFlight() {
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] ticketSequence;
                ticketSequence = line.split(",");
                Flight flight = new Flight(ticketSequence[0],ticketSequence[1],ticketSequence[2],ticketSequence[3],
                        ticketSequence[4],ticketSequence[5],ticketSequence[6],ticketSequence[7]);
                flightHashSet.add(flight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Flight searchFlight(String flightNumber){
        for(Flight flight: flightHashSet){
            if(Objects.equals(flight.getFlightNumber(), flightNumber)){
                return flight;
            }
        }
        return null;
    }


}

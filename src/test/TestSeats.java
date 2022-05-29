package test;
import control.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSeats {
    Seat seat1 = new Seat("2","0");
    Seats seats = new Seats("AC153");
    Seat seat2 = new Seat("100","100");

    @Test
    public void testCheckSeatNumber(){
        Assertions.assertEquals(seat1.toString(), seats.checkSeatNumber("2").toString());
        Assertions.assertNull(seats.checkSeatNumber(""));
    }

    @Test
    public void testAddDelete(){
        seats.add(seat2);
        Assertions.assertEquals(seat2.toString(), seats.checkSeatNumber("100").toString());

        seats.delete("100");
        Assertions.assertNull(seats.checkSeatNumber("100"));

    }

}

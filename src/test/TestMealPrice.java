package test;
import control.Flight;
import control.FlightDatabase;
import control.mealprice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertEquals;
public class TestMealPrice {

    @Test
    public void test(){
        Assertions.assertEquals(10, new mealprice("Vegetarian").calculatePrice());
        Assertions.assertEquals(10, new mealprice("Standard and Halal").calculatePrice());
        Assertions.assertEquals(10, new mealprice("Halal").calculatePrice());
        Assertions.assertEquals(10, new mealprice("Standard and Vegetarian").calculatePrice());
        Assertions.assertEquals(50, new mealprice("Gourmet Menu").calculatePrice());
        Assertions.assertEquals(60, new mealprice("Standard and Gourmet Menu").calculatePrice());
        Assertions.assertEquals(20, new mealprice("Vegetarian and Halal").calculatePrice());
        Assertions.assertEquals(70, new mealprice("Vegetarian; Halal and Gourmet Menu").calculatePrice());
        Assertions.assertEquals(70, new mealprice("Standard; Vegetarian; Halal and Gourmet Menu").calculatePrice());
        Assertions.assertEquals(0, new mealprice("").calculatePrice());
        Assertions.assertEquals(60, new mealprice("Vegetarian and Gourmet Menu").calculatePrice());


    }
}
package test;
import control.Customer;
import control.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
public class TestCustomer {
    Customer customer = new Customer();
    Ticket ticket1 = new Ticket("Miles Davis","123980","AM337","A14023010"
            ,"30","Halal","1334500879223","a12344","3"
            ,"C3");
    Ticket ticket2 = new Ticket("Miles Davis","123980","BA872","E67234515"
            ,"none","none","1434500879224","b98912","1"
            ,"C6");

    @Test
    public void testCheckBookingNumber(){

        Assertions.assertEquals(ticket1.toString(), customer.checkBookNumber("A14023010").toString());
        Assertions.assertNull(customer.checkBookNumber("A140010"));
        Assertions.assertNull(customer.checkBookNumber(""));
    }

    @Test
    public void testCheckIdDocument(){

        Assertions.assertEquals(ticket1.toString(), customer.checkIdDocument("Davis","123980")[0].toString());
        Assertions.assertEquals(ticket2.toString(), customer.checkIdDocument("Davis","123980")[1].toString());
        Assertions.assertNull(customer.checkIdDocument("Miles Davis","123980"));
        Assertions.assertNull(customer.checkIdDocument("Miles","123980"));
        Assertions.assertNull(customer.checkIdDocument("Davis","12380"));
        Assertions.assertNull(customer.checkIdDocument("",""));
    }
}
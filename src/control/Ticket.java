package control;
import entity.TicketInformation;
public class Ticket extends TicketInformation implements TicketInfo {


    public Ticket(String name, String idDocument, String flightNumber, String bookNumber, String seatNumber,
                  String foodType, String creditCard, String creditCardPassword,
                  String carryOnBaggageNumber, String counterNumber) {
        super(name, idDocument, flightNumber, bookNumber, seatNumber, foodType,
                creditCard, creditCardPassword, carryOnBaggageNumber, counterNumber);
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getName() {
        return name;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getFoodType() {
        return foodType;
    }

    public String getCreditCard(){return creditCard;}

    public String getCreditCardPassword(){return creditCardPassword;}


    public String getCarryOnBaggageNumber() {
        return carryOnBaggageNumber;
    }

    public String getCounterNumber() {
        return counterNumber;
    }

    @Override
    public String toString() {
        return  name+","+ idDocument+","+flightNumber+","+bookNumber+","+seatNumber+","+ foodType+","+creditCard+","+creditCardPassword+","+carryOnBaggageNumber+","+counterNumber;

    }
}

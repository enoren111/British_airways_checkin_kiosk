package control;
import entity.TicketInformation;
public class Ticket extends TicketInformation implements TicketInfo {


    public Ticket(String name, String idDocument, String flightNumber, String bookNumber, String seatNumber,
                  String foodType, String creditCard, String creditCardPassword,
                  String carryOnBaggageNumber, String counterNumber) {
        super(name, idDocument, flightNumber, bookNumber, seatNumber, foodType,
                creditCard, creditCardPassword, carryOnBaggageNumber, counterNumber);
    }

    /**
     * This method is used to set seat number
     * @param seatNumber seat number
     */
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * This method is used to set food tyoe.
     * @param foodType food type
     */
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    /**
     * This method is used to get the passenger name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used to get id document
     * @return id document
     */
    public String getIdDocument() {
        return idDocument;
    }

    /**
     * This method is used to get the flight number.
     * @return flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * This method is used to get the book number.
     * @return book number
     */
    public String getBookNumber() {
        return bookNumber;
    }

    /**
     * This method is used to get seat number
     * @return seat number
     */
    public String getSeatNumber() {
        return seatNumber;
    }

    /**
     * This method is used to get food type
     * @return food type
     */
    public String getFoodType() {
        return foodType;
    }

    /**
     * This method is used to get credit card number.
     * @return credit card
     */
    public String getCreditCard(){return creditCard;}

    /**
     * This method us used to get credit card password.
     * @return credit card password.
     */
    public String getCreditCardPassword(){return creditCardPassword;}

    /**
     * This method is used to get the number of carry-on baggage.
     * @return baggage number
     */
    public String getCarryOnBaggageNumber() {
        return carryOnBaggageNumber;
    }

    /**
     * This is used to get the counter number
     * @return counter number
     */
    public String getCounterNumber() {
        return counterNumber;
    }

    /**
     * This is the toString method.
     * @return to String.
     */
    @Override
    public String toString() {
        return  name+","+ idDocument+","+flightNumber+","+bookNumber+","+seatNumber+","+ foodType+","+creditCard+","+creditCardPassword+","+carryOnBaggageNumber+","+counterNumber;

    }
}

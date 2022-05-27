package entity;

public class TicketInformation {
    protected String name;
    protected String idDocument;
    protected String flightNumber;
    protected String bookNumber;
    protected String seatNumber;
    protected String foodType;
    protected String creditCard;
    protected String creditCardPassword;
    protected String carryOnBaggageNumber;
    protected String counterNumber;
        public TicketInformation(String name, String idDocument, String flightNumber, String bookNumber,
                                 String seatNumber, String foodType, String creditCard, String creditCardPassword,
                                 String carryOnBaggageNumber, String counterNumber) {
            this.name = name;
            this.idDocument = idDocument;
            this.flightNumber = flightNumber;
            this.bookNumber = bookNumber;
            this.seatNumber = seatNumber;
            this.foodType = foodType;
            this.creditCard=creditCard;
            this.creditCardPassword=creditCardPassword;
            this.carryOnBaggageNumber = carryOnBaggageNumber;
            this.counterNumber = counterNumber;
        }
}

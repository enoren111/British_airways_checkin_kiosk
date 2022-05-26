package entity;

public class TicketInformation {
    protected String surname;
    protected String idDocument;
    protected String flightNumber;
    protected String bookNumber;
    protected String seatNumber;
    protected String foodType;
    protected String boardingPassNumber;
    protected String carryOnBaggageNumber;
    protected String counterNumber;
        public TicketInformation(String surname, String idDocument, String flightNumber, String bookNumber,
                                 String seatNumber, String foodType, String boardingPassNumber,
                                 String carryOnBaggageNumber, String counterNumber) {
            this.surname = surname;
            this.idDocument = idDocument;
            this.flightNumber = flightNumber;
            this.bookNumber = bookNumber;
            this.seatNumber = seatNumber;
            this.foodType = foodType;
            this.boardingPassNumber = boardingPassNumber;
            this.carryOnBaggageNumber = carryOnBaggageNumber;
            this.counterNumber = counterNumber;
        }
}

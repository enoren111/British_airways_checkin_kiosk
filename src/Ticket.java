public class Ticket {
    private String surname;
    private String idDocument;
    private String flightNumber;
    private String bookNumber;
    private String seatNumber;
    private String foodType;
    private String boardingPassNumber;
    private String carryOnBaggageNumber;
    private String counterNumber;

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getSurname() {
        return surname;
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

    public String getBoardingPassNumber() {
        return boardingPassNumber;
    }

    public String getCarryOnBaggageNumber() {
        return carryOnBaggageNumber;
    }

    public String getCounterNumber() {
        return counterNumber;
    }

    public Ticket(String surname, String idDocument, String flightNumber, String bookNumber,
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

    public String toString(){
        String ticketInform;
        ticketInform = surname+","+idDocument+","+flightNumber+","+bookNumber+","+seatNumber+","+
                foodType+","+boardingPassNumber+","+carryOnBaggageNumber+","+counterNumber;

        return ticketInform;
    }
}

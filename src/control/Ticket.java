package control;
import entity.TicketInformation;
public class Ticket extends TicketInformation implements TicketInfo {
    public Ticket(String surname, String idDocument, String flightNumber, String bookNumber,
                  String seatNumber, String foodType, String boardingPassNumber,
                  String carryOnBaggageNumber, String counterNumber) {
        super(surname, idDocument, flightNumber, bookNumber, seatNumber,
                foodType, boardingPassNumber, carryOnBaggageNumber, counterNumber);
    }

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
}

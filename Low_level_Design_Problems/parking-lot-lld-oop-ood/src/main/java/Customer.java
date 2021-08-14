import java.math.BigDecimal;

public class Customer {
    private final Double id;
    private final Vehicle vehicle;
    private final ParkingTicket ticket;
    private BigDecimal amountToPay;

    private static final BigDecimal ZERO_AMOUNT = new BigDecimal("0.0");

    public Customer(Vehicle vehicle, ParkingTicket ticket) {
        this.id = Math.random();
        this.vehicle = vehicle;
        this.ticket = ticket;
        this.amountToPay = ZERO_AMOUNT;
    }

    void doPayment() {
        System.out.println("Paying amount " + this.amountToPay);
    }
}
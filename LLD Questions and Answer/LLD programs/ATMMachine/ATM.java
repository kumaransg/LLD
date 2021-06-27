/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package ATMMachine;

public class ATM {

    private Double totalAmountRemaining;
    private Location location;
    private Long atmId;
    private Screen screen;
    private DepositSlot cashDepositSlot;
    private DepositSlot checkDepositSlot;
    private Printer printer;
    private CashDispenser cashDispenser;
    private CardReader cardReader;

    public ATM(Double totalAmountRemaining, Location location, Long atmId,
               Screen screen, DepositSlot cashDepositSlot, DepositSlot checkDepositSlot,
               Printer printer, CashDispenser cashDispenser, CardReader cardReader) {
        this.totalAmountRemaining = totalAmountRemaining;
        this.location = location;
        this.atmId = atmId;
        this.screen = screen;
        this.cashDepositSlot = cashDepositSlot;
        this.checkDepositSlot = checkDepositSlot;
        this.printer = printer;
        this.cashDispenser = cashDispenser;
        this.cardReader = cardReader;
    }

    public Double debit(Double amount) {
        totalAmountRemaining -= amount;
        return amount;
    }


    // Put all getters and setters

}

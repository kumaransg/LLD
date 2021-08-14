/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package ATMMachine;

public class CashDispenser {

    private ATM atm;

    private Double dispenseCash(Double amount) {
        System.out.println("Dispensing cash - " + amount);
        return atm.debit(amount);
    }
}

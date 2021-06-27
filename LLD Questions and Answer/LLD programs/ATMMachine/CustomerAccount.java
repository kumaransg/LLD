/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package ATMMachine;

public class CustomerAccount {
    private String accountNumber;
    private String routingNumber;
    private Double currentBalance;

    public CustomerAccount(String accountNumber, String routingNumber) {
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void depositAmount(Double depositAmount) {
        this.currentBalance += depositAmount;
    }

    public void withdrawAmount(Double withdrawAmount) {

        if (currentBalance < withdrawAmount) {
            throw new InSufficientFundException("Account balance is low than entered amount!");
        }

        this.currentBalance -= withdrawAmount;
    }

}

/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package ATMMachine.Transaction;

public class CashDepositTransaction extends Transaction {

    Double amount;
    String accountId;

    public CashDepositTransaction(Double amount, String accountId) {
        this.amount = amount;
        this.accountId = accountId;
        super.transactionType = TransactionType.CASH_DEPOSIT;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}

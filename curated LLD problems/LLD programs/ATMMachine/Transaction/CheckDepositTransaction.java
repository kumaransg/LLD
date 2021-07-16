/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package ATMMachine.Transaction;

import ATMMachine.Check;

public class CheckDepositTransaction extends Transaction {

    Check check;

    public CheckDepositTransaction(Check check) {
        this.check = check;
        super.transactionType = TransactionType.CHECK_DEPOSIT;
    }
}

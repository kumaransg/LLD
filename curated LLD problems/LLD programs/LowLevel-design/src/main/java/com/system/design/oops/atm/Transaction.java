package com.system.design.oops.atm;

import java.util.Date;

public abstract class Transaction {
    private int transactionId;
    private Date creationTime;
    private TransactionStatus status;
    public boolean makeTransation(){ return true;}
}

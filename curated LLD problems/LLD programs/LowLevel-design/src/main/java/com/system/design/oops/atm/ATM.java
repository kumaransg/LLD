package com.system.design.oops.atm;

public class ATM {
    private int atmID;
    private Address location;

    private CashDispenser cashDispenser;
    private Keypad keypad;
    private Screen screen;
    private Printer printer;
    private CheckDeposit checkDeposit;
    private CashDeposit cashDeposit;

    public boolean authenticateUser(){ return true;}
    public boolean makeTransaction(Customer customer, Transaction transaction){ return true;}
}

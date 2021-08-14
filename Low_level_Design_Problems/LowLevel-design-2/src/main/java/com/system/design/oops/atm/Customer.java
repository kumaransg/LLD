package com.system.design.oops.atm;

public class Customer {
    private String name;
    private String email;
    private String phone;
    private Address address;
    private CustomerStatus status;

    private Card card;
    private Account account;

    public boolean makeTransaction(Transaction transaction){ return true;}
    public Address getBillingAddress(){ return null;}
}

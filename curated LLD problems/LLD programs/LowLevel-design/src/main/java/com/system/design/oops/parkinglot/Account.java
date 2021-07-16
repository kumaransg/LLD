package com.system.design.oops.parkinglot;

public abstract class Account {
    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;

    public boolean resetPassword(){ return true;}
}

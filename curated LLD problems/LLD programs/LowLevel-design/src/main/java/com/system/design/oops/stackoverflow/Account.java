package com.system.design.oops.stackoverflow;

public class Account {
    private String id;
    private String password;
    private AccountStatus status;
    private String name;
    private Address address;
    private String email;
    private String phone;
    private int reputation;

    public boolean resetPassword(){
        return true;
    }
}

package com.system.design.oops.amazon;

import java.util.List;

public class Account {
    private String userName;
    private String password;
    private AccountStatus status;
    private String name;
    private Address shippingAddress;
    private String email;
    private String phone;

    private List<CreditCard> creditCards;
    private List<ElectronicBankTransfer> bankAccounts;

    public boolean addProduct(Product product){ return true;}
    public boolean addProductReview(ProductReview review){ return true;}
    public boolean resetPassword(){ return true;}
}

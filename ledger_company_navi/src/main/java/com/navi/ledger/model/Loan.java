package com.navi.ledger.model;

import java.util.List;

public class Loan {

    private double principal;
    private double interestAmount;
    private double amount;
    private int emiMonths;
    private int emiAmount;
    private List<Payment> paymentList;

    public Loan(double principal, double interestAmount, double amount, int emiMonths, int emiAmount, List<Payment> paymentList) {
        this.principal = principal;
        this.interestAmount = interestAmount;
        this.amount = amount;
        this.emiMonths = emiMonths;
        this.emiAmount = emiAmount;
        this.paymentList = paymentList;
    }

    public double getAmount() {
        return amount;
    }

    public int getEmiAmount() {
        return emiAmount;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}

package com.navi.ledger.loan;

import com.navi.ledger.model.Loan;
import com.navi.ledger.model.Payment;
import com.navi.ledger.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanProcessor {

    private String bankName;
    private String customerName;
    private double principalAmount;
    private int years;
    private double interestRate;

    LoanProcessor(String bankName, String customerName, double principalAmount, int years, double interestRate) {
        this.bankName = bankName;
        this.customerName = customerName;
        this.principalAmount = principalAmount;
        this.years = years;
        this.interestRate = interestRate;
    }

    public void processLoan() {
        List<Payment> paymentList = initializePayment();
        int totalMonths = Util.getMonthsFromYears(years);
        double interestAmount = Util.calculateInterestAmount(principalAmount, years, interestRate);
        double totalAmount = principalAmount + interestAmount;
        int emiAmount = Util.calculateEMIAmount(totalAmount, totalMonths);
        Loan loan = new Loan(principalAmount, interestAmount, totalAmount,totalMonths, emiAmount, paymentList);
        updateLoanMap(loan);
    }

    private List<Payment> initializePayment() {
        List<Payment> paymentList = new ArrayList<>();
        Payment payment = new Payment(0, Util.getMonthsFromYears(years));
        paymentList.add(payment);
        return paymentList;
    }

    private void updateLoanMap(Loan loan) {
        if(Util.getUserLoanMapping().containsKey(customerName)) {
            Map<String, Loan> existingMap = Util.getUserLoanMapping().get(customerName);
            existingMap.put(bankName, loan);
            Util.getUserLoanMapping().put(customerName, existingMap);
        } else {
            Map<String,Loan> map = new HashMap<>();
            map.put(bankName,loan);
            Util.getUserLoanMapping().put(customerName,map);
        }
    }

}

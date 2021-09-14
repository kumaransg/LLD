package com.navi.ledger.util;

import com.navi.ledger.model.Loan;

import java.util.HashMap;
import java.util.Map;

public class Util {

    static Map<String, Map<String, Loan>> customerLoanMap = new HashMap<>();

    public static int getMonthsFromYears(int year) {
        return year*12;
    }

    public static double calculateInterestAmount(double principalAmount, int years, double interestRate) {
        return (principalAmount * years * interestRate)/100;
    }

    public static int calculateEMIAmount(double principalAmount, int months) {
        return (int) Math.ceil(principalAmount/months);
    }

    public static Map<String,Map<String,Loan>> getUserLoanMapping() {
        return customerLoanMap;
    }



}

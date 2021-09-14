package com.navi.ledger.balance;

import com.navi.ledger.model.Payment;

import java.util.List;

public class BalanceProcessor {

    String bankName;
    String customerName;
    int emiMonthCount;

    public BalanceProcessor(String bankName, String customerName, int emiMonthCount) {
        this.bankName = bankName;
        this.customerName = customerName;
        this.emiMonthCount = emiMonthCount;
    }

    public void displayBalance(List<Payment> paymentList, int afterEMICount, String bankName, String customerName) {
        Payment payment = paymentList.get(afterEMICount);
        System.out.println(bankName + " " + customerName + " " + (int)(payment.getAmountPaid()) + " " + payment.getEmiCountLeft());
    }

    private Payment calculatePayment(Payment prevPayment, int emiAmount, double totalAmount) {
        double totalAmountPaid = prevPayment.getAmountPaid() + emiAmount;
        if(totalAmountPaid > totalAmount) {
            totalAmountPaid = totalAmount;
        }
        Payment payment = new Payment(totalAmountPaid,prevPayment.getEmiCountLeft()-1);
        return payment;
    }

    public List<Payment> updatePayments(List<Payment> paymentList, int afterEmiCount, int emiAmount, double totalAmount) {
        for(int i = paymentList.size(); i <= afterEmiCount;i++) {
            Payment prevPayment = paymentList.get(i-1);
            paymentList.add(calculatePayment(prevPayment, emiAmount, totalAmount));
        }
        return paymentList;
    }
}

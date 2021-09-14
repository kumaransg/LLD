package com.navi.ledger.payment;

import com.navi.ledger.model.Payment;

import java.util.List;

public class PaymentProcessor {

    String bankName;
    String customerName;
    double lumSumAmount;
    int afterEmiCount;

     PaymentProcessor(String bankName, String customerName, double lumSumAmount, int afterEmiCount) {
         this.bankName = bankName;
         this.customerName = customerName;
         this.lumSumAmount = lumSumAmount;
         this.afterEmiCount = afterEmiCount;
    }

    public List<Payment> updatePayments(List<Payment> paymentList, double lumSumAmount, int afterEmiCount, int emiAmount, double totalAmount) {
        if(afterEmiCount == 0) {
            paymentList = processFirstPayment(paymentList,totalAmount,lumSumAmount, emiAmount);
        } else {
            for (int i = paymentList.size(); i < afterEmiCount; i++) {
                Payment prevPayment = paymentList.get(i - 1);
                paymentList.add(processPayment(prevPayment, emiAmount, totalAmount));
            }
            if (paymentList.size() == afterEmiCount) {
                Payment prevPayment = paymentList.get(paymentList.size() - 1);
                paymentList.add(processFinalPayment(prevPayment, emiAmount, lumSumAmount, totalAmount));
            }
        }
        return paymentList;
    }

    public List<Payment> processFirstPayment(List<Payment> paymentList, double totalAmount, double lumSumAmount, int emiAmount ) {
        double amountLeft = totalAmount - lumSumAmount;
        int emiCountLeft = (int) Math.ceil(amountLeft/emiAmount);
        Payment payment = new Payment(lumSumAmount,emiCountLeft);
        paymentList.remove(paymentList.get(0));
        paymentList.add(payment);
        return paymentList;
    }

    public Payment processFinalPayment(Payment prevPayment, int emiAmount, double lumSumAmount, double totalAmount) {
        double emiAmountPaid = prevPayment.getAmountPaid() + emiAmount + lumSumAmount;
        if(emiAmountPaid > totalAmount) {
            emiAmountPaid = totalAmount;
        }
        double amountLeft = totalAmount - emiAmountPaid;
        int emiCountLeft = (int) Math.ceil(amountLeft / emiAmount);
        Payment payment = new Payment(emiAmountPaid, emiCountLeft);
        return payment;
    }

    public Payment processPayment(Payment prevPayment, int emiAmount, double totalAmount) {
        double amount = prevPayment.getAmountPaid() + emiAmount;
        if(amount > totalAmount) {
            amount = totalAmount;
        }
        Payment payment = new Payment(amount, prevPayment.getEmiCountLeft() - 1);
        return payment;
    }




}

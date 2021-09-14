package com.navi.ledger.payment;

import com.navi.ledger.command.CommandExecution;
import com.navi.ledger.model.Loan;
import com.navi.ledger.model.Payment;
import com.navi.ledger.util.Util;

import java.util.List;
import java.util.Map;

public class PaymentManager implements CommandExecution {

    String[] inputSplit;
    PaymentProcessor paymentProcessor;

    public PaymentManager(String[] inputSplit) {
        this.inputSplit = inputSplit;
    }

    public void execute() {
        String bankName = inputSplit[1];
        String customerName = inputSplit[2];
        double lumSumAmount = Double.valueOf(inputSplit[3]);
        int afterEmiCount = Integer.valueOf(inputSplit[4]);
        paymentProcessor = new PaymentProcessor(bankName, customerName, lumSumAmount, afterEmiCount);
        executePayment(bankName, customerName, lumSumAmount, afterEmiCount);
    }

    private void executePayment(String bankName, String customerName, double lumSumAmount, int afterEmiCount) {
        Map<String, Loan> bankLoanMap = Util.getUserLoanMapping().get(customerName);
        Loan customerLoan = bankLoanMap.get(bankName);
        List<Payment> paymentList = customerLoan.getPaymentList();
        paymentList = paymentProcessor.updatePayments(paymentList, lumSumAmount, afterEmiCount, customerLoan.getEmiAmount(), customerLoan.getAmount());
        customerLoan.setPaymentList(paymentList);
        bankLoanMap.put(bankName, customerLoan);
        Util.getUserLoanMapping().get(customerName).put(bankName, customerLoan);
    }

}

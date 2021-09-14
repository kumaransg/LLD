package com.navi.ledger.balance;

import com.navi.ledger.command.CommandExecution;
import com.navi.ledger.model.Loan;
import com.navi.ledger.model.Payment;
import com.navi.ledger.util.Util;

import java.util.List;
import java.util.Map;

public class BalanceManager implements CommandExecution {

    String[] inputSplit;
    BalanceProcessor balanceProcessor;

    public BalanceManager(String[] inputSplit) {
        this.inputSplit = inputSplit;
    }

    public void execute() {
        String bankName = inputSplit[1];
        String customerName = inputSplit[2];
        int emiMonthCount = Integer.valueOf(inputSplit[3]);
        balanceProcessor = new BalanceProcessor(bankName, customerName, emiMonthCount);
        processDisplayBalance(bankName, customerName, emiMonthCount);
    }

    private void processDisplayBalance(String bankName, String customerName, int emiMonthCount) {
        Map<String, Loan> bankLoanMap = Util.getUserLoanMapping().get(customerName);
        Loan customerLoan = bankLoanMap.get(bankName);
        List<Payment> paymentList = customerLoan.getPaymentList();
        paymentList = balanceProcessor.updatePayments(paymentList, emiMonthCount, customerLoan.getEmiAmount(), customerLoan.getAmount());
        customerLoan.setPaymentList(paymentList);
        bankLoanMap.put(bankName, customerLoan);
        Util.getUserLoanMapping().get(customerName).put(bankName, customerLoan);
        balanceProcessor.displayBalance(paymentList, emiMonthCount, bankName, customerName);
    }

}

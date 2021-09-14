package com.navi.ledger.loan;

import com.navi.ledger.command.CommandExecution;

public class LoanManager implements CommandExecution {
    String[] inputSplit;
    LoanProcessor loanProcessor;

    public LoanManager(String[] inputSplit) {
        this.inputSplit = inputSplit;
    }

    public void execute() {
        String bankName = inputSplit[1];
        String customerName = inputSplit[2];
        double amount = Double.valueOf(inputSplit[3]);
        int years = Integer.valueOf(inputSplit[4]);
        double interestRate = Double.valueOf(inputSplit[5]);
        executeLoan(bankName, customerName, amount, years, interestRate);
    }

    private void executeLoan(String bankName, String customerName, double amount, int years, double interestRate) {
        loanProcessor = new LoanProcessor(bankName, customerName, amount, years, interestRate);
        loanProcessor.processLoan();
    }


}

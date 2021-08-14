package io.abhishek.machinecoding.splitwise.service;

import io.abhishek.machinecoding.splitwise.expense.EqualExpense;
import io.abhishek.machinecoding.splitwise.expense.ExactExpense;
import io.abhishek.machinecoding.splitwise.expense.Expense;
import io.abhishek.machinecoding.splitwise.expense.ExpenseMetaData;
import io.abhishek.machinecoding.splitwise.expense.ExpenseType;
import io.abhishek.machinecoding.splitwise.expense.PercentExpense;
import io.abhishek.machinecoding.splitwise.model.PercentSplit;
import io.abhishek.machinecoding.splitwise.model.Split;
import io.abhishek.machinecoding.splitwise.model.User;
import java.util.List;

public class ExpenseService {

  public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits,
      ExpenseMetaData expenseMetaData) {
   switch (expenseType) {
     case EXACT:
       return new ExactExpense(amount, paidBy, splits, expenseMetaData);

     case EQUAL:
       int totalSplits = splits.size();
       double splitAmount = (double) Math.round(amount  / totalSplits);
       for(Split split : splits) {
         split.setAmount(splitAmount);
       }
       return new EqualExpense(amount, paidBy, splits, expenseMetaData);

     case PERCENT:
       for(Split split : splits) {
         PercentSplit percentSplit = (PercentSplit) split;
         split.setAmount((amount * percentSplit.getPercent()) / 100.0);
       }
       return new PercentExpense(amount, paidBy, splits, expenseMetaData);

     default:
       return null;
   }
  }
}

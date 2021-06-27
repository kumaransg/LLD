package io.abhishek.machinecoding.splitwise.expense;

import io.abhishek.machinecoding.splitwise.model.ExactSplit;
import io.abhishek.machinecoding.splitwise.model.Split;
import io.abhishek.machinecoding.splitwise.model.User;
import java.util.List;

public class ExactExpense extends Expense{
  public ExactExpense(double amount, User paidBy, List<Split> splits,
      ExpenseMetaData expenseMetaData) {
    super(amount, paidBy, splits, expenseMetaData);
  }

  @Override
  public boolean validate() {
    for(Split split : getSplits()) {
      if (!(split instanceof ExactSplit)) {
        return false;
      }
    }

    double totalAmount = getAmount();
    double sumSplitAmount = 0;
    for(Split split : getSplits()) {
      ExactSplit exactSplit = (ExactSplit) split;
      sumSplitAmount += exactSplit.getAmount();
    }

    if (totalAmount != sumSplitAmount) {
      return false;
    }

    return true;
  }
}

package io.abhishek.machinecoding.splitwise.expense;

import io.abhishek.machinecoding.splitwise.model.PercentSplit;
import io.abhishek.machinecoding.splitwise.model.Split;
import io.abhishek.machinecoding.splitwise.model.User;
import java.util.List;

public class PercentExpense extends Expense {
  public PercentExpense(double amount, User paidBy, List<Split> splits,
      ExpenseMetaData expenseMetaData) {
    super(amount, paidBy, splits, expenseMetaData);
  }

  @Override
  public boolean validate() {
    for(Split split : getSplits()) {
      if (!(split instanceof PercentSplit)) {
        return false;
      }
    }

    double totalPercent = 0;
    for(Split split : getSplits()) {
      PercentSplit percentSplit = (PercentSplit) split;
      totalPercent += percentSplit.getPercent();
    }
    if (totalPercent == 100)
      return true;
    return false;
  }
}

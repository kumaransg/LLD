package service;

import model.Expense.EqualExpense;
import model.Expense.ExactExpense;
import model.Expense.Expense;
import model.Expense.PercentExpense;
import model.ExpenseType;
import model.Split.PercentSplit;
import model.Split.Split;
import model.User;

import java.util.List;

public class ExpenseService {
    public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits){
        switch (expenseType){
            case EXACT:
                return new ExactExpense(amount, paidBy, splits);
            case EQUAL:
                int totalSplitSize= splits.size();
                double splitAmount= (double) Math.round(amount*100/totalSplitSize)/100.0;
                for(Split split: splits){
                    split.setAmount(splitAmount);
                }

                splits.get(0).setAmount(splitAmount + amount - splitAmount*totalSplitSize);
                return new EqualExpense(amount, paidBy, splits);
            case PERCENT:
                for(Split split: splits){
                    PercentSplit percentSplit= (PercentSplit) split;
                    split.setAmount((amount * percentSplit.getPercent())/100.0);
                }
                return new PercentExpense(amount, paidBy, splits);
        }

        return null;
    }
}

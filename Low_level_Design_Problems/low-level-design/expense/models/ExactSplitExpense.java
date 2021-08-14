package expense.models;

import java.util.*;

public class ExactSplitExpense extends Expense{

    @Override
    public boolean validateExpense() {
        return (expenseSplits.stream().reduce(Double::sum).get() == expenseAmount);
    }
}

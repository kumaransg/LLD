package expense.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PercentSplitExpense extends Expense{

    @Override
    public boolean validateExpense() {
        return (expenseSplits.stream().reduce(Double::sum).get() == 100);
    }
}

package splitwise.model.expense;

import splitwise.constants.ExpenseTypeConstants;
import splitwise.pojo.ExpenseDivisionVariables;

import java.util.Map;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public abstract class ExpenseType {
    private final ExpenseTypeConstants expenseType;

    public ExpenseType(ExpenseTypeConstants expenseType) {
        this.expenseType = expenseType;
    }

    public ExpenseTypeConstants getExpenseType() {
        return expenseType;
    }

    public abstract Map<String, Double> getOweAmount(ExpenseDivisionVariables expenseDivisionVariables);
}

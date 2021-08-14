package splitwise.model.expense;

import splitwise.constants.ExpenseTypeConstants;
import splitwise.pojo.ExpenseDivisionVariables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public class PercentExpenseType extends ExpenseType {
    public PercentExpenseType() {
        super(ExpenseTypeConstants.PERCENT);
    }

    @Override
    public Map<String, Double> getOweAmount(ExpenseDivisionVariables expenseDivisionVariables) {
        List<String> userIds = expenseDivisionVariables.getUserIds();
        Map<String, Double> oweMap = new HashMap<>();
        for (int i = 0; i < userIds.size(); i++) {
            oweMap.put(userIds.get(i), expenseDivisionVariables.getTotalAmount() * (expenseDivisionVariables.getDivisions().get(i) / 100));
        }
        return oweMap;
    }
}

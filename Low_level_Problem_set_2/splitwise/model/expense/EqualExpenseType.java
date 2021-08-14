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
public class EqualExpenseType extends ExpenseType {
    public EqualExpenseType() {
        super(ExpenseTypeConstants.EQUAL);
    }

    @Override
    public Map<String, Double> getOweAmount(ExpenseDivisionVariables expenseDivisionVariables) {
        List<String> userIds = expenseDivisionVariables.getUserIds();
        Map<String, Double> oweMap = new HashMap<>();
        for (String userId : userIds) {
            oweMap.put(userId, expenseDivisionVariables.getTotalAmount() / userIds.size());
        }
        return oweMap;
    }
}

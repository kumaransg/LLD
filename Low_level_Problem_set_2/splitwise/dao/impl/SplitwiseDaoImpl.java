package splitwise.dao.impl;

import splitwise.dao.SplitwiseDao;
import splitwise.model.expense.Expense;
import splitwise.model.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public class SplitwiseDaoImpl implements SplitwiseDao {
    private final Map<String, List<Expense>> userToExpensesMap;
    private final Map<String, Map<String, Double>> balanceSheet;

    private final List<User> users;

    private static SplitwiseDao splitwiseDao;

    private SplitwiseDaoImpl() {
        userToExpensesMap = new HashMap<>();
        balanceSheet = new HashMap<>();
        users = new ArrayList<>();
    }

    public static SplitwiseDao getInstance() {
        if (splitwiseDao == null) {
            splitwiseDao = new SplitwiseDaoImpl();
        }
        return splitwiseDao;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void addExpense(Expense expense) {
        userToExpensesMap.getOrDefault(expense.getPayerUserId(), new ArrayList<>()).add(expense);
        addOweAmount(expense.getPayerUserId(), expense.getOwerToAmountMap());
        System.out.println(balanceSheet);
    }


    private void addOweAmount(String payerUserId, Map<String, Double> oweAmountMap) {
        for (String userId : oweAmountMap.keySet()) {
            Map<String, Double> balanceForPaidBy = balanceSheet.getOrDefault(payerUserId, new HashMap<>());
            if (!balanceForPaidBy.containsKey(userId)) {
                balanceForPaidBy.put(userId, (double) 0);
            }
            balanceForPaidBy.put(userId, balanceForPaidBy.get(userId) + oweAmountMap.get(userId));
            balanceSheet.put(payerUserId, balanceForPaidBy);

            Map<String, Double> balanceForPaidTo = balanceSheet.getOrDefault(userId, new HashMap<>());
            if (!balanceForPaidTo.containsKey(payerUserId)) {
                balanceForPaidTo.put(payerUserId, (double) 0);
            }
            balanceForPaidTo.put(payerUserId, balanceForPaidTo.get(payerUserId) - oweAmountMap.get(userId));
            balanceSheet.put(userId, balanceForPaidTo);
        }
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public Map<String, Map<String, Double>> getBalanceSheet() {
        return balanceSheet;
    }
}

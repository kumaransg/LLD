package splitwise.service;

import splitwise.dao.SplitwiseDao;
import splitwise.model.expense.Expense;
import splitwise.model.expense.ExpenseType;
import splitwise.model.user.User;
import splitwise.pojo.ExpenseDivisionVariables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public class SplitwiseService {
    private final SplitwiseDao splitwiseDao;

    public SplitwiseService(SplitwiseDao splitwiseDao) {
        this.splitwiseDao = splitwiseDao;
    }

    public void addExpense(String payerUserId, Double amount, List<String> owersList, ExpenseType expenseType) {
        ExpenseDivisionVariables expenseDivisionVariables = new ExpenseDivisionVariables(owersList, amount);
        Map<String, Double> owerAmountMap = expenseType.getOweAmount(expenseDivisionVariables);
        Expense expense = new Expense(payerUserId, amount, expenseType, owerAmountMap);
        processExpense(expense);
    }

    public void addExpense(String payerUserId, Double amount, List<String> owersList, ExpenseType expenseType, List<Double> expenseDivisonVars) {
        ExpenseDivisionVariables expenseDivisionVariables = new ExpenseDivisionVariables(owersList, amount, expenseDivisonVars);
        Map<String, Double> owerAmountMap = expenseType.getOweAmount(expenseDivisionVariables);
        Expense expense = new Expense(payerUserId, amount, expenseType, owerAmountMap);
        processExpense(expense);
    }

    public void addUser(String userId, String name, String email, String mobileNumber) {
        User user = new User(userId, name, email, mobileNumber);
        splitwiseDao.addUser(user);
    }

    private void processExpense(Expense expense) {
        splitwiseDao.addExpense(expense);
    }

    public void showBalances() {
        Map<String, Map<String, Double>> balanceSheet = splitwiseDao.getBalanceSheet();
        for (String userId : balanceSheet.keySet()) {
            Map<String, Double> balances = balanceSheet.get(userId);
            for (String userId2 : balances.keySet()) {
                if (balances.get(userId2) > 0) {
                    printBalanceInfo(userId, userId2, balances.get(userId2));
                }
            }
        }
        System.out.println();
    }

    public void showBalances(String userId) {
        Map<String, Double> balanceSheet = splitwiseDao.getBalanceSheet().getOrDefault(userId, new HashMap<>());

        for (String userId2 : balanceSheet.keySet()) {
            if (balanceSheet.get(userId2) != 0) {
                printBalanceInfo(userId, userId2, balanceSheet.get(userId2));
            }
        }
        System.out.println();
    }

    private void printBalanceInfo(String userId1, String userId2, Double amount) {
        if (amount > 0) {
            System.out.println("User " + userId2 + " owes to " + userId1 + " : " + amount);
        } else {
            System.out.println("User " + userId1 + " owes to " + userId2 + " : " + Math.abs(amount));
        }
    }
}

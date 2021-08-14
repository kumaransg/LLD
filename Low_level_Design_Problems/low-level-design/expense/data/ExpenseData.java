package expense.data;

import expense.models.Expense;
import expense.models.User;

import java.util.*;

public class ExpenseData {

    private static ExpenseData expenseData;
    private Map<User, Map<User, Double>> userExpenses;

    private ExpenseData(){
        userExpenses = new HashMap<>();
    }

    public static ExpenseData getInstance(){

        if(expenseData == null){
            expenseData = new ExpenseData();
        }
        return expenseData;
    }

    public void insertExpense(Expense expense){

        Iterator<User> userItr = expense.getUsersInvolved().iterator();
        Iterator<Double> splitItr = expense.getExpenseSplits().iterator();

        while(userItr.hasNext() && splitItr.hasNext()){
            User currUser = userItr.next();
            Map<User, Double> userEntry = userExpenses.getOrDefault(currUser, new HashMap<>());
            userEntry.put(expense.getPaidBy(), userEntry.getOrDefault(expense.getPaidBy(), 0.0) + splitItr.next());
            userExpenses.put(currUser, userEntry);
        }
    }

    public Optional<Map<User, Double>> getBalance(User user){
        return Optional.ofNullable(userExpenses.get(user));
    }

    public Map<User, Map<User, Double>> getAllBalances(){
        return userExpenses;
    }

    public void printExpenses(){
        userExpenses.forEach((user, balances) -> System.out.println(user.getUserId()+" -> "+balances));
    }
}

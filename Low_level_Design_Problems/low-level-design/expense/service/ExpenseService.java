package expense.service;

import expense.data.ExpenseData;
import expense.data.UserData;
import expense.models.Expense;
import expense.models.ExpenseBuilder;
import expense.models.User;

import java.util.Map;
import java.util.Optional;

public class ExpenseService {

    private ExpenseData expenseData = ExpenseData.getInstance();
    private UserData userData = UserData.getInstance();

    public void addExpense(String[] expenseInput){
        ExpenseBuilder expenseBuilder = new ExpenseBuilder();
        Expense expense = expenseBuilder.expenseBuilder(expenseInput);
        expenseData.insertExpense(expense);
    }

    public void getBalance(String userId){

        Optional<Map<User, Double>> balancesOpt = expenseData.getBalance(userData.getUser(userId).get());
        if(balancesOpt.isPresent()){
            balancesOpt.get().forEach((user, balance) -> System.out.println(userId + " owes " + user.getUserId() + ": "+ balance));
        }
        else{
            System.out.println("No balances");
        }
    }

    public void getBalance(){

        Map<User, Map<User, Double>> expenseMap = expenseData.getAllBalances();
        expenseMap.forEach((user, balances) -> {
            for(Map.Entry<User, Double> entry : balances.entrySet()){
                System.out.println(user.getUserId() + " owes " + entry.getKey().getUserId() + ": " + entry.getValue());
            }
        });
    }
}

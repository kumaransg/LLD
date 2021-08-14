package expense.models;

import java.util.List;
import java.util.Map;

public abstract class Expense {

    User paidBy;
    List<User> usersInvolved;
    double expenseAmount;
    List<Double> expenseSplits;

    public abstract boolean validateExpense();


    public void setUsersInvolved(List<User> usersInvolved) {
        this.usersInvolved = usersInvolved;
    }

    public List<User> getUsersInvolved() {
        return usersInvolved;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public List<Double> getExpenseSplits() {
        return expenseSplits;
    }

    public void setExpenseSplits(List<Double> expenseSplits) {
        this.expenseSplits = expenseSplits;
    }
}

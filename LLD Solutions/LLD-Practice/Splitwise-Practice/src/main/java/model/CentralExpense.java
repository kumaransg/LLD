package model;

import exception.UserNotFoundException;

import java.util.Map;

public class CentralExpense {
    private Map<User,Float> expenseDB;

    public void addExpense(User user, Float expense){
        if(expenseDB.containsKey(user)){
            Float prevExpense= expenseDB.get(user);
            expenseDB.put(user,prevExpense+expense);
        }else {
            expenseDB.put(user, expense);
        }
    }

    public Float getExpensePerUser(User user) throws UserNotFoundException {
        if(!expenseDB.containsKey(user))
            throw new UserNotFoundException(user);
        return expenseDB.get(user);
    }
}

package expense.models;

import expense.data.UserData;

import java.util.ArrayList;
import java.util.List;

public class ExpenseBuilder {

    public Expense expenseBuilder(String[] expenseInput){

        int expenseTypeIndex = 4 + Integer.parseInt(expenseInput[3]);
        switch (expenseInput[expenseTypeIndex]){
            case "EQUAL": return equalExpenseBuilder(expenseInput, expenseInput[expenseTypeIndex]);
            case "EXACT": return exactExpenseBuilder(expenseInput, expenseInput[expenseTypeIndex]);
            case "PERCENT": return percentExpenseBuilder(expenseInput, expenseInput[expenseTypeIndex]);
            default: System.out.println("Invalid expense type");
                     return null;
        }
    }

    private Expense equalExpenseBuilder(String[] expenseInput, String expenseType){
        Expense expense = new EqualSplitExpense();
        setExpenseMeta(expense, expenseInput, expenseType);

        return  expense;
    }


    private Expense exactExpenseBuilder(String[] expenseInput, String expenseType){
        Expense expense = new ExactSplitExpense();
        setExpenseMeta(expense, expenseInput, expenseType);

        return  expense;
    }


    private Expense percentExpenseBuilder(String[] expenseInput, String expenseType){
        Expense expense = new PercentSplitExpense();
        setExpenseMeta(expense, expenseInput, expenseType);

        return  expense;
    }

    private void setExpenseMeta(Expense expense, String[] expenseInput, String expenseType){

        UserData userData = UserData.getInstance();
        User paidByUser = userData.getUser(expenseInput[1]).orElseThrow(() -> new RuntimeException("User Not found"));

        List<User> usersInvolved = new ArrayList<>();
        List<Double> expenseSplit = new ArrayList<>();

        int noOfUsersInvolved = Integer.parseInt(expenseInput[3]);
        int expenseSplitStart = 4 + noOfUsersInvolved;

        for(int i=4;i<noOfUsersInvolved+4;i++){
            usersInvolved.add(userData.getUser(expenseInput[i]).get());
        }

        double totalExpense = Double.parseDouble(expenseInput[2]);
        if(expenseType.equals("EQUAL")){
            for(int i=0;i<noOfUsersInvolved;i++){
                expenseSplit.add(totalExpense/noOfUsersInvolved);
            }
        }
        else if(expenseType.equals("EXACT")){
            expenseSplitStart++;
            while(expenseSplitStart < expenseInput.length){
                expenseSplit.add(Double.parseDouble(expenseInput[expenseSplitStart++]));
            }
        }
        else{
            expenseSplitStart++;
            while(expenseSplitStart < expenseInput.length){
                expenseSplit.add(Double.parseDouble(expenseInput[expenseSplitStart++])*totalExpense/100);
            }
        }

        //Add entry for lender
        usersInvolved.add(paidByUser);
        expenseSplit.add(-1*totalExpense);

        expense.setExpenseSplits(expenseSplit);
        expense.setExpenseAmount(Double.parseDouble(expenseInput[2]));
        expense.setPaidBy(paidByUser);
        expense.setUsersInvolved(usersInvolved);
    }
}

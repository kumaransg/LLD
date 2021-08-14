package service;

public class ExpenseFactory {
    public static ExpenseStrategy getInstance(String expenseType){
        if(expenseType.equals("EXACT")){
            return Exact.getInstance();
        }
        else if(expenseType.equals("EQUALS")){
            return Equal.getInstance();
        }

        return null;
    }
}

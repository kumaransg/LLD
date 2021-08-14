package service;

import utils.SplitTypeGetter;

import java.util.List;

public class SplitHandler {
    public static void splitHandler(List<String> input){
        String expenseType = SplitTypeGetter.get(input);

        ExpenseStrategy expenseStrategy = ExpenseFactory.getInstance(expenseType);
        expenseStrategy.split(input);
    }
}

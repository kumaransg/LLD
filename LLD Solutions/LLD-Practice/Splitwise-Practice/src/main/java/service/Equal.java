package service;

import model.CentralExpense;
import model.User;

import java.util.List;

public class Equal implements ExpenseStrategy{
    private CentralExpense centralExpense;
    private static Equal INSTANCE=null;

    private Equal(){}

    public static Equal getInstance(){
        if(INSTANCE != null)
            return  INSTANCE;
        INSTANCE= new Equal();

        return INSTANCE;
    }

    public void split(List<String> input) {

    }
}

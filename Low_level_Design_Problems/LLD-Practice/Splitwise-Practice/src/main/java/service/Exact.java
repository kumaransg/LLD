package service;

import model.CentralExpense;

import java.util.List;

public class Exact implements ExpenseStrategy {
    private CentralExpense centralExpense;
    private static Exact INSTANCE=null;

    private Exact(){}

    public static Exact getInstance(){
        if(INSTANCE != null)
            return INSTANCE;
        INSTANCE= new Exact();

        return INSTANCE;
    }

    public void split(List<String> input) {

    }
}

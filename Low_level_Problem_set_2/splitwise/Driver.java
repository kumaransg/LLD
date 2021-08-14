package splitwise;

import splitwise.dao.impl.SplitwiseDaoImpl;
import splitwise.model.expense.EqualExpenseType;
import splitwise.model.expense.ExactExpenseType;
import splitwise.model.expense.PercentExpenseType;
import splitwise.service.SplitwiseService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public class Driver {
    public static void main(String[] args) {
        SplitwiseService splitwiseService = new SplitwiseService(SplitwiseDaoImpl.getInstance());
        splitwiseService.addUser("u1", "Priyam", "priyam@hike.in", "+918320063250");
        splitwiseService.addUser("u2", "Priyam2", "priyam2@hike.in", "+928320063250");
        splitwiseService.addUser("u3", "Priyam3", "priyam3@hike.in", "+938320063250");
        splitwiseService.addUser("u4", "Priyam4", "priyam4@hike.in", "+948320063250");

        splitwiseService.showBalances();
        splitwiseService.showBalances("u1");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("u1");
        arrayList.add("u2");
        arrayList.add("u3");
        arrayList.add("u4");
        splitwiseService.addExpense("u1", (double) 1000, arrayList, new EqualExpenseType());
        splitwiseService.showBalances("u4");
        splitwiseService.showBalances("u1");
        arrayList.clear();
        arrayList.add("u2");
        arrayList.add("u3");
        List<Double> expenseVar = new ArrayList<>();
        expenseVar.add((double) 370);
        expenseVar.add((double) 880);
        splitwiseService.addExpense("u1", (double) 1250, arrayList, new ExactExpenseType(), expenseVar);
        splitwiseService.showBalances();
        arrayList.clear();
        arrayList.add("u1");
        arrayList.add("u2");
        arrayList.add("u3");
        arrayList.add("u4");
        expenseVar.clear();
        expenseVar.add((double) 40);
        expenseVar.add((double) 20);
        expenseVar.add((double) 20);
        expenseVar.add((double) 20);
        splitwiseService.addExpense("u4", (double) 1200, arrayList, new PercentExpenseType(), expenseVar);
        splitwiseService.showBalances("u1");
        splitwiseService.showBalances();
    }
}

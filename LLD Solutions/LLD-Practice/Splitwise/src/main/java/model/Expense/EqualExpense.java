package model.Expense;

import model.Split.EqualSplit;
import model.Split.Split;
import model.User;

import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if( !(split instanceof EqualSplit))
                return false;
        }

        return true;
    }
}

package model.Expense;

import model.Split.ExactSplit;
import model.Split.Split;
import model.User;

import java.util.List;

public class ExactExpense extends Expense{
    public ExactExpense(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if( !(split instanceof ExactSplit))
                return false;
        }

        double totalAmount=0;
        double sumSplitAmount=0;

        for(Split split: getSplits()){
            ExactSplit exactSplit= (ExactSplit) split;
            sumSplitAmount+= exactSplit.getAmount();
        }

        if(totalAmount != sumSplitAmount)
            return false;

        return true;
    }
}

package model.Expense;

import model.Split.PercentSplit;
import model.Split.Split;
import model.User;

import java.util.List;

public class PercentExpense extends Expense{
    public PercentExpense(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if( !(split instanceof PercentSplit))
                return false;
        }

        double totalPercent=0;
        double sumSplitPercent=0;

        for(Split split: getSplits()){
            PercentSplit percentSplit= (PercentSplit) split;
            sumSplitPercent+= percentSplit.getPercent();
        }

        if(totalPercent != sumSplitPercent)
            return false;

        return true;
    }
}

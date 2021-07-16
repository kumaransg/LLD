package model.Expense;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.Split.Split;
import model.User;

import java.util.List;

@Setter
@Getter
public abstract class Expense {
    private String id;
    private double amount;
    private User paidBy;
    private List<Split> splits;

    public Expense(double amount, User paidBy, List<Split> splits) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

    public abstract boolean validate();
}

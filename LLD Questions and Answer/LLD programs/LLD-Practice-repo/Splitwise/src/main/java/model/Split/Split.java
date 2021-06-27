package model.Split;

import lombok.Getter;
import lombok.Setter;
import model.User;

@Getter
@Setter
public abstract class Split {
    private User user;
    protected double amount;

    public Split(User user) {
        this.user = user;
    }
}

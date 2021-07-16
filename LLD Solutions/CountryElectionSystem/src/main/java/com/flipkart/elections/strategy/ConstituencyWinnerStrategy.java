package com.flipkart.elections.strategy;

import java.util.List;
import com.flipkart.elections.model.Party;

public interface ConstituencyWinnerStrategy {
    public Party getWinner(List<Party> parties);
}

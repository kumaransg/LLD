package com.flipkart.elections.strategy;

import com.flipkart.elections.model.Party;
import java.util.List;

public class LargetPartyByVotesWins implements ConstituencyWinnerStrategy {

    public Party getWinner(List<Party> parties){
        int maxVotes =Integer.MIN_VALUE;
        Party winner = null;
        boolean tie = false;
        for(Party p : parties){
            if(p.getVotes() > maxVotes){
                tie = false;
                winner = p;
                maxVotes = p.getVotes();
            }
            //tie problem
            else if (p.getVotes() == maxVotes){
                tie = true;
            }
        }
        if(tie) {
            System.out.println("Tie");
            return null;
        }
        return winner;

    }
}

package com.flipkart.elections.model;

import com.flipkart.elections.exceptions.CandidateDuplicateEntryException;
import com.flipkart.elections.strategy.HighestVotePercentageWins;
import com.flipkart.elections.strategy.PMSelectionStrategy;

import java.util.HashSet;
import java.util.Set;

public class Party implements Comparable<Party> {
    private String partyName;
    private Integer votes;
    private PMSelectionStrategy pmSelectionStrategy;

    public Party(String partyName) {
        this.partyName = partyName;
        this.votes = 0;
        this.pmSelectionStrategy = new HighestVotePercentageWins();
    }
    public String getPartyName() {
        return this.partyName;
    }
    public void addVotes(Integer votes){
        this.votes += votes;
    }
    public Integer getVotes() {
        return this.votes;
    }

    @Override
    public int compareTo(Party o) {
        return this.partyName.compareTo(o.getPartyName());
    }
}

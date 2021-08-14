package com.flipkart.elections.model;

import com.flipkart.elections.exceptions.PartyAlreadyExistsException;
import com.flipkart.elections.strategy.ConstituencyWinnerStrategy;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Constituency {
    private String constituencyName;
    private ConstituencyWinnerStrategy constituencyWinnerStrategy;
    private Set<Party> parties = new HashSet<>();
    private Integer votes = 0;

    public Constituency(String constituencyName , ConstituencyWinnerStrategy constituencyWinnerStrategy) {
        this.constituencyName = constituencyName;
        this.constituencyWinnerStrategy = constituencyWinnerStrategy;
    }

    public void setConstituencyWinnerStrategy(ConstituencyWinnerStrategy constituencyWinnerStrategy) {
        this.constituencyWinnerStrategy = constituencyWinnerStrategy;
    }

    public Integer getVotes(){
        return this.votes;
    }

    public Set<Party> getAllParties(){
        return this.parties;
    }
    public String getName() {
        return this.constituencyName;
    }
    //TODO : check if null
    public Party getWinnerParty(List<Party> parties) {
        return constituencyWinnerStrategy.getWinner(parties);
    }

    public void displayPartyWiseShare() {
        System.out.println(constituencyName + " :");
        parties.forEach(party -> {
            System.out.println(party.getPartyName() + " : " + party.getVotes()*100/(double) this.votes + "%");
        });

    }

    public boolean addParty(Party party) throws PartyAlreadyExistsException {
        if(parties.contains(party)){
            throw new PartyAlreadyExistsException(party.getPartyName());
        }
        return parties.add(party);
    }

    public boolean isExists(Party party){
        return parties.contains(party);
    }
    public void addVotes( Integer votes){
        this.votes += votes;
    }
}

package com.flipkart.elections.service;

import com.flipkart.elections.exceptions.CandidateDuplicateEntryException;
import com.flipkart.elections.exceptions.ConstituencyExistsException;
import com.flipkart.elections.exceptions.NotExistsException;
import com.flipkart.elections.exceptions.PartyAlreadyExistsException;
import com.flipkart.elections.model.Candidate;
import com.flipkart.elections.model.Constituency;
import com.flipkart.elections.model.ConstituencyParty;
import com.flipkart.elections.model.Country;
import com.flipkart.elections.model.Party;

import java.util.List;
import java.util.Map;

public class CountryElectionSystemImpl implements CountryElectionSystem{
    Country country;
    CountryElectionSystemImpl(Country country){
        this.country = country;
    }

    @Override
    public void addCandidate(Candidate candidate, Party party, Constituency constituency) throws CandidateDuplicateEntryException , NotExistsException{
        if(country.isExists(party , constituency)){
            this.country.addCandidate(candidate ,party , constituency);
        }
        else{
            throw new NotExistsException("party and constituency : "+ party.getPartyName() +" "+ constituency.getName());
        }
    }
    @Override
    public void addConstituency(Constituency constituency) throws ConstituencyExistsException {
        this.country.addConstituency(constituency);
    }

    @Override
    public void addParty(Party party)  throws PartyAlreadyExistsException {
        this.country.addParty(party);
    }

    @Override
    public void addPartyGivenConstituency(Party party, Constituency constituency) throws PartyAlreadyExistsException, NotExistsException {
        this.country.addParty(party, constituency);
    }

    @Override
    public void displayPartyWiseVoteShare(Constituency constituency) {
        this.country.displayPartyWiseShare(constituency);
    }

    @Override
    public void displayPartyWiseVoteShare(Country country) {
        this.country.displayPartyWiseVoteShare();
    }

    @Override
    public Double displayVoteShareInConstituency(Candidate candidate) {
        return this.country.getVotesShare(candidate);
    }

    @Override
    public Candidate findPM() {
        return country.findPM();
    }

    @Override
    public Party getWinnerParty(Constituency constituency) {
        return this.country.getWinner(constituency);
    }

    @Override
    public Candidate getMaxVotesInConstituency(Constituency constituency) {
        return null;
    }
}

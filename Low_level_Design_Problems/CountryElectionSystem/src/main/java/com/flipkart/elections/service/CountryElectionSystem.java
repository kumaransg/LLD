package com.flipkart.elections.service;

import com.flipkart.elections.exceptions.CandidateDuplicateEntryException;
import com.flipkart.elections.exceptions.ConstituencyExistsException;
import com.flipkart.elections.exceptions.NotExistsException;
import com.flipkart.elections.exceptions.PartyAlreadyExistsException;
import com.flipkart.elections.model.Candidate;
import com.flipkart.elections.model.Constituency;
import com.flipkart.elections.model.Country;
import com.flipkart.elections.model.Party;

import java.util.*;

public interface CountryElectionSystem {
    void addCandidate(Candidate candidate , Party party , Constituency constituency) throws CandidateDuplicateEntryException ,  NotExistsException;
    void addConstituency(Constituency constituency) throws ConstituencyExistsException;
    void addParty(Party party) throws PartyAlreadyExistsException;
    void addPartyGivenConstituency(Party party , Constituency constituency) throws PartyAlreadyExistsException, NotExistsException;
    void displayPartyWiseVoteShare(Constituency constituency);
    void displayPartyWiseVoteShare(Country country);
    Double displayVoteShareInConstituency(Candidate candidate);


    Candidate findPM();
    Party getWinnerParty(Constituency constituency);

    //Utility functions
    Candidate getMaxVotesInConstituency(Constituency constituency);
}

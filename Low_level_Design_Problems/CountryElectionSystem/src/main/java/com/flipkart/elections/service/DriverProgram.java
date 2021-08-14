package com.flipkart.elections.service;

import com.flipkart.elections.exceptions.CandidateDuplicateEntryException;
import com.flipkart.elections.exceptions.ConstituencyExistsException;
import com.flipkart.elections.exceptions.NotExistsException;
import com.flipkart.elections.exceptions.PartyAlreadyExistsException;
import com.flipkart.elections.model.*;
import com.flipkart.elections.strategy.LargetPartyByVotesWins;

public class DriverProgram {
    public static void main(String args[]){
        Country country = new Country("India");
        Constituency c1 = new Constituency("C1",new LargetPartyByVotesWins());
        Constituency c2 = new Constituency("C2" , new LargetPartyByVotesWins());
        Party party1 = new Party("BJP");
        Party party2 = new Party("Congress");
        Candidate candidate1 = new Candidate("Amit"  , 550);
        Candidate candidate2 = new Candidate("Rahul", 450);
        Candidate candidate3 = new Candidate("Sonia", 400);
        System.out.println(candidate1);
        System.out.println(candidate2);
        CountryElectionSystem  countryElectionSystem = new CountryElectionSystemImpl(country);
        try {
            countryElectionSystem.addConstituency(c1);
            countryElectionSystem.addConstituency(c2);
            countryElectionSystem.addParty(party1);
            countryElectionSystem.addParty(party2);
            countryElectionSystem.addPartyGivenConstituency(party1 , c1);
            countryElectionSystem.addPartyGivenConstituency(party2 , c1);
            countryElectionSystem.addPartyGivenConstituency(party2 , c2);
            countryElectionSystem.addCandidate(candidate2 , party2 , c1);
            countryElectionSystem.addCandidate(candidate3, party2 , c2);
            countryElectionSystem.addCandidate(candidate1, party1 , c1);
            System.out.println(country.getAllCandidates().toString());

        } catch (CandidateDuplicateEntryException e) {
            e.printStackTrace();
        } catch (NotExistsException e) {
            e.printStackTrace();
        } catch (ConstituencyExistsException e) {
            e.printStackTrace();
        } catch (PartyAlreadyExistsException e) {
            e.printStackTrace();
        }
        countryElectionSystem.displayPartyWiseVoteShare(c1);
        countryElectionSystem.displayPartyWiseVoteShare(c2);
        countryElectionSystem.displayPartyWiseVoteShare(country);
        Party party = countryElectionSystem.getWinnerParty(c1);
        System.out.println("Winner party in " + c1.getName() + " is "+ (party != null ? party.getPartyName() : "Tie"));
        party = countryElectionSystem.getWinnerParty(c2);
        System.out.println("Winner party in " + c2.getName() + " is " + (party != null ? party.getPartyName() : "Tie"));
//        countryElectionSystem.displayVoteShareInConstituency(candidate2);
//        countryElectionSystem.displayVoteShareInConstituency(candidate3);
        System.out.println( "vote share for " + candidate2.getName() + " is " +countryElectionSystem.displayVoteShareInConstituency(candidate2));
//        System.out.println( "vote share for " + candidate2.getName() + " is " +countryElectionSystem.displayVoteShareInConstituency(candidate2));
//        System.out.println( "vote share for " + candidate3.getName() + " is " +countryElectionSystem.displayVoteShareInConstituency(candidate3));
//        System.out.println( "vote share for " + candidate4.getName() + " is " +countryElectionSystem.displayVoteShareInConstituency(candidate4));
        System.out.println( "PM  is ");
        Candidate candidate = countryElectionSystem.findPM();
        if(candidate != null) {
            System.out.println(candidate.getName());
        }

    }
}

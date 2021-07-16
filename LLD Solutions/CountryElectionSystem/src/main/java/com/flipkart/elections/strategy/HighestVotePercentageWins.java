package com.flipkart.elections.strategy;

import com.flipkart.elections.model.Candidate;
import com.flipkart.elections.model.Constituency;
import com.flipkart.elections.model.Country;
import com.flipkart.elections.model.Party;

import java.util.*;

public class HighestVotePercentageWins implements PMSelectionStrategy {
    @Override
    public Candidate getPMCandidate(Country country , Party party) {
        double maxVotePercentage = 0.0;
        Candidate PM = null;
        for(Candidate candidate : country.getCandidates(party.getPartyName())){
            Double voteScore = candidate.getVotes()*100 /(double) party.getVotes();
            if(voteScore > maxVotePercentage){
                maxVotePercentage = voteScore;
                PM = candidate;

            }
        }
        return PM;
    }

    @Override
    public Candidate getPMCandidate(Country country) {
        Map<Party , Integer> map = new HashMap<>();
        for(Constituency constituency : country.getConstituencies()){
            if(country.getWinner(constituency) != null){
                if(map.containsKey(country.getWinner(constituency)))
                    map.merge(country.getWinner(constituency) ,
                            1,
                            Integer::sum);
                else
                    map.put(country.getWinner(constituency) , 1);
            }
        }
        List<Map.Entry<Party,Integer>> entries = new ArrayList<>(map.entrySet());
        Optional<Map.Entry<Party, Integer>> party = entries.stream().max(new Comparator<Map.Entry<Party, Integer>>() {
            @Override
            public int compare(Map.Entry<Party, Integer> o1, Map.Entry<Party, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        if(party.isPresent()){
            return getPMCandidate(country , party.get().getKey() );
        }
        //case of tie among parties
        //get candidate cote percentage across country
        Map<Candidate , Double> candidateVotePercentMap = new HashMap<>();
        country.getAllCandidates().forEach(candidate -> {
            candidateVotePercentMap.put(candidate, candidate.getVotes()*100 / (double) country.getVotes());
        });

        List<Map.Entry<Candidate, Double>> candidateEntries = new ArrayList<>(candidateVotePercentMap.entrySet());
        Optional<Map.Entry<Candidate, Double>> candidate = candidateEntries.stream().max(new Comparator<Map.Entry<Candidate, Double>>() {
            @Override
            public int compare(Map.Entry<Candidate, Double> o1, Map.Entry<Candidate, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        if(candidate.isPresent()){
            return candidate.get().getKey();
        }
        System.out.println("CAN't DECIDE PM");
        return null;

    }
}

package com.flipkart.elections.model;

import com.flipkart.elections.exceptions.CandidateDuplicateEntryException;
import com.flipkart.elections.exceptions.ConstituencyExistsException;
import com.flipkart.elections.exceptions.NotExistsException;
import com.flipkart.elections.exceptions.PartyAlreadyExistsException;
import com.flipkart.elections.strategy.HighestVotePercentageWins;
import com.flipkart.elections.strategy.PMSelectionStrategy;

import java.util.*;

public class Country {
    String name;
    Integer votes;
    PMSelectionStrategy pmSelectionStrategy;
    Map<String , Constituency> constituencies = new HashMap<>();
    Map<String , Party> parties = new HashMap<>();
    Map<String , ConstituencyParty > constituencyParties = new HashMap<>();
    Map<String , String> candidateCPMap = new HashMap<>();

    public Country(String name) {
        this.name = name;
        this.votes = 0;
        this.pmSelectionStrategy = new HighestVotePercentageWins();
    }

    public String getName() {
        return name;
    }

    public PMSelectionStrategy getPmSelectionStrategy() {
        return pmSelectionStrategy;
    }

    public void setPmSelectionStrategy(PMSelectionStrategy pmSelectionStrategy) {
        this.pmSelectionStrategy = pmSelectionStrategy;
    }

    public Map<String, ConstituencyParty> getConstituencyParties() {
        return constituencyParties;
    }

    public List<Constituency> getConstituencies() {
      List<Constituency> list = new ArrayList<>();
      for(Map.Entry<String, Constituency> cp : constituencies.entrySet()){
        list.add(cp.getValue());
      }
      return list;
    }

    public void setConstituencies(Map<String, Constituency> constituencies) {
        this.constituencies = constituencies;
    }

    public Map<String, Party> getParties() {
        return parties;
    }

    public void setParties(Map<String, Party> parties) {
        this.parties = parties;
    }

    public void setConstituencyParties(Map<String, ConstituencyParty> constituencyParties) {
        this.constituencyParties = constituencyParties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public boolean addConstituency(Constituency constituency) throws ConstituencyExistsException{
        if(this.constituencies.containsKey(constituency.getName())){
            throw new ConstituencyExistsException("Constituency exists" + constituency.getName());
        }
        constituencies.put(constituency.getName() , constituency);
        return true;
    }
    public void addParty(Party party) throws PartyAlreadyExistsException {
      if(parties.containsKey(party.getPartyName())){
        throw new PartyAlreadyExistsException(party.getPartyName() + "exists");
      }
      parties.put(party.getPartyName() , party);
    }
    public boolean addParty(Party party, Constituency constituency) throws PartyAlreadyExistsException, NotExistsException {
        if(!constituencies.containsKey(constituency.getName())){
            throw new NotExistsException("Constituency");
        }
        String cName =constituency.getName() ;
        String p_Name = party.getPartyName();
        String key = cName+"_"+p_Name;
        //TODO : what if party doesnt exist?
        if(constituencyParties.containsKey(key)){
            throw new PartyAlreadyExistsException(party.getPartyName());
        }
        else{
            ConstituencyParty cp = new ConstituencyParty(cName , p_Name);
            constituencyParties.put(key , cp);
        }
        return true;
    }

    public boolean isExists(Party party, Constituency constituency) {
        return constituencyParties.containsKey(constituency.getName() +"_"+party.getPartyName());
    }

    public void addCandidate(Candidate candidate, Party party, Constituency constituency) throws CandidateDuplicateEntryException {
        String key = constituency.getName() +"_"+party.getPartyName();
        ConstituencyParty cp = constituencyParties.get(key);
        if(cp != null){
            cp.addCandidate(candidate);
        }
        candidateCPMap.put(candidate.getName() ,key);
        party.addVotes(candidate.getVotes());
        constituency.addVotes(candidate.getVotes());
        this.votes += candidate.getVotes();
    }

    public void displayPartyWiseVoteShare() {
        //in country
        for(Map.Entry<String ,Party> entry  : parties.entrySet()){
            System.out.println(entry.getKey() + " : "+ entry.getValue().getVotes()*100/(double) this.votes + "%");
        }

    }

    public Double getVotesShare(Candidate candidate) {
        if(candidateCPMap.containsKey(candidate.getName())){
          String key = candidateCPMap.get(candidate.getName());
          String consName = key.split("_")[0];
          Integer totalConstituencyVotes = constituencies.get(key.split("_")[0]).getVotes();
          return candidate.getVotes()* 100 /(double)totalConstituencyVotes;
        }
        return 0.0;
    }
    public Candidate findPM(){
        return pmSelectionStrategy.getPMCandidate(this);
    }

    public List<Candidate> getAllCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        for(Map.Entry<String ,ConstituencyParty> entry : constituencyParties.entrySet()){
            for(Candidate candidate : entry.getValue().getCandidates()){
                candidates.add(candidate);
            }
        }
        return candidates;
    }

    public void displayPartyWiseShare(Constituency constituency) {
        String key = constituency.getName();
        Integer constituencyTotalVotes  = constituency.getVotes();
        System.out.println(key +" -->");
        for(Map.Entry<String , ConstituencyParty> cp : constituencyParties.entrySet()){

            if(cp.getKey().startsWith(key)){
                System.out.println( cp.getValue().getPartyName() + " :" + cp.getValue().getVotes()*100/ constituencyTotalVotes +"%");
            }

        }
    }

    public Party getWinner(Constituency constituency) {
        Set<String> partyIds = new HashSet<>();
        for(Map.Entry<String , ConstituencyParty> entry : constituencyParties.entrySet()){
          if(entry.getKey().startsWith(constituency.getName())){
            partyIds.add(entry.getValue().getPartyName());
          }
        }
        List<Party> parties = new ArrayList<>();
        for(String partyId : partyIds){
          parties.add(this.parties.get(partyId));
        }
        return constituency.getWinnerParty(parties);
    }

    public List<Candidate> getCandidates(String partyName) {
        List<Candidate> candidates = new ArrayList<>();
        for(Map.Entry<String , ConstituencyParty> cp : constituencyParties.entrySet()){
          if(cp.getKey().endsWith(partyName)){
            candidates.addAll(cp.getValue().getCandidates());
          }
        }
        return candidates;
    }
}

package com.flipkart.elections.model;

import java.util.HashSet;
import java.util.Set;

public class ConstituencyParty {
    String partyName;
    String constituencyName;
    Set<Candidate> candidates = new HashSet<>();
    int votes;

    public ConstituencyParty(String constituencyName , String partyName) {
        this.partyName = partyName;
        this.constituencyName = constituencyName;
        this.votes = 0;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getConstituencyName() {
        return constituencyName;
    }

    public void setConstituencyName(String constituencyName) {
        this.constituencyName = constituencyName;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
        this.votes += candidate.getVotes();
    }

    public Set<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
    }
}

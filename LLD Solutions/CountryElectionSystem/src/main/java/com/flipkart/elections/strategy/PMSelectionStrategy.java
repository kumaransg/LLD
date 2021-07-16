package com.flipkart.elections.strategy;

import com.flipkart.elections.model.Candidate;
import com.flipkart.elections.model.Country;
import com.flipkart.elections.model.Party;

public interface PMSelectionStrategy {

    Candidate getPMCandidate(Country country , Party party);

    Candidate getPMCandidate(Country country);
}

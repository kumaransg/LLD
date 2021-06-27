package com.swiggy.order.stateslamonitor.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StateSla implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6127329751607595505L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String initialState;
	private String finalState;
	private Integer acceptableValueInMins;

	public StateSla() {
		super();
	}

	public StateSla(Long id, String initialState, String finalState, Integer acceptableValueInMins) {
		super();
		this.id = id;
		this.initialState = initialState;
		this.finalState = finalState;
		this.acceptableValueInMins = acceptableValueInMins;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInitialState() {
		return initialState;
	}

	public void setInitialState(String initialState) {
		this.initialState = initialState;
	}

	public String getFinalState() {
		return finalState;
	}

	public void setFinalState(String finalState) {
		this.finalState = finalState;
	}

	public Integer getAcceptableValueInMins() {
		return acceptableValueInMins;
	}

	public void setAcceptableValueInMins(Integer acceptableValueInMins) {
		this.acceptableValueInMins = acceptableValueInMins;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((finalState == null) ? 0 : finalState.hashCode());
		result = prime * result + ((initialState == null) ? 0 : initialState.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateSla other = (StateSla) obj;
		if (finalState == null) {
			if (other.finalState != null)
				return false;
		} else if (!finalState.equals(other.finalState))
			return false;
		if (initialState == null) {
			if (other.initialState != null)
				return false;
		} else if (!initialState.equals(other.initialState))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StateSla [id=" + id + ", initialState=" + initialState + ", finalState=" + finalState
				+ ", acceptableValueInMins=" + acceptableValueInMins + "]";
	}

}

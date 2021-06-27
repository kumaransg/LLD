package com.swiggy.order.stateslamonitor.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderStateHisotry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8514226969185692360L;

	@Id
	private String orderCode;

	private String state;

	private Date stateUpdatedTime;

	// keeping this , so if processed once, we dont pick same again 
	private boolean monitoringProcessed;

	public OrderStateHisotry() {
		super();
	}

	public OrderStateHisotry(String orderCode, String state, Date stateUpdatedTime) {
		super();
		setOrderCode(orderCode);
		setState(state);
		setStateUpdatedTime(stateUpdatedTime);
	}

	public boolean isMonitoringProcessed() {
		return monitoringProcessed;
	}

	public void setMonitoringProcessed(boolean monitoringProcessed) {
		this.monitoringProcessed = monitoringProcessed;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode.toUpperCase();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state.toUpperCase();
	}

	public Date getStateUpdatedTime() {
		return stateUpdatedTime;
	}

	public void setStateUpdatedTime(Date stateUpdatedTime) {
		this.stateUpdatedTime = stateUpdatedTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderCode == null) ? 0 : orderCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		OrderStateHisotry other = (OrderStateHisotry) obj;
		if (orderCode == null) {
			if (other.orderCode != null)
				return false;
		} else if (!orderCode.equals(other.orderCode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderStateHisotry [orderCode=" + orderCode + ", state=" + state + ", stateUpdatedTime="
				+ stateUpdatedTime + ", monitoringProcessed=" + monitoringProcessed + "]";
	}

}

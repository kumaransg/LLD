package com.swiggy.order.stateslamonitor.dto;

import java.io.Serializable;
import java.util.Date;

// A shared pojo between publisher and consumer 
// should be shared in a base library by producer
// All saying, A common contract needed here
public class OrderStateChangeEventSRO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1381569797845733517L;

	private String orderCode;
	private String currentState;
	private Date stateChangeTime;

	public OrderStateChangeEventSRO() {
		super();
	}

	public OrderStateChangeEventSRO(String orderCode, String currentState, Date stateChangeTime) {
		super();
		this.orderCode = orderCode;
		this.currentState = currentState;
		this.stateChangeTime = stateChangeTime;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public Date getStateChangeTime() {
		return stateChangeTime;
	}

	public void setStateChangeTime(Date stateChangeTime) {
		this.stateChangeTime = stateChangeTime;
	}

	@Override
	public String toString() {
		return "OrderStateChangeEvent [orderCode=" + orderCode + ", currentState=" + currentState + "]";
	}
}

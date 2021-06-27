package com.swiggy.order.stateslamonitor.rabbitmq;

public interface IOrderStateSlaAlertService {

	public void alertOrderBreachSla(String orderCode, String state);

}

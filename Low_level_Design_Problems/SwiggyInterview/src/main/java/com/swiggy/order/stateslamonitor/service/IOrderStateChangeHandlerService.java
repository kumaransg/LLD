package com.swiggy.order.stateslamonitor.service;

import com.swiggy.order.stateslamonitor.dto.OrderStateChangeEventSRO;

public interface IOrderStateChangeHandlerService {

	void handleOrderStateChange(OrderStateChangeEventSRO stateChangeEventSro);

}

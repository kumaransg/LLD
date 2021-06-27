package com.swiggy.order.stateslamonitor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiggy.order.stateslamonitor.dto.OrderStateChangeEventSRO;
import com.swiggy.order.stateslamonitor.entity.OrderStateHisotry;
import com.swiggy.order.stateslamonitor.repository.OrderStateHistoryRepository;

@Service
public class OrderStateChangeHandlerService implements IOrderStateChangeHandlerService {
	
	private static Logger logger = LoggerFactory.getLogger(OrderStateChangeHandlerService.class);

	@Autowired
	private OrderStateHistoryRepository orderstateHistoryRepository;

	public void handleOrderStateChange(OrderStateChangeEventSRO stateChangeEventSro) {
		
		OrderStateHisotry orderStateHistory = orderstateHistoryRepository.findByOrderCodeAndState(stateChangeEventSro.getOrderCode(),stateChangeEventSro.getCurrentState());
		
		//assuming state are not coming to same state again
		if(orderStateHistory!=null){
			logger.info("Ignore message, state change already consumed event: {}, persistedHistory :{} ", stateChangeEventSro, orderStateHistory);
			return;
		}
		orderStateHistory = new OrderStateHisotry(stateChangeEventSro.getOrderCode(), stateChangeEventSro.getCurrentState(), stateChangeEventSro.getStateChangeTime());
		orderstateHistoryRepository.save(orderStateHistory);
	}
}

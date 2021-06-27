package com.swiggy.order.stateslamonitor.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.swiggy.order.stateslamonitor.constants.OrderFinalStates;
import com.swiggy.order.stateslamonitor.entity.OrderStateHisotry;
import com.swiggy.order.stateslamonitor.entity.StateSla;
import com.swiggy.order.stateslamonitor.rabbitmq.IOrderStateSlaAlertService;
import com.swiggy.order.stateslamonitor.repository.OrderStateHistoryRepository;
import com.swiggy.order.stateslamonitor.repository.StateSlaRepository;

public class MonitorOrderStateSlaService implements IMonitorOrderStateSlaService {

	private static Logger logger = LoggerFactory.getLogger(MonitorOrderStateSlaService.class);

	@Autowired
	private StateSlaRepository stateSlaRepository;

	@Autowired
	private OrderStateHistoryRepository orderStateHistoryRepository;
	
	@Autowired
	private IOrderStateSlaAlertService orderStateSlaAlertService;

	public void monitorOrderStateSla() {
		Set<OrderStateHisotry> orderStateHistories = orderStateHistoryRepository.findAllUnMonitoringOrderStateHistories();
		for(OrderStateHisotry orderStateHistory : orderStateHistories){
			checkOrderStateSlaBreach(orderStateHistory);
		}
	}

	private void checkOrderStateSlaBreach(OrderStateHisotry orderStateHistory) {
		// we can have cache here over this repository result
		StateSla stateSla = stateSlaRepository.findByFinalState(orderStateHistory.getState());
		
		//if Order reached in final state mark all order histories as monitorProcessedDone
		if((OrderFinalStates.isOrderStateFinal(orderStateHistory.getState()))){
			Set<OrderStateHisotry> allOrderHistoryForOrder = orderStateHistoryRepository.findByOrderCode(orderStateHistory.getOrderCode());
			markAllAsProcessed(allOrderHistoryForOrder);
			return;
		}
		
		if(!isSlaAcceptable(orderStateHistory.getStateUpdatedTime(), stateSla.getAcceptableValueInMins())){
			logger.info("SLA in not acceptable for orderStateHistory : {}", orderStateHistory);
			orderStateSlaAlertService.alertOrderBreachSla(orderStateHistory.getOrderCode(),orderStateHistory.getState());
			orderStateHistory.setMonitoringProcessed(true);
			orderStateHistoryRepository.save(orderStateHistory);
		}
		
	}

	private void markAllAsProcessed(Set<OrderStateHisotry> allOrderHistoryForOrder) {
		for (OrderStateHisotry orderHistory : allOrderHistoryForOrder){
			orderHistory.setMonitoringProcessed(true);
			orderStateHistoryRepository.save(orderHistory);
		}
		
	}

	private boolean isSlaAcceptable(Date stateChangeTime, Integer accetableSlaInMin) {
		if((Calendar.getInstance().getTimeInMillis() - stateChangeTime.getTime())/1000 >=  accetableSlaInMin*60l){
			return false;
		}
		return true;
	}

}

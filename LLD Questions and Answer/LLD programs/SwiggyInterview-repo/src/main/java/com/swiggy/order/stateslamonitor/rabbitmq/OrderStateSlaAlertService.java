package com.swiggy.order.stateslamonitor.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderStateSlaAlertService implements IOrderStateSlaAlertService {

	private static Logger logger = LoggerFactory.getLogger(OrderStateSlaAlertService.class);

	public void alertOrderBreachSla(String orderCode, String state) {
		// publish to rabbitmq
		logger.info("Publish to rabbitmq");
	}

}

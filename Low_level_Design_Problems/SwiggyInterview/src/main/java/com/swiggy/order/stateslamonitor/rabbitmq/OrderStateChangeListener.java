/**
*/
package com.swiggy.order.stateslamonitor.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.swiggy.order.stateslamonitor.dto.OrderStateChangeEventSRO;
import com.swiggy.order.stateslamonitor.service.IOrderStateChangeHandlerService;

public class OrderStateChangeListener implements MessageListener {

	private static Logger logger = LoggerFactory.getLogger(OrderStateChangeListener.class);

	@Autowired
	private IOrderStateChangeHandlerService orderStateChangeHandlerService;

	public void onMessage(Message message) {
		OrderStateChangeEventSRO orderStateChangeEvent = (OrderStateChangeEventSRO) SerializationUtils.deserialize(message.getBody());
		logger.info("Event received : {}", orderStateChangeEvent.toString());
		try{
			orderStateChangeHandlerService.handleOrderStateChange(orderStateChangeEvent);
		}catch(Exception ex){
			logger.error(String.format("Error while consuming event %s", orderStateChangeEvent.toString()),ex);
			// to reconsume event again in case of error, we can build retries count on same event too.
			throw new RuntimeException(ex);
		}
		logger.info("Event consumed successfully : {}", orderStateChangeEvent.toString());
	}

}

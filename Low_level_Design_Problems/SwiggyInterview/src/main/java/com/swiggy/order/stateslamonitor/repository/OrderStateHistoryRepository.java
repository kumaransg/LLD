package com.swiggy.order.stateslamonitor.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swiggy.order.stateslamonitor.entity.OrderStateHisotry;

public interface OrderStateHistoryRepository extends JpaRepository<OrderStateHisotry, String> {

	public OrderStateHisotry findByOrderCodeAndState(String orderCode, String currentState);
	
	@Query("from OrderStateHisotry where monitoringProcessed=false")
	public Set<OrderStateHisotry> findAllUnMonitoringOrderStateHistories();

	public Set<OrderStateHisotry> findByOrderCode(String orderCode);

}
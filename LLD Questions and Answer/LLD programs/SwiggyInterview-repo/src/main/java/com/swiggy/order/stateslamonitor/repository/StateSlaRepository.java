package com.swiggy.order.stateslamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swiggy.order.stateslamonitor.entity.StateSla;

public interface StateSlaRepository extends JpaRepository<StateSla, Integer> {

	public StateSla findByFinalState(String state);

}
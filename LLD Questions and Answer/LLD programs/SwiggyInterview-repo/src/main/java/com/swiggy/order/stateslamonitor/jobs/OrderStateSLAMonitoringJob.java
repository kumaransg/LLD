package com.swiggy.order.stateslamonitor.jobs;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.swiggy.order.stateslamonitor.service.IMonitorOrderStateSlaService;

// Run each minutes
public class OrderStateSLAMonitoringJob extends BaseJob {

	@Autowired
	private IMonitorOrderStateSlaService monitorOrderStateSlaService;

	@Override
	protected void executeJob(Map<String, Object> data) throws Exception {
		//ALL logging is already in baseJob
		monitorOrderStateSlaService.monitorOrderStateSla();
		
	}

}

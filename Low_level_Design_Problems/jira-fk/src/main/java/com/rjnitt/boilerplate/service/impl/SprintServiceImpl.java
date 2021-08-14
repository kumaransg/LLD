package com.rjnitt.boilerplate.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjnitt.boilerplate.dto.SprintDto;
import com.rjnitt.boilerplate.entity.Sprint;
import com.rjnitt.boilerplate.repository.SprintRepository;
import com.rjnitt.boilerplate.service.SprintService;
import com.rjnitt.boilerplate.util.CommonConstant;
import com.rjnitt.boilerplate.util.Util;

@Service
@Transactional
public class SprintServiceImpl implements SprintService {

	private final static Logger LOG = LoggerFactory.getLogger(SprintServiceImpl.class);

	@Autowired
	private SprintRepository sprintRepo;

	@Override
	public Sprint createSprint(SprintDto task) {
		LOG.info("Create Sprint : [{}]", task);
		task.validateForCreate();
		Long ct = System.currentTimeMillis();
		Long userId = CommonConstant.UserId;
		Sprint sprint = Sprint.tranformForCreate(task, ct, userId);
		return sprintRepo.save(sprint);
	}

	@Override
	public Sprint get(Long sprintId) {
		LOG.info("get Sprint : [{}]", sprintId);
		Util.validateLong(sprintId, "Sprint Id can't be null/empty");
		Sprint findOne = sprintRepo.findOne(sprintId);

		return Util.noRecordFoundWithReturn(findOne, "No Sprint Found for " + sprintId);
	}

}

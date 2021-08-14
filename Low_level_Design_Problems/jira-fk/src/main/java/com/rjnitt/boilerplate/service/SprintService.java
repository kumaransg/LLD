package com.rjnitt.boilerplate.service;

import com.rjnitt.boilerplate.dto.SprintDto;
import com.rjnitt.boilerplate.entity.Sprint;

public interface SprintService {

	Sprint createSprint(SprintDto task);

	Sprint get(Long sprintId);

}

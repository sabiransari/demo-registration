package com.loylty.retail.task.processor.model;

import javax.validation.constraints.NotNull;

import com.loylty.retail.task.processor.entities.Task;

public interface TaskHandler {
	public void handle(@NotNull Task task);
}

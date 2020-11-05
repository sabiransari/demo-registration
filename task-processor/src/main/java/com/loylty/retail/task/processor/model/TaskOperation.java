package com.loylty.retail.task.processor.model;

import com.loylty.retail.task.processor.entities.Task;

public interface TaskOperation {
	
	public void perform(Task task);
	
}

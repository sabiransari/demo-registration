package com.loylty.retail.task.processor.model;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.loylty.retail.task.processor.entities.Task;

@Component("functionTaskOperation")
public class FunctionTaskOperation implements TaskOperation {
	
	private ApplicationContext applicationContext;

	@Override
	public void perform(Task task) {
		TaskHandler taskHandler = applicationContext.getBean(task.getOperation().getName(), TaskHandler.class);
		taskHandler.handle(task);
	}

}

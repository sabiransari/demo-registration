package com.loylty.retail.task.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.loylty.retail.task.processor.entities.Task;
import com.loylty.retail.task.processor.enums.OperationType;
import com.loylty.retail.task.processor.enums.Status;
import com.loylty.retail.task.processor.model.TaskOperation;
import com.loylty.retail.task.processor.repository.TaskRepository;

@Service
@Validated
public class TaskProcessorContext {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private ApplicationContext applicationContext;
	
	private Map<String, List<Task>> groupIdToTaskList = new ConcurrentHashMap<>();
	
	@PostConstruct
	public void init() {
		List<Task> allTasks = taskRepository.findByStatusOrderByTaskOrderAsc(Status.active);
		groupIdToTaskList.putAll(allTasks.parallelStream().collect(Collectors.groupingBy(Task::getGroupId)));
	}
	
	public List<Task> getTasksByGroupId(String groupId) {
		return groupIdToTaskList.getOrDefault(groupId, new ArrayList<Task>());
	}
	
	@Validated
	public void processConfiguredTasks(@NotNull String groupId) {
		List<Task> tasksByGroupId = getTasksByGroupId(groupId);
		tasksByGroupId.stream().forEach(task -> {
			String type = task.getOperation().getType();
			OperationType operationType = OperationType.fromString(type);
			TaskOperation taskOperation;
			if (operationType.equals(OperationType.function)) {
				taskOperation = applicationContext.getBean("functionTaskOperation", TaskOperation.class);
			} else if (operationType.equals(OperationType.expression)) {
				taskOperation = applicationContext.getBean("expressionTaskOperation", TaskOperation.class);
			} else {
				throw new RuntimeException("Invalid Task Operation");
			}
			taskOperation.perform(task);
		});
	}
}

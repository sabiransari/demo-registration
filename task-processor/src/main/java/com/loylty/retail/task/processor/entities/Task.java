package com.loylty.retail.task.processor.entities;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.loylty.retail.task.processor.enums.Status;
import com.loylty.retail.task.processor.enums.TaskType;
import com.loylty.retail.task.processor.model.Operation;

@Document(collection = "task")
public class Task {
	@Id
	private String id;
	private Long taskOrder;
	private String taskName;
	private TaskType taskType;
	private Operation operation;
	private String groupId;
	private String channel;
	private Status status;
	private Long creationDate;
	private Long lastModifiedDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getTaskOrder() {
		return taskOrder;
	}
	public void setTaskOrder(Long taskOrder) {
		this.taskOrder = taskOrder;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public TaskType getTaskType() {
		return taskType;
	}
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Long getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Long creationDate) {
		this.creationDate = creationDate;
	}
	public Long getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Long lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}

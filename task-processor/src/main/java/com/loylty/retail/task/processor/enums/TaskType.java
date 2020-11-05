package com.loylty.retail.task.processor.enums;

public enum TaskType {
	validation("validation"),
	enrichment("enrichment");
	
	private String name;
	
	private TaskType(String name) {
		this.name = name;
	}
}

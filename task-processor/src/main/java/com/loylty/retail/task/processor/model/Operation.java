package com.loylty.retail.task.processor.model;

public class Operation {
	private String	name;
	private String type;
	private Object inputParameters;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Object getInputParameters() {
		return inputParameters;
	}
	public void setInputParameters(Object inputParameters) {
		this.inputParameters = inputParameters;
	}
}

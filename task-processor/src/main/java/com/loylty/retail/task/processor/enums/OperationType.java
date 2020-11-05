package com.loylty.retail.task.processor.enums;

public enum OperationType {
	function,
	expression,
	invalid;
	
	public static OperationType fromString(String type) {
		for (OperationType opType : OperationType.values()) {
			if (opType.toString().equals(type)) {
				return opType;
			}
		}
		return invalid;
	}
}

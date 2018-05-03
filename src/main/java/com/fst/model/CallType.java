package com.fst.model;

public enum CallType {
	
	MISSED("MISSED"),
	RECEIVED("RECEIVED"),
	DIALLED("DIALLED")
	;
	public String callType;
	private CallType(String callType) {
		this.callType = callType;
	}
	
}

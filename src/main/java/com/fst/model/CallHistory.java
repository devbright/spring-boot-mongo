package com.fst.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class CallHistory {
	
	@Id
	public String id;
	public String name;
	public String phone;
	public Date timestamp;
	public CallType callType;
	public Long durationInSeconds;
	
	public CallHistory() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public CallType getCallType() {
		return callType;
	}
	public void setCallType(CallType callType) {
		this.callType = callType;
	}
	public Long getDurationInSeconds() {
		return durationInSeconds;
	}
	public void setDurationInSeconds(Long durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(" | ");
		}
		if (phone != null) {
			builder.append("phone=");
			builder.append(phone);
			builder.append(" | ");
		}
		if (timestamp != null) {
			builder.append("timestamp=");
			builder.append(timestamp);
			builder.append(" | ");
		}
		if (callType != null) {
			builder.append("callType=");
			builder.append(callType);
			builder.append(" | ");
		}
		if (durationInSeconds != null) {
			builder.append("durationInSeconds=");
			builder.append(durationInSeconds);
		}
		builder.append("\n");
		return builder.toString();
	}

	
	
	
}

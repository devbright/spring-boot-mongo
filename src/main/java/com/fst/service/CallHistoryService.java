package com.fst.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.fst.model.CallHistory;
import com.fst.model.CallType;

public interface CallHistoryService extends GenericService<CallHistory> {
	
	public List<CallHistory> findByCallType(CallType callType, Pageable pageable);

}

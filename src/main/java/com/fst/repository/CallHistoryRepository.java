package com.fst.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.fst.model.CallHistory;
import com.fst.model.CallType;

public interface CallHistoryRepository extends PagingAndSortingRepository<CallHistory, Long> {
	
	public List<CallHistory> findAll();
	public List<CallHistory> findByName(String name);
	public List<CallHistory> findByNameAndCallType(String name, CallType callType);
	public List<CallHistory> findByCallType(CallType callType);

}

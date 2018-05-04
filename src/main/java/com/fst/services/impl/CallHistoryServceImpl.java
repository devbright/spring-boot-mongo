package com.fst.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fst.model.CallHistory;
import com.fst.model.CallType;
import com.fst.repository.CallHistoryRepository;
import com.fst.service.CallHistoryService;

@Service
public class CallHistoryServceImpl implements CallHistoryService {

	
	@Autowired
	CallHistoryRepository callHistoryRepository;
	
	@Override
	public CallHistory add(CallHistory record) {
		record.setTimestamp(new Date());
		return callHistoryRepository.save(record);
	}

	@Override
	public CallHistory update(CallHistory record) {
		return callHistoryRepository.save(record);
	}

	@Override
	public boolean deleteByName(String name) {
		Long dd = callHistoryRepository.deleteByName(name);
		System.out.println(dd);
		return true;
	}
	
	@Override
	public List<CallHistory> findAll() {
		return callHistoryRepository.findAll();
	}
	
	@Override
	public List<CallHistory> findAll(Pageable pageable) {
		Page<CallHistory> callHistories = callHistoryRepository.findAll(pageable);
		List<CallHistory> list = callHistories.stream().collect(Collectors.toList());
		return list;
	}

	@Override
	public Optional<CallHistory> findById(Long id) {
		return callHistoryRepository.findById(id);
	}
	
	@Override
	public List<CallHistory> findByCallType(CallType callType, Pageable pageable) {
		return callHistoryRepository.findByCallType(callType, pageable);
	}
	
	public void setCallHistoryRepository(CallHistoryRepository callHistoryRepository) {
		this.callHistoryRepository = callHistoryRepository;
	}
	
	

}

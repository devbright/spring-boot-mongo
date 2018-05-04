package com.fst.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fst.model.CallHistory;
import com.fst.model.CallType;
import com.fst.service.CallHistoryService;

@RestController
public class CallHistoryController {

	@Autowired
	private CallHistoryService callHistoryService;
	
	public void setCallHistoryService(CallHistoryService callHistoryService) {
		this.callHistoryService = callHistoryService;
	}

	
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> add(@RequestBody CallHistory callHistory) {
		Map<String, Object> responseMap = new HashMap<>();
		CallHistory ch = callHistoryService.add(callHistory);
		responseMap.put("callHistory", ch);
		return responseMap;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> listAll() {
		Map<String, Object> responseMap = new HashMap<>();
		List<CallHistory> callHistoryList = callHistoryService.findAll();
		responseMap.put("callHistory", callHistoryList);
		return responseMap;
	}
	
	@RequestMapping(value="/list/{pageNo}", method=RequestMethod.GET, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> listPage(@PathVariable("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
		Map<String, Object> responseMap = new HashMap<>();
		List<CallHistory> callHistoryList = callHistoryService.findAll(PageRequest.of(pageNo, pageSize));
		responseMap.put("callHistory", callHistoryList);
		return responseMap;
	}
	
	@RequestMapping(value="/callType/{pageNo}", method=RequestMethod.GET, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> listPage(@PathVariable("pageNo") int pageNo, @RequestParam("callType") CallType callType, @RequestParam("pageSize") int pageSize) {
		Map<String, Object> responseMap = new HashMap<>();
		List<CallHistory> callHistoryList = callHistoryService.findByCallType(callType, PageRequest.of(pageNo, pageSize));
		responseMap.put("callHistory", callHistoryList);
		return responseMap;
	}
	
	@RequestMapping(value="/delete/{name}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> delete(@PathVariable String name) {
		CallHistory cs = new CallHistory();
		//cs.setId(name);
		callHistoryService.deleteByName(name);
		return listAll(); 
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> update(@RequestBody CallHistory callHistory) {
		Map<String, Object> responseMap = new HashMap<>();
		callHistory.setTimestamp(new Date());
		CallHistory ch = callHistoryService.update(callHistory);
		responseMap.put("callHistory", ch);
		return responseMap;
	}
	
}

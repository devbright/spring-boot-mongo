package com.fst.cst;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.fst.configs.MongoConfiguration;
import com.fst.model.CallHistory;
import com.fst.model.CallType;
import com.fst.repository.CallHistoryRepository;

@SpringBootApplication
@Import(value= {MongoConfiguration.class})
public class CstApplication implements CommandLineRunner {

	@Autowired
	CallHistoryRepository callHistoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CstApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		callHistoryRepository.deleteAll();
		
		CallHistory ch = new CallHistory();
		for(int i = 0 ; i < 5 ; i++) {
			ch = new CallHistory();
			ch.setCallType(CallType.RECEIVED);
			ch.setDurationInSeconds(0L);
			ch.setName("TestUser"+i);
			ch.setPhone("91890784512"+i);
			ch.setTimestamp(new Date());
			callHistoryRepository.save(ch);
		}
		for(int i = 6 ; i < 11 ; i++) {
			ch = new CallHistory();
			ch.setCallType(CallType.MISSED);
			ch.setDurationInSeconds(0L);
			ch.setName("TestUser"+i);
			ch.setPhone("91890784512"+i);
			ch.setTimestamp(new Date());
			callHistoryRepository.save(ch);
		}
		
		
		System.out.println("Data ...");
		System.out.println(callHistoryRepository.findAll());
		
		Page<CallHistory> page = callHistoryRepository.findAll(PageRequest.of(0, 3));
		List<CallHistory> callList = page.stream().collect(Collectors.toList());
		
		System.out.println(callList);
		
		page = callHistoryRepository.findAll(PageRequest.of(1, 3));
		callList = page.stream().collect(Collectors.toList());
		System.out.println(callList);

		page = callHistoryRepository.findAll(PageRequest.of(2, 3));
		callList = page.stream().collect(Collectors.toList());
		System.out.println(callList);
		
		System.out.println(CallType.MISSED+" calls data...");
		System.out.println(callHistoryRepository.findByCallType(CallType.MISSED));
		
		System.out.println(CallType.RECEIVED+" calls data...");
		System.out.println(callHistoryRepository.findByCallType(CallType.RECEIVED));
		
		System.out.println(CallType.DIALLED+" calls data...");
		System.out.println(callHistoryRepository.findByCallType(CallType.DIALLED));
		
		
		
	}
	
}

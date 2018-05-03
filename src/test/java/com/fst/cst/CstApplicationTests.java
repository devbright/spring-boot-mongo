package com.fst.cst;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.function.Consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.fst.model.CallHistory;
import com.fst.repository.CallHistoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class CstApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	CallHistoryRepository repository;

	@Test
	public void readsFirstPageCorrectly() {
		PageRequest pageable = PageRequest.of(1, 4);
		Page<CallHistory> history = repository.findAll(pageable);
		history.forEach(new Consumer<CallHistory>() {
			@Override
			public void accept(CallHistory t) {
				System.out.println(t.getName()+" "+t.getCallType());
			}
		});
		assertThat(history.getPageable().first().isPaged(),is(true));
	}

}

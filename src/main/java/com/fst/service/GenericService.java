package com.fst.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;


public interface GenericService<T> {
	T add(T record);
	T update(T record);
	boolean deleteByName(String name);
	List<T> findAll();
	List<T> findAll(Pageable pageable);
	Optional<T> findById(Long id);
}

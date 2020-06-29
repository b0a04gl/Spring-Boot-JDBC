package com.foobar.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.foobar.spring.model.Store;

public interface StoreDaoRepository extends CrudRepository<Store,Integer>{

	@Override
    @Transactional(timeout = 8)
    Iterable<Store> findAll();
}

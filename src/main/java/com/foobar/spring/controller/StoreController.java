package com.foobar.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.foobar.spring.dao.StoreDaoRepository;
import java.util.List;
import com.foobar.spring.model.Store;

@RequestMapping("/store")
@RestController
public class StoreController {
	
	@Autowired
	private StoreDaoRepository dao;
	
	@PostMapping("/addStores")
	public String addStores(Store newStore)
	{
		dao.save(newStore);
		return "Stores added : " +newStore.toString();
	}
	
	@GetMapping("/getStores")
	public List<Store> getStores()
	{
		return (List<Store>)dao.findAll();
	}
}

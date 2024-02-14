package com.laptop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptop.dao.LaptopDao;
import com.laptop.entity.Laptop;

@Service
public class LaptopService {
	
	@Autowired
	LaptopDao laDao;
	
	public String post(List<Laptop> l) {
		return laDao.post(l);
		
	}
	public List<Laptop> get(){
		return laDao.get();
	}
	public String updateId(Laptop l) {
		return laDao.updateId(l);
	}
//	************************************
	public String update(Laptop l,int id) {
		return laDao.update(l,id);
	}
//	************************************
	//@Patchmapping//
	public String update1(Laptop l,int id) {
		return laDao.update(l,id);
	}
	

}

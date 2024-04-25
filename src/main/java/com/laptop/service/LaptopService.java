package com.laptop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.laptop.dao.LaptopDao;
import com.laptop.entity.Laptop;
import com.laptop.exception.BrandNotFoundException;
import com.laptop.exception.IdNotFoundException;

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
//	*********************************************
	//GloblaExcep//
	
	public Laptop get(int id) throws IdNotFoundException{
	
	if(id==0) {
		throw  new IdNotFoundException("excep handled");
	}
	else {
		return laDao.get(id);
	}
}
//	***********************************************
	//Globalbrand//
	
	public List<Laptop> getbrand(String b) throws BrandNotFoundException {
		List<Laptop> alllaptop=laDao.get().stream().filter(x->x.getBrand().equals(b)).collect(Collectors.toList());
		if(alllaptop.isEmpty()) {                                                                                                                                                                
			throw new BrandNotFoundException("brand name not found ");                                                                                                                                         
		}
		else {
			return alllaptop;
		}
	}
//	***************************************
	//globalnullpointer//
	public List<Laptop> getModel(String m) {
		List<Laptop> alllaptop=laDao.get().stream().filter(x->x.getModel().equals(m)).collect(Collectors.toList());
		if(alllaptop.isEmpty()) {
			throw new NullPointerException("given model is not there");
		}
		else {
			return alllaptop;
		}
	}
//	***************************************
//	//globalarthimetic//
	public List<Laptop> getPrice(int p) {
		List<Laptop> alllaptop=laDao.get().stream().filter(y->y.getPrice()==(p)).collect(Collectors.toList());
		if(alllaptop.isEmpty()) {
			throw new ArithmeticException("given price is not there");
		}
		else {
			return alllaptop;
		}
	}
}
	
	


package com.laptop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.laptop.entity.Laptop;
import com.laptop.repository.LaptopRepository;

@Repository
public class LaptopDao {

	@Autowired
	LaptopRepository laRepo;

	public String post(List<Laptop> l) {
		laRepo.saveAll(l);
		return "Sucessfully saved";
	}

	public List<Laptop> get() {
		return laRepo.findAll();
	}

	public String updateId(Laptop l) {
		laRepo.save(l);
		return "updated";

	}

//	********************************
	public String update(Laptop l, int id) {
		Laptop x = laRepo.findById(id).get();
		if (l.getPrice() > 0) {
			x.setPrice(l.getPrice());
		}
		laRepo.save(x);
		return "price Updated Sucessfully";
	}

//	****************************************
//	patchmapping ithu service la kuda tharalam//
	public String update1(Laptop l, int id) {
		Laptop x = laRepo.findById(id).get();
		if (l.getPrice() > 0) {
			x.setPrice(l.getPrice());
		}
		laRepo.save(x);
		return "price Updated Sucessfully";
	}

//*************************************************
	public Laptop get(int id) {// exception//
		return laRepo.findById(id).get();
	}
//	************************************
	
}

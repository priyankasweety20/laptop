package com.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptop.entity.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop,Integer>{

}

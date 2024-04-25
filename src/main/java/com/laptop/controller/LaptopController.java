package com.laptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptop.entity.Laptop;
import com.laptop.exception.BrandNotFoundException;
import com.laptop.exception.IdNotFoundException;
import com.laptop.service.LaptopService;

@RestController
@RequestMapping(value = "/lap")
public class LaptopController {

	@Autowired
	LaptopService laSer;

	@PostMapping(value = "/postAll")
	public String post(@RequestBody List<Laptop> l) {
		return laSer.post(l);
	}

	@GetMapping(value = "/getAll")
	public List<Laptop> get() {
		return laSer.get();
	}

	@PutMapping(value = "/updateId")
	public String updateId(@RequestBody Laptop l) {
		return laSer.updateId(l);
	}

//	**************************************************
//	myself using reqbody and pathvariable

	@PutMapping(value = "/update/{id}")
	public String update(@RequestBody Laptop l, @PathVariable int id) {
		return laSer.update(l, id);

	}

//	***************************************
	// patch mapping//
	@PatchMapping(value="/modify/{id}")
	public String update1(@RequestBody Laptop l,@PathVariable int id) {
		return laSer.update(l,id);
	}
//	*************************************************
		//exception handled by global//
		
		@GetMapping(value="/getid/{id}")
		public List<Laptop> get(@PathVariable int id) throws IdNotFoundException{
		return (List<Laptop>) laSer.get(id);
		}
		
		@GetMapping(value="/getBrand/{b}")
		public List<Laptop> getbrand(@PathVariable String b) throws BrandNotFoundException {
			return laSer.getbrand(b);
		}
		
		@GetMapping(value="/getModel/{m}")//null pointer excep// throws poda thevailla default eduthukum @restcontrolleradvice//
		public List<Laptop> getModel(@PathVariable String m)  {
			return laSer.getModel(m);
		}
		@GetMapping(value="/getPrice/{p}")//arithemetice excep//
		public List<Laptop> getPrice(@PathVariable int p) {
			return laSer.getPrice(p);
		}
}


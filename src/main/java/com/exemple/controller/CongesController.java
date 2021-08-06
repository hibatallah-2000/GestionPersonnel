package com.exemple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.db.CongesRepository;
import com.exemple.model.Conges;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "conges")
public class CongesController {
	@Autowired
	private CongesRepository congesRepository;
	@GetMapping("/get")
	public List<Conges> getConges() {
		return congesRepository.findAll();
		
	}
	@PostMapping("/add")
	public void createConges(@RequestBody Conges conges) {
		congesRepository.save(conges);
	}
	@DeleteMapping(path = { "/{id}" })
	public Conges deleteConges(@PathVariable("id") long id) {
		Conges conges = congesRepository.getById(id);
		congesRepository.deleteById(id);
		return conges;
	}
	@PutMapping("/update")
	public void updatePersonnel(@RequestBody Conges conges) {
		congesRepository.save(conges);
	}
}

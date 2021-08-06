package com.exemple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.db.ConjointRepository;
import com.exemple.model.Conjoint;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "conjoints")
public class ConjointController {
	@Autowired
	private ConjointRepository conjointRepository;
	@GetMapping("/get")
	public List<Conjoint> getConjoints() {
		return conjointRepository.findAll();
		
	}
	@PostMapping("/add")
	public void createConjoint(@RequestBody Conjoint conjoint) {
		conjointRepository.save(conjoint);
	}
	@DeleteMapping(path = { "/{id}" })
	public Conjoint deleteConjoint(@PathVariable("id") long id) {
		Conjoint conjoint = conjointRepository.getById(id);
		conjointRepository.deleteById(id);
		return conjoint;
	}

}

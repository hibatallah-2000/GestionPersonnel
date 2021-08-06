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

import com.exemple.db.MutuelleRepository;
import com.exemple.model.Mutuelle;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "mutuelles")
public class MutuelleController {
	@Autowired
	private MutuelleRepository mutuelleRepository;
	@GetMapping("/get")
	public List<Mutuelle> getMutuelle() {
		return mutuelleRepository.findAll();
		
	}
	@PostMapping("/add")
	public void createMutuelle(@RequestBody Mutuelle grades) {
		mutuelleRepository.save(grades);
	}
	@DeleteMapping(path = { "/{id}" })
	public Mutuelle deleteMutuelle(@PathVariable("id") long id) {
		Mutuelle mutuelle = mutuelleRepository.getById(id);
		mutuelleRepository.deleteById(id);
		return mutuelle;
	}

}

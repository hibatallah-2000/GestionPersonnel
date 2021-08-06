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

import com.exemple.db.DiplomeRepository;
import com.exemple.model.Diplome;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "diplomes")
public class DiplomeController {
	@Autowired
	private DiplomeRepository diplomeRepository;
	@GetMapping("/get")
	public List<Diplome> getDiplomes() {
		return diplomeRepository.findAll();
		
	}
	@PostMapping("/add")
	public void createDiplome(@RequestBody Diplome diplome) {
		diplomeRepository.save(diplome);
	}
	@DeleteMapping(path = { "/{id}" })
	public Diplome deleteDiplome(@PathVariable("id") long id) {
		Diplome diplome = diplomeRepository.getById(id);
		diplomeRepository.deleteById(id);
		return diplome;
	}


}

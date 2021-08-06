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

import com.exemple.db.FonctionRepository;
import com.exemple.model.Fonction;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "fonctions")
public class FonctionController {
	@Autowired
	private FonctionRepository fonctionsRepository;
	@GetMapping("/get")
	public List<Fonction> getFonctions() {
		return fonctionsRepository.findAll();
		
	}
	@PostMapping("/add")
	public void createFonctions(@RequestBody Fonction fonctions) {
		fonctionsRepository.save(fonctions);
	}
	@DeleteMapping(path = { "/{id}" })
	public Fonction deleteFonctions(@PathVariable("id") long id) {
		Fonction fonctions = fonctionsRepository.getById(id);
		fonctionsRepository.deleteById(id);
		return fonctions;
	}

}

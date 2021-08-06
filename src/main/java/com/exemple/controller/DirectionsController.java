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

import com.exemple.db.DirectionsRepository;
import com.exemple.model.Directions;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "directions")
public class DirectionsController {
	@Autowired
	private DirectionsRepository directionsRepository;
	@GetMapping("/get")
	public List<Directions> getDirections() {
		return directionsRepository.findAll();
		
	}
	@PostMapping("/add")
	public void createDirections(@RequestBody Directions directions) {
		directionsRepository.save(directions);
	}
	@DeleteMapping(path = { "/{id}" })
	public Directions deleteDirections(@PathVariable("id") long id) {
		Directions directions = directionsRepository.getById(id);
		directionsRepository.deleteById(id);
		return directions;
	}

}

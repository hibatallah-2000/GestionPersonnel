package com.exemple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.db.DirectionsRepository;
import com.exemple.db.DivisionRepository;
import com.exemple.model.Directions;
import com.exemple.model.Division;
import com.exemple.model.Mutuelle;
import com.exemple.model.Personnel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "divisions")
public class DivisionController {
	@Autowired
	private DivisionRepository divisionsRepository;
	@Autowired
	private DirectionsRepository directionsRepository;
	@GetMapping("/get")
	public List<Division> getDivisions() {
		return divisionsRepository.findAll();
		
	}
	@PostMapping("/add")
	public void createDivisions(@RequestBody Division division) {
		divisionsRepository.save(division);
	}
	@DeleteMapping(path = { "/{id}" })
	public Division deleteDivisions(@PathVariable("id") long id) {
		Division division = divisionsRepository.getById(id);
		divisionsRepository.deleteById(id);
		return division;
	}
	@PutMapping("/{divisionId}/directions/{directionId}")
		Division assignDirectionToDivision(@PathVariable Long divisionId,@PathVariable Long directionId) {
		Division divisions= divisionsRepository.findById(divisionId).get();
		Directions directions=directionsRepository.findById(directionId).get();
		divisions.assignDirections(directions);
		return divisionsRepository.save(divisions);
		
		}

}

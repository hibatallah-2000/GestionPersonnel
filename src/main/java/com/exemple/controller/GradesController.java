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

import com.exemple.db.GradesRepository;
import com.exemple.model.Grades;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "grades")
public class GradesController {
	@Autowired
	private GradesRepository gradesRepository;
	@GetMapping("/get")
	public List<Grades> getGrades() {
		return gradesRepository.findAll();
		
	}
	@PostMapping("/add")
	public void createGrades(@RequestBody Grades grades) {
		gradesRepository.save(grades);
	}
	@DeleteMapping(path = { "/{id}" })
	public Grades deleteFonctions(@PathVariable("id") long id) {
		Grades grades = gradesRepository.getById(id);
		gradesRepository.deleteById(id);
		return grades;
	}

}

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

import com.exemple.db.DivisionRepository;
import com.exemple.db.ServicesRepository;
import com.exemple.model.Directions;
import com.exemple.model.Division;
import com.exemple.model.Services;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "services")
public class ServicesController {
	@Autowired
	private ServicesRepository servicesRepository;
	@Autowired
	private DivisionRepository divisionsRepository;
	@GetMapping("/get")
	public List<Services> getServices() {
		return servicesRepository.findAll();
		
	}
	@PostMapping("/add")
	public void createService(@RequestBody Services service) {
		servicesRepository.save(service);
	}
	@DeleteMapping(path = { "/{id}" })
	public Services deleteService(@PathVariable("id") long id) {
		Services service = servicesRepository.getById(id);
		servicesRepository.deleteById(id);
		return service;
	}
	@PutMapping("/{serviceId}/divisions/{divisionId}")
	Services assignServiceToDivision(@PathVariable Long serviceId,@PathVariable Long divisionId) {
	Services services= servicesRepository.findById(serviceId).get();
	Division division=divisionsRepository.findById(divisionId).get();
	services.assignDivision(division);
	return servicesRepository.save(services);
	
	}

}

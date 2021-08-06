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

import com.exemple.db.MissionRepository;
import com.exemple.db.PersonnelRepository;
import com.exemple.model.Mission;
import com.exemple.model.Personnel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "missions")
public class MissionController {
	@Autowired
	private MissionRepository missionRepository;
	@Autowired
	private PersonnelRepository personnelRepository;
	@GetMapping("/get")
	public List<Mission> getMission() {
		return missionRepository.findAll();
		
	}
	@PostMapping("/add")
	public void createMission(@RequestBody Mission mission) {
		missionRepository.save(mission);
	}
	@DeleteMapping(path = { "/{id}" })
	public Mission deleteService(@PathVariable("id") long id) {
		Mission mission = missionRepository.getById(id);
		missionRepository.deleteById(id);
		return mission;
	}
	@PutMapping("/{missionId}/personnels/{personnelId}")
	Mission assignMissionsToPersonnel(@PathVariable Long missionId,@PathVariable Long personnelId) {
		
		Mission mission= missionRepository.findById(missionId).get();
		Personnel personnel= personnelRepository.findById(personnelId).get();
		mission.assignPersonnel(personnel);
		return missionRepository.save(mission);
		
		}

}

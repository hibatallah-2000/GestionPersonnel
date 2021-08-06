package com.exemple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
import com.exemple.db.ConjointRepository;
import com.exemple.db.DiplomeRepository;
import com.exemple.db.DivisionRepository;
import com.exemple.db.FonctionRepository;
import com.exemple.db.GradesRepository;
import com.exemple.db.MissionRepository;
import com.exemple.db.MutuelleRepository;
import com.exemple.db.PersonnelRepository;
import com.exemple.model.Conges;
import com.exemple.model.Conjoint;
import com.exemple.model.Diplome;
import com.exemple.model.Division;
import com.exemple.model.Fonction;
import com.exemple.model.Grades;
import com.exemple.model.Mission;
import com.exemple.model.Mutuelle;
import com.exemple.model.Personnel;
import com.exemple.model.Services;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "personnels")

public class PersonnelController {

	@Autowired
	private PersonnelRepository personnelRepository;
	@Autowired
	private CongesRepository congesRepository;
	@Autowired
	private GradesRepository gradesRepository;
	@Autowired
	private FonctionRepository fonctionRepository;
	@Autowired
	private DiplomeRepository diplomeRepository;
	@Autowired
	private MutuelleRepository mutuelleRepository;
	@Autowired
	private DivisionRepository divisionRepository;
	@Autowired
	private ConjointRepository conjointRepository;
	
	
	 @GetMapping("/signup")
	    public String showSignUpForm(Personnel personnel) {
	        return "add-personnel";
	    }
	 @GetMapping("/list")
	    public String showUpdateForm(Model model) {
	        model.addAttribute("personnels", personnelRepository.findAll());
	        return "index";
	    }
	 @PostMapping("/add")
	    public String addPersonnel(@Validated Personnel personnel, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-personnel";
	        }

	        personnelRepository.save(personnel);
	        return "redirect:list";
	    }
	 
	 @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	        Personnel personnel = personnelRepository.findById(id)
	        		.orElseThrow(() -> new IllegalArgumentException("Invalid personnel Id:" + id));
	        model.addAttribute("personnel", personnel);
	        return "update-student";
	    }
	 @PostMapping("/update/{id}")
	    public String updatePersonnel(@PathVariable("id") long id, @Validated Personnel personnel, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	           personnel.setId(id);
	            return "update-student";
	        }

	        personnelRepository.save(personnel);
	        model.addAttribute("personnels", personnelRepository.findAll());
	        return "index";
	    }
	 @GetMapping("/delete/{id}")
	    public String deletePersonnel(@PathVariable("id") long id, Model model) {
	        Personnel personnel = personnelRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid personnel Id:" + id));
	        personnelRepository.delete(personnel);
	        model.addAttribute("personnels", personnelRepository.findAll());
	        return "index";
	    }
	@GetMapping("/get")
	public List<Personnel> getPersonnel() {
		return personnelRepository.findAll();
		
	}
	@PostMapping("/create")
	public void createPersonnel(@RequestBody Personnel personnel) {
		personnelRepository.save(personnel);
	}
	@DeleteMapping(path = { "/{id}" })
	public Personnel deletePersonnel(@PathVariable("id") long id) {
		Personnel personnel = personnelRepository.getById(id);
		personnelRepository.deleteById(id);
		return personnel;
	}
	@PutMapping("/update")
	public void updatePersonnel(@RequestBody Personnel personnels) {
		personnelRepository.save(personnels);
	}
	@PutMapping("/{personnelId}/conges/{congesId}")
	Personnel enrollPersonnelToConges(@PathVariable Long personnelId,@PathVariable Long congesId) {
		Personnel personnel= personnelRepository.findById(personnelId).get();
		Conges conges=congesRepository.findById(congesId).get();
		personnel.enrollConges(conges);
		return personnelRepository.save(personnel);
		
		}
	@PutMapping("/{personnelId}/grades/{gradesId}")
	Personnel assignGradesToPersonnel(@PathVariable Long personnelId,@PathVariable Long gradesId) {
		Personnel personnel= personnelRepository.findById(personnelId).get();
		Grades grades=gradesRepository.findById(gradesId).get();
		personnel.assignGrades(grades);
		return personnelRepository.save(personnel);
		
		}
	@PutMapping("/{personnelId}/fonction/{fonctionId}")
	Personnel assignFonctionToPersonnel(@PathVariable Long personnelId,@PathVariable Long fonctionId) {
		Personnel personnel= personnelRepository.findById(personnelId).get();
		Fonction fonction=fonctionRepository.findById(fonctionId).get();
		personnel.assignFonction(fonction);
		return personnelRepository.save(personnel);
		
		}
	@PutMapping("/{personnelId}/diplomes/{diplomeId}")
	Personnel assignDiplomeToPersonnel(@PathVariable Long personnelId,@PathVariable Long diplomeId) {
		Personnel personnel= personnelRepository.findById(personnelId).get();
		Diplome diplome=diplomeRepository.findById(diplomeId).get();
		personnel.assignDiplome(diplome);
		return personnelRepository.save(personnel);
		
		}
	@PutMapping("/{personnelId}/mutuelles/{mutuelleId}")
	Personnel assignMutuelleToPersonnel(@PathVariable Long personnelId,@PathVariable Long mutuelleId) {
		Personnel personnel= personnelRepository.findById(personnelId).get();
		Mutuelle mutuelle=mutuelleRepository.findById(mutuelleId).get();
		personnel.assignMutuelle(mutuelle);
		return personnelRepository.save(personnel);
		
		}
	@PutMapping("/{personnelId}/divisions/{divisionId}")
	Personnel assignDivisionToPersonnel(@PathVariable Long personnelId,@PathVariable Long divisionId) {
		Personnel personnel= personnelRepository.findById(personnelId).get();
		Division division=divisionRepository.findById(divisionId).get();
		personnel.assignDivision(division);
		return personnelRepository.save(personnel);
		
		}
	@PutMapping("/{personnelId}/conjoints/{conjointId}")
	Personnel assignConjointToPersonnel(@PathVariable Long personnelId,@PathVariable Long conjointId) {
		Personnel personnel= personnelRepository.findById(personnelId).get();
		Conjoint conjoint=conjointRepository.findById(conjointId).get();
		personnel.assignConjoint(conjoint);
		return personnelRepository.save(personnel);
		
		}
	
	
	
}

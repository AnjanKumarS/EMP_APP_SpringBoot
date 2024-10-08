package org.jsp.emp.controller;

import java.util.List;

import org.jsp.emp.entity.Education;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.jsp.emp.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education")
public class EducationController {
	
	@Autowired
	EducationService service;
	
	@PostMapping
	public ResponseStructure<Education> saveEducation(@RequestBody Education education){
		return service.saveEducation(education);
	}
	
	@PutMapping
	public ResponseStructure<Education> updateEducation(@RequestBody Education education){
		return service.updateEducation(education);
	}
	
	@GetMapping("/{id}")
	public ResponseStructure<Education> findEducationById(@RequestParam int id){
		return service.findEducationById(id);
	}
	
	@GetMapping
	public ResponseStructure<List<Education>> findAllEducation(){
		return service.findAllEducation();
	}
	
	@DeleteMapping("/{id}")
	public ResponseStructure<String> deleteEducationById(@RequestParam int id){
		return service.deleteEducationById(id);
	}
}

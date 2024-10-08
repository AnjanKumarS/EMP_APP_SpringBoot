package org.jsp.emp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.dao.EducationDAO;
import org.jsp.emp.entity.Education;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class EducationService {

	@Autowired
	EducationDAO dao;
	
	public ResponseStructure<Education> saveEducation(Education education) {
		education = dao.saveEducation(education);
		ResponseStructure<Education> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Education Saved SucessFully");
		structure.setBody(education);
		return structure;
	}

	public ResponseStructure<Education> updateEducation(Education education) {
		education = dao.updateEducation(education);
		ResponseStructure<Education> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Education Updated SucessFully");
		structure.setBody(education);
		return structure;
	}

	public ResponseStructure<Education> findEducationById(int id) {
		Optional<Education> op = dao.findEducationById(id);
		ResponseStructure<Education> structure = new ResponseStructure<>();
		if(op.isEmpty()) {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Education id not found");
			structure.setBody(null);
		}
		Education e = op.get();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Education found Sucessfully");
		structure.setBody(e);
		return structure;
	}

	public ResponseStructure<List<Education>> findAllEducation() {
		List<Education> op = dao.findAllEducation();
		ResponseStructure<List<Education>> structure = new ResponseStructure<>();
		if(op.isEmpty()) {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Education id not found");
			structure.setBody(null);
		}
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Education found Sucessfully");
		structure.setBody(op);
		return structure;
	}

	public ResponseStructure<String> deleteEducationById(int id) {
		Optional<Education> op = dao.findEducationById(id);
		ResponseStructure<Education> structure = new ResponseStructure<>();
		if(op.isEmpty()) {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Education not found");
			structure.setBody(null);
		}
		dao.deleteEducationById(id);
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Education found Sucessfully");
		structure.setBody(null);
		return null;
	}
	
	
}

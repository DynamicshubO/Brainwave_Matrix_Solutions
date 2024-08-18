package com.example.Hospital.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hospital.Management.System.Entity.Patient;
import com.example.Hospital.Management.System.Service.PatientService;

@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	private PatientService service;
	
	@PostMapping("/savePatient")
	public Patient registerPatientController(@RequestBody Patient patient) {
		return service.createPatient(patient);
	}
	
	@GetMapping("/displayPatients")
	public List<Patient> getPatientList(){
		return service.getAllPatients();
		
	}
	
	@GetMapping("/findById/{id}")
	public Patient getPatientById(@PathVariable long id) {
		return service.getPatientById(id);
	}
	
	@GetMapping("/findByPhnNumber/{PhnNumber}")
	public Patient getPatientByPhnNumber(@PathVariable String PhnNumber) {
		return service.getPatientByPhnNumber(PhnNumber);
	}
	
}

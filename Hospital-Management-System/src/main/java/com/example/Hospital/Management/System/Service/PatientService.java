package com.example.Hospital.Management.System.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.Hospital.Management.System.Entity.Patient;
import com.example.Hospital.Management.System.Repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repo;
	
	public Patient createPatient(Patient patient) {
		return repo.save(patient);
	}
	
	public List<Patient> getAllPatients() {
		return repo.findAll();
	}
	
	public Patient getPatientById(long id) {
		return repo.findByid(id);
	}
	
	public Patient getPatientByPhnNumber(String phnNumber) {
		return repo.findByPhnumber(phnNumber);
	}
}

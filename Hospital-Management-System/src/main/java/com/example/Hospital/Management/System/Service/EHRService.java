package com.example.Hospital.Management.System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hospital.Management.System.Entity.EHR;
import com.example.Hospital.Management.System.Repository.EHRRepository;

@Service
public class EHRService {
	

	 @Autowired
	 private EHRRepository repo;

	 
	 public EHR addHealthRecord(EHR healthRecord) {
		 return repo.save(healthRecord);
	 }

	    
	 public List<EHR> getHealthRecordsByPatient(Long patientId) {
		 return repo.findByPatientId(patientId);
	 }
	
}

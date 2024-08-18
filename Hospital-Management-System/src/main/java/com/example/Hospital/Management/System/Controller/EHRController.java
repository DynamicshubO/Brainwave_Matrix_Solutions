package com.example.Hospital.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hospital.Management.System.Entity.EHR;
import com.example.Hospital.Management.System.Service.EHRService;

@RestController
public class EHRController {

	@Autowired
	private EHRService service;
	
	@PostMapping("/saverecord")
    public EHR saveHealthRecord(@RequestBody EHR healthRecord) {
        EHR savedRecord = service.addHealthRecord(healthRecord);
        return savedRecord;
    }

    @GetMapping("/patient/{patientId}")
    public List<EHR> getHealthRecordsByPatient(@PathVariable Long patientId) {
        List<EHR> records = service.getHealthRecordsByPatient(patientId);
        return records;
    }
	
}

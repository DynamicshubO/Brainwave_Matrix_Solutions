package com.example.Hospital.Management.System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hospital.Management.System.Entity.MedicalSupply;
import com.example.Hospital.Management.System.Repository.MedicalSupplyRepository;

@Service
public class MedicalSupplyService {

	@Autowired
	private MedicalSupplyRepository repo;
	
	public MedicalSupply addSupply(MedicalSupply medicalSupply) {
        return repo.save(medicalSupply);
    }

    
    public List<MedicalSupply> getSupplies() {
        return repo.findAll();
    }

    
    public List<MedicalSupply> getExpiringSupplies(String expiryDate) {
        return repo.findByExpiryDateBefore(expiryDate);
    }
	
}

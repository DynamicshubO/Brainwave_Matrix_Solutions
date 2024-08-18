package com.example.Hospital.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hospital.Management.System.Entity.MedicalSupply;
import com.example.Hospital.Management.System.Service.MedicalSupplyService;

@RestController
public class MedicalSupplyController {

	@Autowired
	private MedicalSupplyService service;
	
	 @PostMapping("/addSupply")
	    public MedicalSupply addSupply(@RequestBody MedicalSupply medicalSupply) {
	        MedicalSupply savedSupply = service.addSupply(medicalSupply);
	        return savedSupply;
	    }

	    @GetMapping("/getall")
	    public List<MedicalSupply> getAllSupplies() {
	        List<MedicalSupply> supplies = service.getSupplies();
	        return supplies;
	    }

	    @GetMapping("/expiringsupply")
	    public List<MedicalSupply> getExpiringSupplies(@RequestBody String date) {
	        List<MedicalSupply> expiringSupplies = service.getExpiringSupplies(date);
	        return expiringSupplies;
	    }
	
	
}

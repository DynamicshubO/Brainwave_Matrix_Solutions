package com.example.Hospital.Management.System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hospital.Management.System.Entity.BillingandInvoice;
import com.example.Hospital.Management.System.Repository.BillingandInvoiceRepository;

@Service
public class BillingandInvoiceService {

	
	@Autowired
	private BillingandInvoiceRepository repo;
	
	
	  
	public BillingandInvoice generateInvoice(BillingandInvoice invoice) {
		
		return repo.save(invoice);
	}

	    
	public List<BillingandInvoice> getInvoicesByPatient(Long patientId) {
		return repo.findByPatientId(patientId);
	}
	
}

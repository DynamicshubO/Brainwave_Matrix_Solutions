package com.example.Hospital.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hospital.Management.System.Entity.BillingandInvoice;
import com.example.Hospital.Management.System.Service.BillingandInvoiceService;

@RestController
@RequestMapping("/api")
public class BillingandInvoiceController {

	@Autowired
	private BillingandInvoiceService service;
	
	
	@PostMapping("/generate")
    public BillingandInvoice generateInvoice(@RequestBody BillingandInvoice invoice) {
        BillingandInvoice savedInvoice = service.generateInvoice(invoice);
        return savedInvoice;
    }

    @GetMapping("/patient/{patientId}")
    public List<BillingandInvoice> getInvoicesByPatient(@PathVariable Long patientId) {
        List<BillingandInvoice> invoices = service.getInvoicesByPatient(patientId);
        return invoices;
    }
}

package com.example.Hospital.Management.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hospital.Management.System.Entity.BillingandInvoice;

@Repository
public interface BillingandInvoiceRepository extends JpaRepository<BillingandInvoice, Long>{

	List<BillingandInvoice> findByPatientId(Long patientId);
}

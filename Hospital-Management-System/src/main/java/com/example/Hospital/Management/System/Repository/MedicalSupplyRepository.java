package com.example.Hospital.Management.System.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hospital.Management.System.Entity.MedicalSupply;

@Repository
public interface MedicalSupplyRepository extends JpaRepository<MedicalSupply, Long>{

	List<MedicalSupply> findByExpiryDateBefore(String expiryDate);
}

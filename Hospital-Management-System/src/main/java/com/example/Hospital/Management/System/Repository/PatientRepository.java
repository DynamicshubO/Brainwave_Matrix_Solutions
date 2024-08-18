package com.example.Hospital.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hospital.Management.System.Entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	
	public Patient findByPhnumber(String phnumber);
	public Patient findByid(long id);
}

package com.example.Hospital.Management.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hospital.Management.System.Entity.EHR;


@Repository
public interface EHRRepository extends JpaRepository<EHR, Long>{

	List<EHR> findByPatientId(Long patientId);

}

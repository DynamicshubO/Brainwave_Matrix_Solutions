package com.example.Hospital.Management.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hospital.Management.System.Entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	public List<Appointment> findByDoctorName(String doctorName);
	
	public Appointment getAppointmentById(long id);
}

package com.example.Hospital.Management.System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hospital.Management.System.Entity.Appointment;
import com.example.Hospital.Management.System.Repository.AppointmentRepository;


@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository repo;
	
	
	public Appointment saveAppointmentService(Appointment appointment) {
		
		return repo.save(appointment);
	}
	
	public List<Appointment> getAllAppointmentService() {
		return repo.findAll();
	}
	
	public List<Appointment> findByDoctorNameService(String doctorName) {
		return repo.findByDoctorName(doctorName);
	}
	
	public Appointment reschedulingAppointment(long id, String newDate) {
		
		try {
			Appointment appointment = repo.getAppointmentById(id);
			if(appointment!= null) {
				appointment.getDate();
				appointment.setDate(newDate);
				saveAppointmentService(appointment);
			}
		} catch (Exception e) {
			System.out.println("Appointment not present");
			// TODO: handle exception
		}
		return null;
		
	}
	
	 public void cancleAppointment(long id) {
		 Appointment appointment = repo.getAppointmentById(id);
		 
		 repo.delete(appointment);
     }
	
	
}

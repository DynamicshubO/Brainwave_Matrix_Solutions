package com.example.Hospital.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.Hospital.Management.System.Entity.Appointment;
import com.example.Hospital.Management.System.Service.AppointmentService;

@RestController
@RequestMapping("/api")
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	@PostMapping("/saveAppointment")
	public Appointment saveAppointment(@RequestBody Appointment appointment) {
		return service.saveAppointmentService(appointment);
	}
	
	@GetMapping("/Appointments")
	public List<Appointment> displayAllAppointments(){
		return service.getAllAppointmentService();
	}
	
	@GetMapping("/getAppointmentByDocName/{doctorName}")
	public List<Appointment> getAppointmentByName(@PathVariable String doctorName) {
		return service.findByDoctorNameService(doctorName);
	}
	
	@PutMapping("/rescheduleDate/{id}")
	public Appointment reschedulingAppointment(@PathVariable long id, @RequestBody String newDate) {
		return service.reschedulingAppointment(id, newDate);
	}
	
	@DeleteMapping("/cancel/{id}")
	public void cancelAppointment(@PathVariable long id) {
		service.cancleAppointment(id);
	}
	
	
}

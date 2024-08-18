package com.example.Hospital.Management.System.Controller;

import com.example.Hospital.Management.System.Entity.Appointment;
import com.example.Hospital.Management.System.Entity.Patient;


public class AppointmentRequest {

	private Appointment appointment;
    private Patient patient;

    // Getters and Setters
    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
	
}

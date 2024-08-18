package com.example.Hospital.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hospital.Management.System.Entity.Staff;
import com.example.Hospital.Management.System.Service.StaffService;

@RestController
@RequestMapping("/api")
public class StaffController {

	@Autowired
	private StaffService service;
	
	@GetMapping("/saveStaff")
	public Staff saveStaffController(@RequestBody Staff staff) {
		return service.saveStaffService(staff);
	}
	
	@GetMapping("/getAll")
	public List<Staff> getAllStaffcontroller() {
		return service.getAllStaffService();

	}
	
	@GetMapping("/findByDepartment/{department}")
	public List<Staff> findStaffByDepartment(@PathVariable String department){
		return service.getStaffByDepartmentService(department);
	}
 	
	@PutMapping("/updateStaffContact/{id}")
	public Staff updateStaffContactNumber(@PathVariable long id, @RequestBody String contactNumber) {
		return service.updateStaffContactNumberService(id, contactNumber);
	}
	
	@DeleteMapping("/removeStaff/{id}")
	public String removeStaffByIdController(@PathVariable long id) {
		service.removeStaff(id);
		return "Staff removed";
	}
}

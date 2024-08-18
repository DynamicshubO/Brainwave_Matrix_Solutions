package com.example.Hospital.Management.System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hospital.Management.System.Entity.Staff;
import com.example.Hospital.Management.System.Repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepo;
	
	public Staff saveStaffService(Staff staff) {
		return staffRepo.save(staff);
	}
	
	public List<Staff> getAllStaffService() {
        return staffRepo.findAll();
    }

    
    public List<Staff> getStaffByDepartmentService(String department) {
        return staffRepo.findByDepartment(department);
    }
	
    public Staff updateStaffContactNumberService(long id, String newContactNumber) {
    	Staff staff = staffRepo.getStaffById(id);
    	
    	staff.getContactNumber();
    	staff.setContactNumber(newContactNumber);
    	
    	return saveStaffService(staff);
    }
    
    public String removeStaff(long id) {
    	Staff staff = staffRepo.getStaffById(id);
    	if(staff!=null) {
    		staffRepo.delete(staff);
    		return "Staff deleted";
    	}else {
    		return "Staff not found";
    	}
    }
}

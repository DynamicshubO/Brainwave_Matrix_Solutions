package com.example.Hospital.Management.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hospital.Management.System.Entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>{
	
	
	List<Staff> findByDepartment(String department);
	Staff getStaffById(long id);
}

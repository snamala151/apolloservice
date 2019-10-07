package com.jhansun.sampleapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jhansun.sampleapp.model.Department;
import com.jhansun.sampleapp.model.Message;
import com.jhansun.sampleapp.model.ProductCategory;
import com.jhansun.sampleapp.repository.DepartmentRespository;

@RequestMapping("/api/departments")
@RestController
public class DepartmentResource {

	@Autowired
	DepartmentRespository departmentRepository;

	@RequestMapping(value = "/", method = RequestMethod.POST)
    public  ResponseEntity<Message> addDepartment(@RequestBody Department department) {
		Department createdOne = departmentRepository.save(department);
    	Message msg = null;
    	if(createdOne.getId()>0){
    		msg = new Message("SUCCESS", "Department added successfully");
    		return new ResponseEntity<Message>(msg, HttpStatus.OK);
    	}
    	msg = new Message("ERROR", "There was an error while adding a product");
    	return new ResponseEntity<Message>(msg, HttpStatus.SERVICE_UNAVAILABLE);
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Department> getAllProducts() {
    	return departmentRepository.findAll();
    }
	
	@RequestMapping(value = "/{deptId}", method = RequestMethod.GET)
    public Department getAllProduct(@PathVariable("deptId") Integer deptId) {
    	return departmentRepository.findOne(deptId);
    } 
	
	@RequestMapping(value = "/{deptId}", method = RequestMethod.GET)
    public  List<Department> deleteDepartment(@PathVariable("deptId") Integer deptId) {
    	 departmentRepository.delete(deptId);
    	 return departmentRepository.findAll();
    }  
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
    public  ResponseEntity<Message> updateDeparment(@RequestBody Department department) {
		Department createdOne = departmentRepository.save(department);
    	Message msg = null;
    	if(createdOne.getId()>0){
    		msg = new Message("SUCCESS", "Department added successfully");
    		return new ResponseEntity<Message>(msg, HttpStatus.OK);
    	}
    	msg = new Message("ERROR", "There was an error while adding a product");
    	return new ResponseEntity<Message>(msg, HttpStatus.SERVICE_UNAVAILABLE);
    }

}

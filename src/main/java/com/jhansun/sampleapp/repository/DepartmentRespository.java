package com.jhansun.sampleapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jhansun.sampleapp.model.Department;

public interface DepartmentRespository extends CrudRepository<Department, Integer> {
	List<Department> findAll();
}

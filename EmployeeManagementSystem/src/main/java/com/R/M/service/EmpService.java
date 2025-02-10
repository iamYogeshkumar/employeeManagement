package com.R.M.service;

import java.util.List;

import com.R.M.entity.Employee;

public interface EmpService {

	public Employee saveEmp(Employee e);
	
	public List<Employee> getAllEmp();
	
	public Employee getEmpById(int id);
	
	public Boolean deleteEmp(int id);
}

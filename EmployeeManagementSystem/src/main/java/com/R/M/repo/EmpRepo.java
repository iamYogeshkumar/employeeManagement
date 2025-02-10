package com.R.M.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.R.M.entity.Employee;

public interface EmpRepo  extends JpaRepository<Employee, Integer>{

}

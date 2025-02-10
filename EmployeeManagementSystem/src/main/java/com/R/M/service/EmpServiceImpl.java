package com.R.M.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.R.M.entity.Employee;
import com.R.M.repo.EmpRepo;

import jakarta.servlet.http.HttpSession;
@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepo empRepo;

	@Override
	public Employee saveEmp(Employee e) {
         Employee newEmp = empRepo.save(e);
		return newEmp;
	}

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).get();
	}

	@Override
	public Boolean deleteEmp(int id) {
         Optional<Employee> e = empRepo.findById(id);
         if (e.isPresent()) {
			empRepo.delete(e.get());
			return true;
		}
		return false;
	}
	
	public void removeSession() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();
	}


}

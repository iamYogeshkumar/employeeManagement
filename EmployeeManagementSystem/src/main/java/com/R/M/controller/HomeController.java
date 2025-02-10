package com.R.M.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.R.M.entity.Employee;
import com.R.M.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private EmpService empServiceImpl;
	
	@GetMapping("/")
	public String index(Model m) {
		List<Employee> allEmp = empServiceImpl.getAllEmp();
		m.addAttribute("lists", allEmp);
		return "index";
	}
	@GetMapping("/loadEmpSave")
	public String loadEmpSave(Model m) {
		return "empSave";
	}
	
	@GetMapping("/editEmp/{id}")
	public String editEmp(@PathVariable("id") int id,Model m) {
		Employee empById = empServiceImpl.getEmpById(id);
		m.addAttribute("emp",empById);
		return "edit_Emp";
	}
	
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute("emp") Employee emp,HttpSession httpSession) {
		System.out.println(emp);
		Employee saveEmp = empServiceImpl.saveEmp(emp);
		if(saveEmp!=null) {
			httpSession.setAttribute("msg", "Register successfully");
		}else
			httpSession.setAttribute("msg", "Not Register");
		return "redirect:/loadEmpSave";
	}
	
	@PostMapping("/updateEmp")
	public String update(@ModelAttribute("emp") Employee emp,HttpSession httpSession) {
		System.out.println(emp);
		Employee saveEmp = empServiceImpl.saveEmp(emp);
		if(saveEmp!=null) {
			httpSession.setAttribute("msg", "update successfully");
		}else
			httpSession.setAttribute("msg", "Not updated");
		return "redirect:/";
	}
	
	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable("id") int id) {
		Boolean emp = empServiceImpl.deleteEmp(id);
		if(emp) {
			return "redirect:/";
		}
		else {
			return "";
		}
		
	}
	
	
}

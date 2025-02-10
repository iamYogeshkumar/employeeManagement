package com.R.M;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.R.M.binding.UserForm;

@Controller
public class UserFormController {

	@GetMapping("/registerForm")
	private String registrationForm(Model m) {
		m.addAttribute("userForm", new UserForm());
		List<String> list = List.of("Developer","Tester","QT");
		m.addAttribute("listsProfession", list);
		return "registerForm";
	}
	
	@PostMapping("register/save")
	public String saveForm(Model m,@ModelAttribute("userData") UserForm userForm) {
		m.addAttribute("userForm", userForm);
		return "register-save";
	}
}

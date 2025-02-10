package com.R.M;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index(Model m) {
		User u1=new User(1, "Yogesh", "nagpur");
		User u2=new User(1, "Deepak", "Siwan");
		m.addAttribute("user", u2);
		m.addAttribute("today", new Date());
		m.addAttribute("status", true);
		m.addAttribute("msg", "Yogesh becoder");
		return "index";
	}
	@GetMapping("/profile")
	public String profile(Model m) {
		User u1=new User(1, "Yogesh", "Syriya");
		User u2=new User(2, "Deepak", "nepal");
		User u3=new User(3, "Honey", "India");
		User u4=new User(4, "Lucky", "UK");
		User u5=new User(5, "Rani", "Bhutan");
		List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
		m.addAttribute("Lists", list);
		m.addAttribute("user", u1);
		
		return "profile";
	}
}

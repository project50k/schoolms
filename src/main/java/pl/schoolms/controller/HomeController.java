package pl.schoolms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.schoolms.bean.RoleChecker;

@Controller
public class HomeController {

	@GetMapping({"", "home"})
	public String home() {
		return "home/home";
	}
	

	@ModelAttribute
	public static void checkRole() {
	RoleChecker.check();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}




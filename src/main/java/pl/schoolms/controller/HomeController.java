package pl.schoolms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.schoolms.bean.SessionManager;
import pl.schoolms.entity.User;

@Controller
public class HomeController {

	@GetMapping({"", "home"})
	public String home() {
		return "home";
	}
	
	@GetMapping({"loghome"})
	public String loghome() {
		return "loghome";
	}
	
	@ModelAttribute
	public static void checkRole() {
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		if (u != null) {
				if (u.getRoles().getName().equals("adminRole")) {
					s.setAttribute("role", "adminRole");
				} else if (u.getRoles().getName().equals("teacherRole")) {
					s.setAttribute("role", "teacherRole");
				} else if (u.getRoles().getName().equals("studentRole")) {
					s.setAttribute("role", "studentRole");
				}
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}




package pl.schoolms.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.schoolms.bean.LoginData;
import pl.schoolms.bean.RoleChecker;
import pl.schoolms.bean.SessionManager;
import pl.schoolms.entity.User;
import pl.schoolms.repository.DetailStudentRepository;
import pl.schoolms.repository.RoleRepository;
import pl.schoolms.repository.SchoolgroupRepository;
import pl.schoolms.repository.UserRepository;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	DetailStudentRepository detailsRepo;

	@Autowired
	SchoolgroupRepository schoolgroupRepo;
	

	@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("user", new User());
		return "/user/register";
	}

	@PostMapping("/register")
	public String registerPost(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/user/register";
		} else {
			this.userRepo.save(user);
			return "redirect:/home";
		}
	}

	@GetMapping("/login")
	public String login(Model m) {
		m.addAttribute("loginData", new LoginData());
		return "user/login";
	}

	@PostMapping("/login")
	public String loginPost(@ModelAttribute LoginData loginData, Model m, RedirectAttributes ra) {
		User u = this.userRepo.findOneByEmail(loginData.getEmail());
		if (u != null && u.isPasswordCorrect(loginData.getPassword())) {
			HttpSession s = SessionManager.session();
			s.setAttribute("user", u);
			ra.addFlashAttribute("msg", "Jesteś zalogowany");
			return "redirect:/home";
		}
		m.addAttribute("msg", "Wprowadz poprawne dane");
		return "user/login";
	}

	@GetMapping("/logout")
	public String logout(Model m) {
		m.addAttribute("loginData", new LoginData());
		HttpSession s = SessionManager.session();
		s.invalidate();
		return "redirect:/home";
	}

	
	@ModelAttribute
	public static void checkRole() {
	RoleChecker.check();
	}
	
}
	
	


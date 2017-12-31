package pl.schoolms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.schoolms.bean.LoginData;
import pl.schoolms.bean.SessionManager;
import pl.schoolms.entity.Role;
import pl.schoolms.entity.User;
import pl.schoolms.repository.RoleRepository;
import pl.schoolms.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UserRepository userRepo;

	// ----------------------------------- TEST --------------------------------

	@GetMapping("test")
	@ResponseBody
	public String test() {
		return "TEST";
	}

	@GetMapping("test2")
	@ResponseBody
	public String test2() {
		return "TEST2";
	}

	@GetMapping("test3site")
	public String test3site() {
		return "test3site";
	}

	// ----------------------------------- TEST --------------------------------

	@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registerPost(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/register";
		} else {
			this.userRepo.save(user);
			return "redirect:/";
		}
	}

	@GetMapping("/login")
	public String login(Model m) {
		m.addAttribute("loginData", new LoginData());
		return "login";
	}

	@PostMapping("/login")
	public String loginPost(@ModelAttribute LoginData loginData, Model m, RedirectAttributes ra) {
		User u = this.userRepo.findOneByEmail(loginData.getEmail());
		if (u != null && u.isPasswordCorrect(loginData.getPassword())) {
			HttpSession s = SessionManager.session();
			s.setAttribute("user", u);
			ra.addFlashAttribute("msg", "Jesteś zalogowany");
			return "redirect:/";
		}
		m.addAttribute("msg", "Wprowadz poprawne dane");
		return "login";
	}

	@GetMapping("/logout")
	public String logout(Model m) {
		m.addAttribute("loginData", new LoginData());
		HttpSession s = SessionManager.session();
		s.invalidate();
		return "redirect:/";
	}


	
	@GetMapping("/allStudents")
	public String allStudents() {
		return "list_student";
	}
	
	@GetMapping("/allTeachers")
	public String allTeachers() {
		return "list_teacher";
	}
	
	
	@ModelAttribute("allStudents")
	public List<User> getAvailableStudents() {
		return this.userRepo.findByRolesId(3l);
	}
	
	@ModelAttribute("allTeachers")
	public List<User> getAvailableTeachers() {
		return this.userRepo.findByRolesId(2l);
	}
	
	
	@GetMapping("/addStudents")
	public String addStudentFormGet(Model m) {
		User tmpUser = new User();
		m.addAttribute("student", tmpUser);
		return "add_student";
	}
	
	@PostMapping("/addStudents")
	public String addStudentFormPost(@Valid @ModelAttribute User tmpUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "add_student";
		} else {
			Role tmpRole = this.roleRepo.findById(3l);
			tmpUser.setRoles(tmpRole);
			tmpRole.getUsers().add(tmpUser);
			this.roleRepo.save(tmpUser.getRoles());
			this.userRepo.save(tmpUser);
			return "redirect:/allStudents";
		}
	}


	
	

	
//	
//	@ModelAttribute
//	public static void checkRole() {
//		HttpSession s = SessionManager.session();
//		User u = (User) s.getAttribute("user");
//		if (u != null) {
//				if (u.getRoles().getName().equals("adminRole")) {
//					s.setAttribute("role", "adminRole");
//				} else if (u.getRoles().getName().equals("teacherRole")) {
//					s.setAttribute("role", "teacherRole");
//				} else if (u.getRoles().getName().equals("studentRole")) {
//					s.setAttribute("role", "studentRole");
//				}
//			}
//		}

	
//	@ModelAttribute("allUsers")
//	public List<User> getAvailableUsers() {
//		HttpSession s = SessionManager.session();
//		User u = (User) s.getAttribute("user");
//		List<User> tmpUserList = new ArrayList<User>();
//		if (u != null) {
//				if (u.getRoles().getName().equals("adminRole")) {
//					tmpUserList.addAll(this.userRepo.findByRolesId(1l));
//					tmpUserList.addAll(this.userRepo.findByRolesId(2l));
//					tmpUserList.addAll(this.userRepo.findByRolesId(3l));
//					return tmpUserList;
//				} else if (u.getRoles().getName().equals("teacherRole")) {
//					tmpUserList.addAll(this.userRepo.findByRolesId(2l));
//					tmpUserList.addAll(this.userRepo.findByRolesId(3l));
//					return tmpUserList;
//				} else if (u.getRoles().getName().equals("studentRole")) {
//					return this.userRepo.findByRolesId(3l);
//				}
//			}
//		return null;
//	}
	

	
}
	
	


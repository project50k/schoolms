//package pl.schoolms.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import pl.schoolms.bean.LoginData;
//import pl.schoolms.bean.SessionManager;
//import pl.schoolms.entity.User;
//import pl.schoolms.repository.RoleRepository;
//import pl.schoolms.repository.UserRepository;
//
//@Controller 
//@RequestMapping("admin")
//public class AdminController {
//
//	@Autowired
//	UserRepository userRepo;
//	
//	@Autowired
//	RoleRepository roleRepo;
//
//
//	@GetMapping("/register")
//	public String register(Model m) {
//		m.addAttribute("user", new User());
//		return "register";
//	}
//
//	@PostMapping("/register")
//	public String registerPost(@Valid @ModelAttribute User user, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			return "redirect:/register";
//		} else {
//			this.userRepo.save(user);
//			return "redirect:/";
//		}
//	}
//
//	@GetMapping("/login")
//	public String login(Model m) {
//		m.addAttribute("loginData", new LoginData());
//		return "login";
//	}
//
//	@PostMapping("/login")
//	public String loginPost(@ModelAttribute LoginData loginData, Model m, RedirectAttributes ra) {
//		User u = this.userRepo.findOneByEmail(loginData.getEmail());
//		if (u != null && u.isPasswordCorrect(loginData.getPassword())) {
//			HttpSession s = SessionManager.session();
//			s.setAttribute("user", u);
//			ra.addFlashAttribute("msg", "Jesteś zalogowany");
//			return "redirect:/";
//		}
//		m.addAttribute("msg", "Wprowadz poprawne dane");
//		return "login";
//	}
//
//	@GetMapping("/logout")
//	public String logout(Model m) {
//		m.addAttribute("loginData", new LoginData());
//		HttpSession s = SessionManager.session();
//		s.invalidate();
//		return "redirect:/";
//	}
//
//	
//	
//
//	
//	
//	
//	@GetMapping("/allStudents")
//	public String allUsers() {
//		return "student_list";
//	}
//	
//	@GetMapping("/allTeachers")
//	public String allTeachers() {
//		return "teacher_list";
//	}
//	
//	
//	@ModelAttribute("allStudents")
//	public List<User> getAvailableStudents() {
//		return this.userRepo.findByRolesId(3l);
//	}
//	
//	@ModelAttribute("allTeachers")
//	public List<User> getAvailableTeachers() {
//		return this.userRepo.findByRolesId(2l);
//	}
//	
//	
//	
////	@ModelAttribute
////	public static void checkRole() {
////		HttpSession s = SessionManager.session();
////		User u = (User) s.getAttribute("user");
////		if (u != null) {
////			if (u.getRoles().getName().equals("adminRole")) {
////				s.setAttribute("role", "adminRole");
////			} else if (u.getRoles().getName().equals("teacherRole")) {
////				s.setAttribute("role", "teacherRole");
////			} else if (u.getRoles().getName().equals("studentRole")) {
////				s.setAttribute("role", "studentRole");
////			}
////		}
////	}
//	
//	// DO WYJASNIENIA - ZWRACA PRAWIDŁOWO LISTĘ ALE NIE WCZYTUJE SIĘ MENU DLA ZALOGOWANEGO KONTA ORAZ PLIKI ZE STYLAMI
////		@GetMapping("/all/{role}")
////		public String all(@PathVariable String role, HttpServletRequest rq) {
////			if (role.equals("teachers")) {
////				rq.setAttribute("list", this.userRepo.findByRolesId(2l));
////				return "student_list";
////			}
////			if (role.equals("students")) {
////				rq.setAttribute("list", this.userRepo.findByRolesId(3l));
////				return "student_list";
////			}
////			return "home";
////		}
//	
//	
//	
//	
//
//	
//}
//	
//	
//

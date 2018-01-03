package pl.schoolms.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.schoolms.bean.RoleChecker;
import pl.schoolms.entity.DetailStudent;
import pl.schoolms.entity.Role;
import pl.schoolms.entity.User;
import pl.schoolms.repository.DetailStudentRepository;
import pl.schoolms.repository.RoleRepository;
import pl.schoolms.repository.SchoolgroupRepository;
import pl.schoolms.repository.UserRepository;

@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	DetailStudentRepository detailsRepo;

	@Autowired
	SchoolgroupRepository schoolgroupRepo;
	
	
	// ----------------------------- ALL --------------------------------------------------------------------------
	
	@GetMapping("/all")
	public String all() {
		return "student/list";
	}

	
	// ----------------------------- ADD --------------------------------------------------------------------------
	
	@GetMapping("/add")
	public String addFormGet(Model m) {
		User tmpUser = new User();
		DetailStudent tmpDetails = new DetailStudent();
		tmpUser.setDetails(tmpDetails);
		m.addAttribute("user", tmpUser);
		return "student/add";
	}
	
	@PostMapping("/add")
	public String addFormPost(@Valid @ModelAttribute User tmpUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "student/add";
		} else {
			Role tmpRole = this.roleRepo.findById(3l); // Check role
			tmpUser.setRoles(tmpRole);
			this.userRepo.save(tmpUser);
			return "redirect:/student/all";
		}
	}
	
	// ----------------------------- EDIT --------------------------------------------------------------------------
	
	@GetMapping("/{id}/edit")
	@Transactional
	public String editFormGet(@PathVariable long id,Model m) {
		User tmpUser = this.userRepo.findById(id);
		DetailStudent tmpDetail = this.detailsRepo.findById(tmpUser.getDetails().getId());
		tmpUser.setDetails(tmpDetail);
		m.addAttribute("user", tmpUser);
		return "student/add";
	}
	
	@PostMapping("/{id}/edit")
	public String editFormPost(@ModelAttribute User tmpUser) {
			Role tmpRole = this.roleRepo.findById(3l);// Check is it necessary
			tmpUser.setRoles(tmpRole);// Check is it necessary
			this.userRepo.save(tmpUser);
			return "redirect:/student/all";
	}

	// ----------------------------- DELETE --------------------------------------------------------------------------
	
	@GetMapping("/{id}/delete")
	public String deleteFormGet(@PathVariable long id, Model m) {
		User tmpUser = this.userRepo.findById(id);
		m.addAttribute("delUser", id);
		return "student/list";
	}
	
	@GetMapping("/{id}/delConfirm")
	public String deleteFormGetConfirm(@PathVariable long id, Model m) {
		this.userRepo.delete(id);
		m.addAttribute("delUser", "0");
		return "redirect:/student/all";
	}
	
	@GetMapping("/{id}/delReject")
	public String deleteFormGetReject(@PathVariable long id, Model m) {
		m.addAttribute("delUser", "0");
		return "redirect:/student/all";
	}
	
	
	// ----------------------------- MODEL ATTRIBUTE  --------------------------------------------------------------------------
		
	@ModelAttribute("availableStudents")
	public List<User> getAvailableStudents() {
		return this.userRepo.findByRolesId(3l);
	}

	@ModelAttribute
	public static void checkRole() {
	RoleChecker.check();
	}	
	
	// --------------------------------------------------------- LIST ALL --------------------------------------------
	
//		@GetMapping("/allStudents")
//		public String allStudents() {
//			return "list_student";
//		}
//		
//		@GetMapping("/allTeachers")
//		public String allTeachers() {
//			return "list_teacher";
//		}
//		
//		@GetMapping("/allSchoolgroups")
//		public String allSchoolgroups() {
//			return "list_schoolgroup";
//		}
//		
//		@ModelAttribute("allStudents")
//		public List<User> getAvailableStudents() {
//			return this.userRepo.findByRolesId(3l);
//		}
//		
//		@ModelAttribute("allTeachers")
//		public List<User> getAvailableTeachers() {
//			return this.userRepo.findByRolesId(2l);
//		}
//		
//		@ModelAttribute("allSchoolgroups")
//		public List<Schoolgroup> getAvailableSchoolgroups() {
//			return this.schoolgroupRepo.findAll();
//		}
			
		
		// -------------------------------------------------------------------------------------------------------------------
		
		

		
		

		
	//	
//		@ModelAttribute
//		public static void checkRole() {
//			HttpSession s = SessionManager.session();
//			User u = (User) s.getAttribute("user");
//			if (u != null) {
//					if (u.getRoles().getName().equals("adminRole")) {
//						s.setAttribute("role", "adminRole");
//					} else if (u.getRoles().getName().equals("teacherRole")) {
//						s.setAttribute("role", "teacherRole");
//					} else if (u.getRoles().getName().equals("studentRole")) {
//						s.setAttribute("role", "studentRole");
//					}
//				}
//			}

		
//		@ModelAttribute("allUsers")
//		public List<User> getAvailableUsers() {
//			HttpSession s = SessionManager.session();
//			User u = (User) s.getAttribute("user");
//			List<User> tmpUserList = new ArrayList<User>();
//			if (u != null) {
//					if (u.getRoles().getName().equals("adminRole")) {
//						tmpUserList.addAll(this.userRepo.findByRolesId(1l));
//						tmpUserList.addAll(this.userRepo.findByRolesId(2l));
//						tmpUserList.addAll(this.userRepo.findByRolesId(3l));
//						return tmpUserList;
//					} else if (u.getRoles().getName().equals("teacherRole")) {
//						tmpUserList.addAll(this.userRepo.findByRolesId(2l));
//						tmpUserList.addAll(this.userRepo.findByRolesId(3l));
//						return tmpUserList;
//					} else if (u.getRoles().getName().equals("studentRole")) {
//						return this.userRepo.findByRolesId(3l);
//					}
//				}
//			return null;
//		}
		

//		@ModelAttribute
//		public static void checkRole() {
//			HttpSession s = SessionManager.session();
//			User u = (User) s.getAttribute("user");
//			if (u != null) {
//					if (u.getRoles().getName().equals("adminRole")) {
//						s.setAttribute("role", "adminRole");
//					} else if (u.getRoles().getName().equals("teacherRole")) {
//						s.setAttribute("role", "teacherRole");
//					} else if (u.getRoles().getName().equals("studentRole")) {
//						s.setAttribute("role", "studentRole");
//					}
//				}
//			}
	
	
	
	
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
	
	
	

	
}
	
	


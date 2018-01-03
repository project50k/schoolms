package pl.schoolms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.schoolms.entity.Role;
import pl.schoolms.entity.Schoolgroup;
import pl.schoolms.entity.User;
import pl.schoolms.repository.RoleRepository;
import pl.schoolms.repository.SchoolgroupRepository;
import pl.schoolms.repository.UserRepository;

@Controller
@RequestMapping("start")
public class StartController {

	@Autowired
	RoleRepository roleRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	SchoolgroupRepository schoolgroupRepo;
	
	@GetMapping("/addUsers")
	@ResponseBody
	public String addUsers() {
		User u1 = new User("admin", "admin@admin.pl");
		User u2 = new User("teacher", "teacher@teacher.pl");
		User u3 = new User("student", "student@student.pl");
		User u4 = new User("tytus", "tytus@tytus.pl");
		User u5 = new User("romek", "romek@romek.pl");
		User u6 = new User("atomek", "atomek@atomek.pl");
		this.userRepo.save(u1);
		this.userRepo.save(u2);
		this.userRepo.save(u3);
		this.userRepo.save(u4);
		this.userRepo.save(u5);
		this.userRepo.save(u6);
		return "New users added";
	}

	@GetMapping("/addRole")
	@ResponseBody
	public String addRole() {
		Role roleAdmin = new Role("adminRole");
		Role roleTeacher = new Role("teacherRole");
		Role roleStudent = new Role("studentRole");
		this.roleRepo.save(roleAdmin);
		this.roleRepo.save(roleTeacher);
		this.roleRepo.save(roleStudent);
		return "New role added";
	}

	@GetMapping("/addSchoolgroups")
	@ResponseBody
	public String addSchoolgroups() {
		Schoolgroup scg1 = new Schoolgroup("Grupa 1");
		Schoolgroup scg2 = new Schoolgroup("Grupa 2");
		this.schoolgroupRepo.save(scg1);
		this.schoolgroupRepo.save(scg2);		
		return "New schoolgroups added";
	}
	
	@GetMapping("/allUsers")
	@ResponseBody
	public String allUsers() {
		List<User> roles = this.userRepo.findAll();
		String html = "<html><body>";

		for (User u : roles) {
			html += u.toString() + "</br>";
		}
		html += "</body></html>";
		return html;
	}

	@GetMapping("/allRoles")
	@ResponseBody
	public String allRoles() {
		List<Role> roles = this.roleRepo.findAll();
		String html = "<html><body>";

		for (Role r : roles) {
			html += r.toString() + "</br>";
		}
		html += "</body></html>";
		return html;
	}

//	@GetMapping("/findRoleById")
//	@ResponseBody
//	public String findRoleById() {
//		Role role = this.roleRepo.findById(1l);
//		String html = "<html><body>";
//		html += role.toString() + "</br>";
//		html += "</body></html>";
//		return html;
//	}

	@GetMapping("/addRoleToUser/{roleid}/{userid}")
	@ResponseBody
	public String addRoleToUser(@PathVariable long roleid, @PathVariable long userid) {
		Role tmpRole = this.roleRepo.findById(roleid);
		User tmpUser = this.userRepo.findById(userid);
		tmpUser.setRoles(tmpRole);
		tmpRole.getUsers().add(tmpUser);
		this.userRepo.save(tmpUser);
		this.roleRepo.save(tmpRole);

		return "Role added to user";
	}

	@GetMapping("/addUserToSchoolGroup/{userid}/{schoolgroupid}")
	@ResponseBody
	public String addUserToSchoolGroup(@PathVariable long userid, @PathVariable long schoolgroupid) {
		User tmpUser = this.userRepo.findById(userid);
		Schoolgroup tmpSchoolGroup = this.schoolgroupRepo.findById(schoolgroupid);
		if (tmpUser.getRoles().getName().equals("studentRole")&& tmpSchoolGroup!=null) {
			tmpUser.getSchoolgroups().add(tmpSchoolGroup);
			tmpSchoolGroup.getUsers().add(tmpUser);
			this.userRepo.save(tmpUser);
			this.schoolgroupRepo.save(tmpSchoolGroup);
			return "User added to school group";
		}
		return "Houston, Huston We've got problems";
	}
	
	
//	@GetMapping("/checkRoleBody")
//	@ResponseBody
//	public String checkRoleBody() {
//		HttpSession s = SessionManager.session();
//		User u = (User) s.getAttribute("user");
//		if (u != null) {
//			String html = "<html><body>";
//			for (Role r : u.getRoles()) {
//				html += r.getName() + "</br>";
//			}
//			html += "</body></html>";
//			return html;
//		}
//		return "User hasn't got role";
//	}

//	@GetMapping("/isAdmin")
//	@ResponseBody
//	public String isAdmin() {
//		HttpSession s = SessionManager.session();
//		User u = (User) s.getAttribute("user");
//		if (u != null) {
//			String html = "<html><body>";
//			for (Role r : u.getRoles()) {
//				if (r.getName().equals("adminRole")) {
//					html += "YES" + "</br>";
//				} else {
//					html += "NO" + "</br>";
//				}
//			}
//			html += "</body></html>";
//			return html;
//		}
//
//		return "User hasn't got role";
//	}

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

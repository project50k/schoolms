package pl.schoolms.bean;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import pl.schoolms.entity.User;

@Component
public class RoleChecker {

	public static void check() {
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		if (u != null && u.getRoles() != null) {
			if (u.getRoles().getName().equals("adminRole")) {
				s.setAttribute("role", "adminRole");
			} else if (u.getRoles().getName().equals("teacherRole")) {
				s.setAttribute("role", "teacherRole");
			} else if (u.getRoles().getName().equals("studentRole")) {
				s.setAttribute("role", "studentRole");
			}
		} else {
			s.setAttribute("role", "unknown");
		}
	}

}

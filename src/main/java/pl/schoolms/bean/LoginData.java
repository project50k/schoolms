package pl.schoolms.bean;

import org.springframework.stereotype.Component;

@Component //Zlecamy zarządzanie i tworzenie Springowi
public class LoginData {

	private String email;
	private String password;

	public LoginData() {
		super();
	}

	public LoginData(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

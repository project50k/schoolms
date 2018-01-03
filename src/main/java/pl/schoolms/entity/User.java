package pl.schoolms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long id;
	@NotEmpty
	private String password;
	@NotNull
	private boolean enabled;
	@NotEmpty
	@Email
	@Column(unique = true)
	private String email;
	// ----------------------------------------------
	@ManyToOne(fetch = FetchType.EAGER)
	private Role roles;
	// ----------------------------------------------
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private DetailStudent details;
	// ----------------------------------------------
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_schoolgroup", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "schoolgroup_id") })
	private Set<Schoolgroup> schoolgroups = new HashSet<>();
	// ----------------------------------------------

	public User() {
		super();
	}

	public User(String password, boolean enabled, String email, Role roles, DetailStudent details,
			Set<Schoolgroup> schoolgroups) {
		super();
		this.password = password;
		this.enabled = enabled;
		this.email = email;
		this.roles = roles;
		this.details = details;
		this.schoolgroups = schoolgroups;
	}

	public User(String password, String email) {
		super();
		setPassword(password);
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public boolean isPasswordCorrect(String pwd) {
		return BCrypt.checkpw(pwd, this.password);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// --------------------------------------------------
	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	// --------------------------------------------------

	public DetailStudent getDetails() {
		return details;
	}

	public void setDetails(DetailStudent details) {
		this.details = details;
	}

	// --------------------------------------------------

	public Set<Schoolgroup> getSchoolgroups() {
		return schoolgroups;
	}

	public void setSchoolgroups(Set<Schoolgroup> schoolgroups) {
		this.schoolgroups = schoolgroups;
	}

	// --------------------------------------------------

}

package pl.schoolms.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "schoolgroup")
public class Schoolgroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long id;
	@NotEmpty
	@Column(unique = true)
	private String groupname;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "schoolgroups")
	private Set<User> users = new HashSet<>();

	public Schoolgroup() {
		super();
	}
	
	public Schoolgroup(String groupname) {
		super();
		this.groupname = groupname;
	}

	public Schoolgroup(String groupname, Set<User> users) {
		super();
		this.groupname = groupname;
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}

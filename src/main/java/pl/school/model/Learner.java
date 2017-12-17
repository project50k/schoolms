package pl.school.model;

public class Learner extends User{

	private int learnerId;
	
	public Learner (String firstName, String lastName, String login, String password) {
		super(firstName, lastName, login, password);
		this.learnerId = 0;
	}
	
	
}

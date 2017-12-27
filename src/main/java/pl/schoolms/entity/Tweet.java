package pl.schoolms.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min = 5, max = 50)
	private String title;
	@NotNull
	@Size(max = 160)
	private String tweet_text;

	// private Date created;
	private String created;

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	public Tweet() {
		super();
		setTitle("default title");
	}

	public Tweet(String title, String tweet_text, String created, User user) {
		super();
		this.title = title;
		this.tweet_text = tweet_text;
		this.created = created;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTweet_text() {
		return tweet_text;
	}

	public void setTweet_text(String tweet_text) {
		this.tweet_text = tweet_text;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

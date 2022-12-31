package com.SoloProject.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String fName;
	private String lName;
	private String password;
	private String email;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="user")
	private List<Article> savedArticles;
	
	public User() {
		super();

	}
	
	public User(String username, String fName, String lName, String password, String email) {
		super();
		this.username = username;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.email = email;
	}
	
	public void add(Article article ) {
		if (savedArticles == null) {
			savedArticles = new ArrayList<Article>();
		}
		
		savedArticles.add(article);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id= " + id + "username=" + username + ", fName=" + fName + ", lName=" + lName + ", password=" + password
				+ ", email=" + email + "]";
	}


	public List<Article> getSavedArticles() {
		return savedArticles;
	}


	public void setSavedArticles(List<Article> savedArticles) {
		this.savedArticles = savedArticles;
	}


	public void deleteArticle(String articleUrl) {
		
		Integer j = null;
		
		for (int i = 0; i < savedArticles.size(); i++) {
			if (articleUrl.equals(savedArticles.get(i).getUrl())) {
				j = i;
			}
		}
		
		if (j != null) {
			savedArticles.remove(j.intValue());
		}

	}
	
	
}

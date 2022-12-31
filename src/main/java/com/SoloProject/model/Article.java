package com.SoloProject.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Article {
	
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String description;
	private String url;
	private String urlToImage;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	
	public Article() {
		super();
	}

	public Article(String title, String url, String urlToImage, String description) {
		super();
		this.title = title;
		this.description = description;
		this.url = url;
		this.urlToImage = urlToImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", desc=" + ", url=" + url + ", urlToImage="
				+ urlToImage + "]";
	}

	public void setUser(User user) {
		this.user = user;
		
	}
	
	public User getUser() {
		return user;
	}
	
	
}

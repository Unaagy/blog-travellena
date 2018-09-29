package ru.travellena.blog.entity;

import java.util.Date;

public class Article {

	private long id;
	private String title;
	private String coverLink;
	private String body;
	private User author;
	private Date eventDate;
	private Date publishDate;
	private boolean isReadyToPublish;
	private boolean isInfo;

	// Constructors
	public Article() {

	}

	// full constructor
	public Article(String title, String coverLink, String body, User author, Date eventDate, Date publishDate,
			boolean isReadyToPublish, boolean isInfo) {
		this.title = title;
		this.coverLink = coverLink;
		this.body = body;
		this.author = author;
		this.eventDate = eventDate;
		this.publishDate = publishDate;
		this.isReadyToPublish = isReadyToPublish;
		this.isInfo = isInfo;
	}

	// short constructor
	public Article(String title, Date eventDate, Date publishDate) {
		this.title = title;
		this.eventDate = eventDate;
		this.publishDate = publishDate;
	}

	// Getters & Setters
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

	public String getCoverLink() {
		return coverLink;
	}

	public void setCoverLink(String coverLink) {
		this.coverLink = coverLink;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public boolean isReadyToPublish() {
		return isReadyToPublish;
	}

	public void setReadyToPublish(boolean isReadyToPublish) {
		this.isReadyToPublish = isReadyToPublish;
	}

	public boolean isInfo() {
		return isInfo;
	}

	public void setInfo(boolean isInfo) {
		this.isInfo = isInfo;
	}

	// To string
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", eventDate=" + eventDate
				+ ", publishDate=" + publishDate + ", isReadyToPublish=" + isReadyToPublish + ", isInfo=" + isInfo
				+ "]";
	}

}
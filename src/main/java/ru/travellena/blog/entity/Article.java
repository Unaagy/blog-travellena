package ru.travellena.blog.entity;

import java.util.Date;

/**
 * Article entity
 * 
 * @author tuchnyak, https://github.com/Tuchnyak
 *
 */
public class Article {

	private long id;
	private String title;
	private String coverLink;
	private String body;
	private User author;
//	private Date eventDate;
	private Date publishDate;
	private boolean readyToPublish;
	private boolean info;

	// Constructors
	public Article() {

	}

	// full constructor
	public Article(String title, String coverLink, String body, User author, Date publishDate,
			boolean ReadyToPublish, boolean Info) {
		this.title = title;
		this.coverLink = coverLink;
		this.body = body;
		this.author = author;
//		this.eventDate = eventDate;
		this.publishDate = publishDate;
		this.readyToPublish = ReadyToPublish;
		this.info = Info;
	}

	// short constructor
	public Article(String title, Date publishDate) {
		this.title = title;
//		this.eventDate = eventDate;
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

//	public Date getEventDate() {
//		return eventDate;
//	}
//
//	public void setEventDate(Date eventDate) {
//		this.eventDate = eventDate;
//	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public boolean isReadyToPublish() {
		return readyToPublish;
	}

	public boolean isInfo() {
		return info;
	}

	public void setInfo(boolean info) {
		this.info = info;
	}

	public void setReadyToPublish(boolean readyToPublish) {
		this.readyToPublish = readyToPublish;
	}

	// To string
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", coverLink=" + coverLink + ", body=" + body + ", author="
				+ author + ", publishDate=" + publishDate + ", readyToPublish="
				+ readyToPublish + ", info=" + info + "]";
	}

}

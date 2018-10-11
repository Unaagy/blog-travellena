package ru.travellena.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Article entity
 * 
 * @author tuchnyak, https://github.com/Tuchnyak
 *
 */
@Entity
@Table(name = "articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "cover_link")
	private String coverLink;
	
	@Lob
	@Column(name = "body", columnDefinition="MEDIUMTEXT")
	private String body;
	
	@Column(name = "publish_date")
	private Date publishDate;
	
	@Column(name = "ready_to_publish")
	private boolean readyToPublish;
	
	@Column(name = "info")
	private boolean info;

	// Constructors
	public Article() {

	}

	// full constructor
	public Article(String title, String coverLink, String body, Date publishDate, boolean ReadyToPublish,
			boolean Info) {
		this.title = title;
		this.coverLink = coverLink;
		this.body = body;
		this.publishDate = publishDate;
		this.readyToPublish = ReadyToPublish;
		this.info = Info;
	}

	// short constructor
	public Article(String title, Date publishDate) {
		this.title = title;
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
		return "Article [id=" + id + ", title=" + title + ", coverLink=" + coverLink + ", body=" + body
				+ ", publishDate=" + publishDate + ", readyToPublish=" + readyToPublish + ", info=" + info + "]";
	}

}

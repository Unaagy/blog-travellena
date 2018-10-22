package ru.travellena.blog.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

	@NotNull(message = "*** Необходимо заполнить! ***")
	@Size(max = 255, message = "*** Не более 255 символов! ***")
	@Column(name = "title")
	private String title;

	@Lob
	@Size(max = 2000, message = "*** Не более 2000 символов! ***")
	@Pattern(regexp = "^(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "*** Ссылка должна начинаться с \"http(s)://\" или быть пустой ***")
	@Column(name = "cover_link")
	private String coverLink;

	@Lob
	@Size(max = 16777200, message = "*** Не более 16 777 200 символов в статье вместе с тегами! ***")
	@Column(name = "body", columnDefinition = "MEDIUMTEXT")
	private String body;

	@Column(name = "publish_date")
	private LocalDateTime publishDate;

	@Column(name = "ready_to_publish")
	private boolean readyToPublish;

	@Column(name = "info")
	private boolean info;

	// Constructors
	public Article() {

	}

	// full constructor
	public Article(String title, String coverLink, String body, LocalDateTime publishDate, boolean ReadyToPublish,
			boolean Info) {
		this.title = title;
		this.coverLink = coverLink;
		this.body = body;
		this.publishDate = publishDate;
		this.readyToPublish = ReadyToPublish;
		this.info = Info;
	}

	// short constructor
	public Article(String title, LocalDateTime publishDate) {
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

	public LocalDateTime getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDateTime publishDate) {
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

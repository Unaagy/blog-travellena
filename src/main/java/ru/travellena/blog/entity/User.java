package ru.travellena.blog.entity;

public class User {

	private int id;
	private String login;

	// Constructors
	public User() {

	}

	public User(String login) {
		this.login = login;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	// To string
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + "]";
	}

}

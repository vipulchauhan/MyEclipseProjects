package com.dvdrental.dto;

public class Actor {

	private int id;
	private String firstName;
	private String lastName;
	private String lastModified;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", lastModified=" + lastModified + "]";
	}

	public Actor(int id, String firstName, String lastName, String lastModified) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastModified = lastModified;
	}

	public Actor() {
		super();
	}

}

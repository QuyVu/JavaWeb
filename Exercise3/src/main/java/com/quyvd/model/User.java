package com.quyvd.model;

import java.sql.Timestamp;

public class User {
	private String firstname;
	private String lastname;
	private Timestamp createDate;

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public User(String firstname, String lastname, Timestamp d) {
		this.firstname = firstname;
		this.lastname = lastname;
		setCreateDate(d);
	}

}

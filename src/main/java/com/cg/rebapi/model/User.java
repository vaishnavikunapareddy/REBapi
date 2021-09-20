package com.cg.rebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "user_tbl")
public class User {
	@Id
	private Long id;
	@NotNull
	private String userName ;
	
	@NotNull
	private String password;

	public User() {
		super();
	}

	

	public User(Long id, @NotNull String userName, @NotNull String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}



	
	

}

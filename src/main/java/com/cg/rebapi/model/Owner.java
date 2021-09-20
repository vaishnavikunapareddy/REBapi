package com.cg.rebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="owner_tbl")


	public class Owner {
	
	@Id
	@Column (name="Id")
	@NotNull
	private Long id;
	@Column (name="fName",length=20)
	@NotNull
	@Size(min = 3, message = "owner first name should have atleast 3 character")

	private String firstName;
	@Column (name="lName",length=20)
	@NotNull
	@Size(min = 3, message = "owner last name should have atleast 3 character")

	private String lastName;
	@Column (name="Mob_no")
	@NotNull	
	private Long contact;
	@Column (name="email")
	@NotNull	
	private String email;
	public Owner() {
		super();
	}
	public Owner(Long id, String firstName, String lastName, Long contact, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Owner [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact
				+ ", email=" + email + "]";
	}
		
		
}
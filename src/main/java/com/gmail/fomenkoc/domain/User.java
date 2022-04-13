package com.gmail.fomenkoc.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;

	public User() {
		super();
	}
	
	public User(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.role = user.getRole();
	}

	public User(String email, String password, String firstName,
			String lastName, UserRole role) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public User(Integer id, String email, String password, String firstName,
			String lastName, UserRole role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password)
				&& role == other.role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", role=" + role + "]";
	}

}

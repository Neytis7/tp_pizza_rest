package com.tp.pizza.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Membre {

	@Id
	@GeneratedValue
	private Long id;
	private String lastName;
	private String firstName;
	private String login;
	private String password;

	public Membre() {
	}

	public Membre(String lastName, String firstName, String login, String password) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.login = login;
		this.password = password;
	}

	public Membre(Long id, String lastName, String firstName, String login, String password) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.login = login;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Membre [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", login=" + login
				+ ", password=" + password + "]";
	}
	
}

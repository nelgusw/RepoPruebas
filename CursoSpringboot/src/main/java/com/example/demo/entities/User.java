package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "users")
public class User implements Serializable{

private static final long serialVersionUID = -5990378437275051454L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private long Id;
@Column(length = 50)
 private String name;
 private String surname; 
 @Column(name = "mail", nullable=false, length=50, unique=true)
 private String email; 
 private Boolean enabled;
public long getId() {
	return Id;
}
public void setId(long id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Boolean getEnabled() {
	return enabled;
}
public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
}

 
}

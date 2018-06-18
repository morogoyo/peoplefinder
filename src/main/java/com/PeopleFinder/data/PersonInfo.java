package com.PeopleFinder.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class PersonInfo {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String location;
	private Date birthDate;
	
	
	public PersonInfo() {
		super();
	}
	public PersonInfo(int id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public int getId() {
		return id;
	}
	public String getLocation() {
		return location;
	}
	public String getName() {
		return name;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("\nPersonInfo [id= " + id + ", name= " + name + ", location= " + location + ", birthDate= " + birthDate + " ]");
	}
	
	
}

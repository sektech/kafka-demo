package com.example.myrestapiws.model;

public class User {
	
	private int id;
	private String name;
	private String SSN;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", SSN=" + SSN + "]";
	}
	

}

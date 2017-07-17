package com.dusty.teamroster.models;

public class Player {
	private String first_name;
	
	private String last_name;
	private Integer age;
	
	public Player() {
		
	}
	public Player(String first_name, String last_name, Integer age) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public Integer getAge() {
		return age;
	}
	
}

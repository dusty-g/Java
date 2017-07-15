package com.dusty.pets.models;

public abstract class Animal {
	String name;
	String breed;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	Double weight;
	public Animal(String name, String breed, Double weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
		
	}
	
}

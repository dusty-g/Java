package com.dusty.pets.models;

public class Cat extends Animal implements Pet{
	public Cat(String name, String breed, Double weight) {
		super(name, breed, weight);
	}
	public Cat() {
		super("null", "null", 0.00);
	}
	public String showAffection() {
		return this.name+ " brings you a dead bird";
	}
}

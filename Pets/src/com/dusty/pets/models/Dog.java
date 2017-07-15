package com.dusty.pets.models;

public class Dog extends Animal implements Pet{
	public Dog(String name, String breed, Double weight) {
		super(name, breed, weight);
	}
	public Dog() {
		super("null", "null", 0.00);
	}
	public String showAffection() {
		if(this.weight < 30) {
			return this.name+ " hops on your lap";
		}else {
			return this.name + " curls up next to you";
		}
		
	}
}

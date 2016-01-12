package sts44b.cs3330.lab3;

public class Terrorist { 
	 //Declare Variables 
	 private String name, weapon; 
	 private int health; 
	 
	//Constructor 
	 public Terrorist(String name, int health, String 
	weapon) { 
	 this.setName(name); 
	 this.setHealth(health); 
	 this.setWeapon(weapon); 
	 } 
	 
	 //Getters and Setters 
	 private void setName(String name) { this.name = name; } 
	 
	 private void setHealth(int health) { this.health = 
	health; } 
	 
	 private void setWeapon(String weapon) { this.weapon = 
	weapon; } 
	 
	 public String getName() { return this.name; } 
	 
	 public int getHealth() { return this.health; } 
	 
	 public String getWeapon() { return this.weapon; } 
	 
	 //toString method to print it 
	 @Override 
	 public String toString() { 
		 if(this.getHealth() == 100) { 
			 return "My name is " + this.getName() + "! I've full health. And, I'm carrying " + this.getWeapon() + ".";
		 } 
	 
		 else {
			 return "My name is " + this.getName() + "! I've " + this.getHealth() + " health remaining." + " And, I'm carrying " + this.getWeapon() + "."; 
		 } 
	 } 
	} 

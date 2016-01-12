/*
 * Name: Seanmichael Stanley
 * Lab: Lab 3
 * Submission Code: put submission code in all classes
 * Date: 2/19/2014
 * TA: Matt English 
 */

package sts44b.cs3330.extLab3;


//class to set modify attributes of fighters
public class Fighter {
	 //Declare Variables 
	 private String name; 
	 private int healthPoints; 
	 boolean isAlive;
	 
	//Constructor 
	 public Fighter(String name, int healthPoints) {
		 this.setName(name); 
		 this.setHealth(healthPoints); 
		 this.setAlive(isAlive);
	}

	//Getters and Setters 
	 private void setName(String name) { this.name = name; } 
	 
	 private void setHealth(int healthPoints) { this.healthPoints = healthPoints; } 
	 
	 private void setAlive(boolean isAlive) { this.isAlive = true; }
	 
	 public String getName() { return this.name; } 
	 
	 public int getHealth() { return this.healthPoints; } 
	 
	 public boolean getAlive() { return this.isAlive; } 
	 
	 //method to take in a distance and remove the appropriate amount of damage and kill the fighter when healthPoints reach 0
	 public void beingHit(int distance){
		 
		 //check that the fighter has health left
		 if (this.healthPoints > 0){
			 
			 //remove 30 healthPoints for close distance
			 if (distance <= 5){
				 this.healthPoints = (healthPoints - 30);
				 System.out.println(this.getName() + ": I was hit for 30 points of damage.");
				 
			 }
			 
			 //remove 10 healthPoints for middle distance
			 else if (distance > 5 && distance < 8){
				 this.healthPoints = (healthPoints - 10);
				 System.out.println(this.getName() + ": I was hit for 10 points of damage.");
			 }
			 
			 //dodge for long range hits
			 else{
				 System.out.println(this.getName() + ": I dodged!!!!");
			 }
		 }
		 
		 //if the hit has reduced fighter's healthPoints to 0 or less kill the fighter
		 if (this.healthPoints <= 0){
			 this.die();
		 }
		 
		 //if fighter is still alive display their status
		 else{
			 System.out.println(this.toString());
		 }
	 }
	 
	 //method to kill fighter and display thier death
	 private void die(){
		 System.out.println(this.getName() + " has died.");
		 this.isAlive = false;
	 }
	 
	 //toString method to print fighter status
	 @Override 
	 public String toString() { 
		return "My name is " + this.getName() + "! I've " + this.getHealth() + " health remaining."; 
	 } 
	} 


/*
 * Name: Seanmichael Stanley
 * TA: Matt England
 * Date: 3/21/14
 * Homework 2
 */
package sts44b.cs3330.hw2;

/*
 * Class Player handles the players characteristics. Name, money, and health.
 * also has a method to return a String of the players current stats.
 */
public class Player {
	
	//attributes of class player
	private String name;
	private int health = 100;
	private int money = 20000;
	
	//Constructor for class player
	public Player (String name){
		this.setName(name);
		this.setHealth(health);
		this.setMoney(money);
	}

	//assign the name entered by the user to player.name
	private void setName(String name){
		this.name = name;
	}
	
	//health begins at 100 but gets modified as runs on the grid fail
	private void setHealth(int health){
		this.health = health;
	}
	
	/*assigns an initial amount of 20000 yen to player and 
	gets updated as tools are purchased and successful runs on the grid occur*/
	private void setMoney(int money){
		this.money = money;
	}
	
	//method to update money player owns
	public void updateMoney(int money){
		this.setMoney(this.money + money);
	}
	
	//method to update the player's health
	public void updateHealth(int health){
		this.setHealth(this.health + health);
	}
	
	//method to return the player's name
	public String getName(){
		return this.name;
	}
	
	//method to return the player's health
	public int getHealth(){
		return this.health;
	}
	
	//method to return the player's money amount
	public int getMoney(){
		return this.money;
	}
	
	//method to return the players name health and money if alive or if they have died
	@Override
	public String toString(){
		if (this.getHealth() <= 0){
			return "Hacker " + this.getName() + " with health of 0 with " + this.getMoney() + " yen has FLATLINED";
		}
		else{
			return "Hacker " + this.getName() + " with health of " + this.getHealth() + " with " + this.getMoney() + " yen";
		}
	}
}

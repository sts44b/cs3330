/*Name: Seanmichael Stanley
 * Lab:D
 * Homework 1
 * Date: 2/28/14
 * TA:Matt English
 */

package sts44b.cs3330.homework1;

//Class to handle the characteristics of a tool
public class Tool{
	
	//attibutes of class Tool
	private String name;
	private String type;
	private int cost;
	private int strength;

	//Constructor to call set methods for a tool object
	public Tool(String name, String type, int cost, int strength){
		this.setName(name);
		this.setType(type);
		this.setCost(cost);
		this.setStrength(strength);
	}
	
	//method sets the name of a tool
	private void setName(String name){
		this.name = name;
	}
	
	//method to assign the type of the tool
	private void setType(String type){
		this.type = type;
	}
	
	//method to set the cost of the tool
	private void setCost(int cost){
		this.cost = cost;
	}
	
	//method to set the strength of the tool
	private void setStrength(int strength){
		this.strength = strength;
	}
	
	//method to up update a tool as the user specifies
	public void updateStrength(int additional_strength){
		this.setStrength(strength + additional_strength);
	}
	
	//method to return the name of the tool
	public String getName(){
		return this.name;
	}
	
	//method to return the type of the tool
	public String getType(){
		return this.type;
	}
	
	//method to return the cost of the tool
	public int getCost(){
		return this.cost;
	}
	
	//method to return the strength of a tool
	public int getStrength(){
		return this.strength;
	}
	
	//method to return a string of the tools characteristics
	@Override
	public String toString(){
		return this.getType() + " tool named " + this.getName() + " with " + this.getStrength() + " strength and a cost of " + this.getCost();
	}
}

/*
 * Name: Seanmichael Stanley
 * TA: Matt England
 * Date: 3/21/14
 * Homework 2
 */

package sts44b.cs3330.hw2;


//Class to handle the servers
public class Server {

	//attributes of class Server
	private String name;
	private String type;
	private int strength;
	
	//Server objects have a name, type and strength 
	public Server (String name, String type, int strength){
		this.setName(name);
		this.setType(type);
		this.setStrength(strength);
	}
	
	//method sets the servers strength to what is read in from file
	private void setStrength(int strength) {
		this.strength = strength;
		
	}

	//method assigns a type to the server, encrypted or unencrypted
	private void setType(String type) {
		this.type = type;
		
	}

	//method sets the name of the server aka IP address
	private void setName(String name){
		this.name = name;
	}
	
	//method updates the servers strength as it is accessed
	public void updateStrength(int additional_strength){
		this.setStrength(strength + additional_strength);
	}
	
	//method returns the name of the server
	public String getName(){
		return this.name;
	}
	
	//method returns the type of server
	public String getType(){
		return this.type;
	}
	
	//method returns the strength of the server
	public int getStrength(){
		return this.strength;
	}
	
	//method to return a string of the servers characteristics
	@Override
	public String toString(){
		return "SERVER INFO: " + this.getType() + " server with address of " + this.getName() + " with " + this.getStrength() + " strength";
	}
}

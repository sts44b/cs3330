/*
 * Name: Seanmichael Stanley
 * TA: Matt England
 * Date: 3/21/14
 * Homework 2
 */
package sts44b.cs3330.hw2;

import java.util.Random;

//class of the business type corporation
public class Corporation extends Business{
	//constructor to assign the business attributes of the corporation
	public Corporation (String name, String contact, Grid grid){
		super(name, contact, grid);
	}
	
	//overridden method for the net worth of the corporation
	@Override
	public int determineWorth(){
		int worth;
		Random generator = new Random();
		
		worth = 20000 + generator.nextInt(15000); 
		
		return worth;
	}
	
	//method to display the information of a corporation object
	@Override
	public String toString(){
		return "[Contact " + this.getContact()+ "] " + "\tCorporation: " + this.getName();
	}
}

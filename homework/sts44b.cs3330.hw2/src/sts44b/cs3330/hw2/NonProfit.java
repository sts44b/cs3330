
/*
 * Name: Seanmichael Stanley
 * TA: Matt England
 * Date: 3/21/14
 * Homework 2
 */
package sts44b.cs3330.hw2;

//class for nonprofit business objects
public class NonProfit extends Business{
	
	//constructor to set the business attributes of the non profit objects
	public NonProfit(String name, String contact, Grid grid){
		super(name, contact, grid);
	}
	
	//overridden method to display nonprofit information
	@Override
	public String toString(){
		return "[Contact " + this.getContact() + "] " + "\tNon Profit: " + this.getName();
	}

}

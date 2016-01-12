/*
 * Name: Seanmichael Stanley 
 * Lab: Lab 5
 * Submission Code: Ukraine Civil War
 * Date: 3/6/2014
 * TA: Matt English 
 */

package sts44b.cs3330.lab5;


/*
 * Driver for lab 5 program. instantiates a GoonDatabase object 
 * and passes the filename to it. The searchMenu function is then called. 
 * Once the program is terminated by the user Program Complete is displayed 
 * and the program terminates.
 */
public class DatabaseDriver {
	public static void main(String[] args) {
		GoonDatabase goonies = new GoonDatabase("goons.csv");
		goonies.searchMenu();
		
		System.out.println();
		System.out.println("Program Complete.");
	System.exit(0);
	}
}

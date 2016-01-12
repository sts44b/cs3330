/*
 * Name: Seanmichael Stanley 
 * Lead TA: Matt English
 * Lab Section: D
 * Date: 4/9/14
 * Lab 7
 * Labcode: Opening Day
 */

package sts44b.cs3330.lab8;

//class to handle throwing errors for invalid balance entries
public class InvalidBalanceException extends Exception{
	//constructor for no string passed
	public InvalidBalanceException(){}
	
	//constructor for string passed
	public InvalidBalanceException (String error){
		super(error);
	}
}

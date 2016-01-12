/*
 * Name: Seanmichael Stanley 
 * Lead TA: Matt English
 * Lab Section: D
 * Date: 4/9/14
 * Lab 7
 * Labcode: Opening Day
 */

package sts44b.cs3330.lab8;

//class to handle throwing errors for invalid age entries
public class InvalidAgeException extends Exception{
	//constructor for no string passed
	public InvalidAgeException(){}
	
	//constructor for string passed
	public InvalidAgeException(String error){
		super(error);
	}

}

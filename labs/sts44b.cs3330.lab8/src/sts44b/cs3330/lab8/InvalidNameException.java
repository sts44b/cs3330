/*
 * Name: Seanmichael Stanley 
 * Lead TA: Matt English
 * Lab Section: D
 * Date: 4/9/14
 * Lab 7
 * Labcode: Opening Day
 */

package sts44b.cs3330.lab8;

//Class to handle throwing errors for invalid name entries
public class InvalidNameException extends Exception{
	//constructor for no string passed
	public InvalidNameException(){}
	
	//constructor for string passed
	public InvalidNameException(String error){
		super(error);
	}

}

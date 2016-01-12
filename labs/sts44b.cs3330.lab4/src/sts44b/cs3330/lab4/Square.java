/*************************************	
	* Name:	Seanmichael Stanley 
	* Lab: 4
	* Section: 1D	
	* Date:	2/24/14	
	* Description:
	* Submission	Code:	Russia won the olympics :(	
	**************************************/

package sts44b.cs3330.lab4;

public class Square extends Rectangle{
	public Square(double length){
		super(length, length);
	}
	
	public double getSideLength(){
		return this.getLength();
	}
	
	public String toString(){
		return "Square\n" + "\tDimentions = " + getSideLength()  + " x " + getSideLength() + "\n" + "\tArea = " + calcArea() + "\n" + "\tPerimeter = " + calcPerimiter();
	}
}

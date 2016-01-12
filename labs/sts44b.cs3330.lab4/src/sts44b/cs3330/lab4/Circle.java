/*************************************	
	* Name:	Seanmichael Stanley
	* Lab: 4
	* Section: 1D	
	* Date:	2/24/14	
	* Description:
	* Submission	Code:	Russia won the olympics :(	
	**************************************/

package sts44b.cs3330.lab4;

public class Circle extends Ellipse{
	
	public Circle(double radius){
		super(radius, radius);
	}
	
	public double getRadius(){
		return this.getMajorAxis();
	}
	
	@Override
	public String toString(){
		return "Circle\n" + "\tRadius = " + getRadius()  + "\n" + "\tArea = " + calcArea() + "\n" + "\tPerimeter = " + calcPerimiter();
	}

}

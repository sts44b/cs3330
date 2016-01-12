/*************************************	
	* Name:	Seanmichael Stanley
	* Lab: 4
	* Section: 1D	
	* Date:	2/24/14	
	* Description:
	* Submission	Code:	Russia won the olympics :(	
	**************************************/

package sts44b.cs3330.lab4;

public class Rectangle implements Shape{
	private double length;
	private double width;
	
	public Rectangle(double length, double width){
		setLength(length);
		setWidth(width);
	}
	
	public double getLength(){
		return this.length;
	}
	
	protected void setLength(double length){
		this.length = length;
	}
	
	public double getWidth(){
		return this.width;
	}
	
	protected void setWidth(double width){
		this.width = width;
	}
	
	@Override
	public String toString(){
		return "Rectangel\n" + "\tDimentions = " + getWidth()  + " x " + getLength() + "\n" + "\tArea = " + calcArea() + "\n" + "\tPerimeter = " + calcPerimiter();
	}

	@Override
	public double calcArea() {
		return getLength() * getWidth();
	}

	@Override
	public double calcPerimiter() {
		return 2*(getLength() + getLength());
	}
	
}

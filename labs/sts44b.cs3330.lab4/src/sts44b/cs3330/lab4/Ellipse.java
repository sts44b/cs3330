/*************************************	
	* Name:	Seanmichael Stanley
	* Lab: 4
	* Section: 1D	
	* Date:	2/24/14	
	* Description:
	* Submission	Code:	Russia won the olympics :(	
	**************************************/

package sts44b.cs3330.lab4;

public class Ellipse implements Shape{
	
	private double majorAxis;
	private double minorAxis;
	
	public Ellipse(double majorAxis, double minorAxis){
		setMajorAxis(majorAxis);
		setMinorAxis(minorAxis);
	}
	
	public double getMajorAxis(){
		return this.majorAxis;
	}
	
	protected void setMinorAxis(double minorAxis){
		this.minorAxis = minorAxis;
	}
	
	public double getMinorAxis(){
		return this.minorAxis;
	}
	
	protected void setMajorAxis(double majorAxis){
		this.majorAxis = majorAxis;
	}
	
	@Override
	public String toString(){
		return "Ellipse\n" + "\tAxis lengths = " + getMajorAxis()  + " x " + getMinorAxis() + "\n" + "\tArea = " + calcArea() + "\n" + "\tPerimeter = " + calcPerimiter();
	}

	@Override
	public double calcArea() {
		return getMajorAxis() * getMinorAxis() * Math.PI;
	}

	@Override
	public double calcPerimiter() {
		return (2 * Math.PI) * Math.sqrt((Math.pow(getMajorAxis(),2) + Math.pow(getMinorAxis(), 2))/2);
	}
}

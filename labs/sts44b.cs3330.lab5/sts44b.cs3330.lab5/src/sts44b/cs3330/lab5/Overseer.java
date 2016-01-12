/*
 * Name: Seanmichael Stanley 
 * Lab: Lab 5
 * Submission Code: Ukraine Civil War
 * Date: 3/6/2014
 * TA: Matt English 
 */

package sts44b.cs3330.lab5;

//Subclass for goons of the Overseer sort
public class Overseer extends Goon{
	
	//attribute of an overseer goon
	private String sector;
	
	//Constructor to assign name DOB and sector to an overseer goon
	public Overseer(String name,String DOB,String sector){
		super(name,DOB);
		setSector(sector);
	}
	
	//get and set the sector of an overseer goon
	public String getSector() { return this.sector; }
	protected void setSector(String sector) { this.sector = sector; }
		
	//toString to display the information of an overseer goon if necessary
	@Override
	public String toString(){
		return "Overseer " + getName() + "\n\tDOB: " + getDOB() + "\n\tSector: " + getSector();
	}
}

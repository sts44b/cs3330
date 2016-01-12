/*
 * Name: Seanmichael Stanley 
 * Lab: Lab 5
 * Submission Code: Ukraine Civil War
 * Date: 3/6/2014
 * TA: Matt English 
 */

package sts44b.cs3330.lab5;

/*
 * subclass of goon that handles goons of the Talent sort.
 */
public class Talent extends Goon{
	//Attribute of Talent goons
	private String skill;
	
	//Assign name DOB and skill to the talent goon
	public Talent(String name,String DOB,String skill){
		super(name,DOB);
		setSkill(skill);
	}
	
	//get and set skill of talent goon
	public String getSkill() { return this.skill; }
	protected void setSkill(String skill) { this.skill = skill; }
	
	//toString to display information of a talent goon if necessary
	@Override
	public String toString(){
		return "Talent " + getName() + "\n\tDOB: " + getDOB() + "\n\tSkill: " + getSkill();
	}
}



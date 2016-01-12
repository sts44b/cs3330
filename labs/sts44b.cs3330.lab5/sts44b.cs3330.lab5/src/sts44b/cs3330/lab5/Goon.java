/*
 * Name: Seanmichael Stanley 
 * Lab: Lab 5
 * Submission Code: Ukraine Civil War
 * Date: 3/6/2014
 * TA: Matt English 
 */

package sts44b.cs3330.lab5;

/*
 * Superclass for various goons handles the name and date of birth of each goon. 
 * These are attributes that all goons have in common.
 */
public class Goon {
	
	//Declare attributes of goons
	private String name;
	private String DOB;
	
	//constructor to assign a name and date of birth to each goon object
	public Goon(String name,String DOB){
		setName(name);
		setDOB(DOB);
	}
	
	//Setters for name and DOB
	protected void setName(String name){ this.name = name; }
	protected void setDOB(String DOB){ this.DOB = DOB; }
	
	//Getters for name and DOB
	public String getName(){ return this.name; }
	public String getDOB(){ return this.DOB; }
	
	//toString to display name and DOB information if necessary
	@Override
	public String toString(){
		return "Goon " + getName() + "\n\tDOB: " + getDOB();
	}
}


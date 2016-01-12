

/*
 * Name: Seanmichael Stanley
 * TA: matt English
 * section D
 * 3/17/14
 * labcode: Bioprocess
 */
package sts44b.cs3330.lab6;

public class Employee {
	private String name;
	private int SSN;
	
	public Employee(String name, int SSN){
		this.setName(name);
		this.setSSN(SSN);
	}
	
	protected void setName(String name){
		this.name = name;
	}
	
	protected void setSSN(int SSN){
		this.SSN = SSN;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getSSN(){
		return this.SSN;
	}
}

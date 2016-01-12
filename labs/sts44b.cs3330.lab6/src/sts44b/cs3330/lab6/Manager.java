/*
 * Name: Seanmichael Stanley
 * TA: matt English
 * section D
 * 3/17/14
 * labcode: Bioprocess
 */

package sts44b.cs3330.lab6;

public class Manager extends Employee{
	private String department;
	
	public Manager (String name, int SSN, String department){
		super(name, SSN);
		this.setDepartment(department);
	}
	
	protected void setDepartment(String department){
		this.department = getDepartment();
	}

	public String getDepartment(){
		return this.department;
	}
}

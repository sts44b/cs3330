/*
 * Name: Seanmichael Stanley
 * TA: matt English
 * section D
 * 3/17/14
 * labcode: Bioprocess
 */

package sts44b.cs3330.lab6;

public class CEO extends Employee{
	private int netWorth;
	
	public CEO(String name, int SSN, int netWorth){
		super(name, SSN);
		this.setNetWorth(netWorth);
	}
	
	protected void setNetWorth(int netWorth){
		this.netWorth = getNetWorth();
	}
	
	public int getNetWorth(){
		return this.netWorth;
	}
}

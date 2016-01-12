/*
 * Name: Seanmichael Stanley 
 * Lab: Lab 5
 * Submission Code: Ukraine Civil War
 * Date: 3/6/2014
 * TA: Matt English 
 */

package sts44b.cs3330.lab5;


//Subclass to handle goons of type Don
public class Don extends Goon{
	
	//attributes of a Don goon
	private String mobName;
	private int netWorth;
	
	//constructor to assign name DOB mobName and netWorth of a Don goon
	public Don (String name, String DOB, String mobName, int netWorth){
		super(name, DOB);
		setMobName(mobName);
		setNetWorth(netWorth);
	}
	
	//get and set the netWorth of a Don goon
	public int getNetWorth(){return this.netWorth;}
	protected void setNetWorth(int netWorth){
		this.netWorth = netWorth;
	}
	
	//get and set the mobName of the mob that the Don is in charge of
	public String getMobName(){return this.mobName;}
	protected void setMobName(String mobName){
		this.mobName = mobName;
	}
	
	//toString to display the information of a Don object if necessary
	@Override
	public String toString(){
		return "Don " + getName() + "\n\tDOB: " + getDOB() + "\n\tMob Name: " + getMobName() + "\n\tNet Worth: " + getNetWorth();
	}
}

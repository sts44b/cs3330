
/*
 * Name: Seanmichael Stanley
 * TA: Matt England
 * Date: 3/21/14
 * Homework 2
 */
package sts44b.cs3330.hw2;

/**
 * 
 * class to handle jobs, target addresses and the prize for successfully completing them
 *
 */
public class Job {
	private String target_address;
	private int reward;
	
	
	//constructor calls setReward() and setTargetAddress()
	public Job (String target_address, int reward){
		this.setReward(reward);
		this.setTargetAddress(target_address);
	}

	//set the target address
	private void setTargetAddress(String target_address) {
		this.target_address = target_address;
	}

	//return the target address
	public String getTargetAddress(){
		return this.target_address;
		
	}

	//set the reward amount
	private void setReward(int reward) {
		this.reward = reward;
	}
	
	//return the reward amount
	public int getReward(){
		return this.reward;
	}
	
	//overridden method to display jobs
	@Override
	public String toString(){
		return "Job: " + getTargetAddress() + " worth " + getReward();
	}

}

/*
 * Name: Seanmichael Stanley 
 * Lab: D
 * TA: Matt England
 * Date: 3/21/14
 * Homework 2
 */

package sts44b.cs3330.hw2;

import java.util.ArrayList;
import java.util.Random;


//super class for handling different types of businesses
public class Business {
	private String name;
	private String contacts_name;
	private ArrayList<Job> jobOffers;
	protected Grid grid;
	protected static int JOB_OFFER_SIZE = 10;

	//constructor will call setters for the name, contact, and grid of each business and fill job offers
	public Business (String name, String contacts_name, Grid grid){
		this.setBusinessName(name);
		this.setBusinessContact(contacts_name);
		this.setGrid(grid);
		this.fillJobOffers();
	}
	
	//set the businesses name
	private void setBusinessName(String name){
		this.name = name;
	}
	
	//set the grid attribute
	private void setGrid(Grid grid){
		this.grid = grid;
	}
	
	//set the contacts name
	private void setBusinessContact (String contacts_name){
		this.contacts_name = contacts_name;
	}
	
	//return the business's name
	protected String getName(){
		return this.name;
	}
	
	//return the contact's name
	protected String getContact(){
		return this.contacts_name;
	}
	
	//method to assign ten random jobs to each contact of a business instantiated
	protected void fillJobOffers(){
		Random generator = new Random();
		jobOffers = new ArrayList<Job>();
		String name;
		int worth;
		
		for (int i = 0; i < JOB_OFFER_SIZE; i++){
			int randomJob = 1 + generator.nextInt(grid.numberOfServers() - 1);
			name = grid.getServerName(randomJob);
			worth = this.determineWorth();
			jobOffers.add(new Job(name, worth));
		}
	}
	
	//method to display the job offers of a selected contact
	public void viewJobOffers(){
		int i = 1;
		
		for (Job x : jobOffers){
			System.out.println(i + ") " + x.toString());
			i++;
		}
	}
	
	//method to return the selected job offer and remove it from the contacts list
	public Job getJobOffer(int job_offer){
		Job x = jobOffers.get(job_offer);
		jobOffers.remove(job_offer);
		
		return x;
	}
	
	//method to return the number of job offers in the contacts list
	public int getJobOfferCount(){
		return jobOffers.size();
	}
	
	//method to generate a random value for a successful job
	protected int determineWorth(){
		int worth;
		Random generator = new Random();
		
		worth = 10000 + generator.nextInt(15000);
		
		return worth;
	}
}

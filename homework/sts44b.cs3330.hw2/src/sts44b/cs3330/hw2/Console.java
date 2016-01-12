/*
 * Name: Seanmichael Stanley
 * Lab: D
 * TA: Matt England
 * Date: 3/21/14
 * Homework 2
 */

package sts44b.cs3330.hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//class to handle the game play
public class Console {
	
	//attributes for class Console
	private static final Scanner input = new Scanner(System.in);
	private Player player;
	private Grid grid;
	private ToolKit toolKit;
	private ArrayList<Job> jobs;
	private ArrayList<Business> contacts;
	BlackMarket blackMarket;
	
	public Console(Player player, Grid grid){
	/*Console constructor: will set the Player instance to the player 
	 * attribute, set the grid instance, and call the init method. 
	 */
		setPlayer(player);
		setGrid(grid);
		init();
		
	}
	
	//method to set player
	private void setPlayer (Player player){
		this.player = player;
	}
	
	//method to set grid
	private void setGrid(Grid grid){
		this.grid = grid;
	}
	
	private void init(){
	/*init:  will instantiate a blackmarket object, 
	instantiate a ToolKit object, instantiate the jobs attribute,
	and call the method loadContacts.*/

		this.blackMarket = new BlackMarket("New Tokyo Subterranean Sewer", "Katsu Tanaka", grid, player);
		this.toolKit = new ToolKit();
		this.jobs = new ArrayList<Job>();
		this.loadContacts();
	}
	
	private void loadContacts(){
	/*loadContacts loads contact information from the contact file into
	 * 	the contacts arrayList.
	 */
		/*
		 *Declare variables for the loadContacts method
		 */
		String business;
		String businessName;
		String contactName;
		contacts = new ArrayList<Business>();
		File	contactDataFile	=	new	File ("contacts.txt");
		
		//read information from the contacts.txt file
		try	{
			Scanner dataScanner = null;
			dataScanner = new Scanner(contactDataFile);

			//while there is more data in the file continue to read lines
			while (dataScanner.hasNextLine()){
				Scanner line = new Scanner(dataScanner.nextLine());
				line.useDelimiter(",");
				
				//assign data from each line to variables to create objects
				business = line.next();
				businessName = line.next();
				contactName = line.next();
				
				//if the information is for a corporation add a corporation object to the arraylist
				if (business.toUpperCase().equals("CORPORATION")){
					contacts.add(new Corporation(businessName, contactName, grid));
				}
				
				//if the information is for a nonprofit add a nonprofit object to the arrarylist
				else if (business.toUpperCase().equals("NONPROFIT")){
					contacts.add(new NonProfit(businessName, contactName, grid));
				}

				//if a wrongly formatted line is read display message
				else{
					System.out.println("Unable to add contact!");
				}
				//close line scanner
				line.close();
			}
		}
			
		//if file was not found
		catch (FileNotFoundException e)	{	
			System.out.println("Error:	Contacts file not found.");	
			System.exit(0); 
		 }	
		
	}

	public boolean use(){
	/*use: The use method will terminate when the player’s health is less or equal to zero or if the user chooses to log off.*/
		
		//keep going while player is still alive
		while (player.getHealth() > 0){
			//declare variables for this method
			boolean run;
			
			//display the player's status
			System.out.println();
			System.out.println(player.toString());
			
			//display menu options
			int option = displayOptionMenu();
			
			/*if player has a job available make a run on 
			the grid otherwise tell the player to get a job*/
			if (option == 1){
				if (jobs.size() >= 1){
					Job x = pullAJob();
					int jobSelected = grid.search(x.getTargetAddress());
					
					if (jobSelected == -1){
						System.out.println("Server not found!");
					}
					
					else{
						run = runOnTheGrid(jobSelected, x.getReward());
						if (run == true){
							jobs.remove(x);
						}	
					}	
				}
				
				else{
					System.out.println("You need to get job");
				}	
				
			}
			
			/*if the user selects 2 call update toolkit and go to the black market*/
			else if (option == 2){
				if (player.getMoney() >= 1){
					updateToolKit();
				}
				else{
					System.out.println("no funds to visit the black market");
				}
			}
			
			/*If the user selects option 3 find jobs, if the user has 10 jobs
			 * tell the user to take care of some of those jobs first*/
			else if (option == 3){
				if (jobs.size() < 10){
					findJobOffer();
				}
				else{
					System.out.println("Too many jobs left undone");
				}
			}
			
			//selecting option 4 will log the user off 
			else if (option == 4){
				System.out.println();
				System.out.println("Logging Off!");
				return true;
			}
		}
		
		//when player dies show that he has flatlined and return from use and console
		System.out.println(player.toString());
		return false;
	}
	
	//method to add jobs to the users job list
	private void findJobOffer(){
		//declare variables for this method
		int i = 1;
		int choice = 0;
		int job_offer;

		System.out.println("Pick a contact to view offers");
		
		//display contacts to chose from
		for (Business x : contacts){
			System.out.println(i + ") " + x.toString());
			i++;
		}
		
		System.out.println("Selection: ");
		choice = input.nextInt();
		
		//check that the user selects a valid contact
		while (choice < 1 || choice > contacts.size()){
			System.out.println("Option invalid, pick again ");
			choice = input.nextInt();
		}
		
		//display the contacts job offers
		System.out.println("\t" + contacts.get(choice - 1).toString());
		contacts.get(choice - 1).viewJobOffers();
		
		System.out.println("Selection: ");
		job_offer = input.nextInt();
		
		//check that the job selected was a valid choice
		while (job_offer < 1 || job_offer > contacts.get(choice - 1).getJobOfferCount()){
			System.out.println("Invalid choice, try again: ");
			job_offer = input.nextInt();
		}
		
		//add the job to the players job list
		jobs.add(contacts.get(choice - 1).getJobOffer(job_offer - 1));
	}
	
	//method to display the options a player has and return a proper choice
	private int displayOptionMenu() {
		int choice = 0;
		
		System.out.println("1) Run on the Grid\n2) Visit the Black Market\n3) Add a job to the list\n4) Log off Console");
		System.out.println("Selection: ");
		choice = input.nextInt();
		
		while (choice < 1 || choice > 4){
			System.out.println("Option invalid, pick again ");
			choice = input.nextInt();
		}
		
		return choice;
	}

	private void updateToolKit(){
	/*
	 * updateToolKit: method to call buy a tool in black market and add a purchased tool
	 */
		Tool newTool;
		
		newTool = blackMarket.buyATool();
		
		if (newTool != null){
			toolKit.addOrUpdateTool(newTool);
		}
		
	}
	
	//method to display the jobs a player has to do and return a properly selected job to attack
	private Job pullAJob(){
		int i = 1;
		int choice;
		
		System.out.println();
		System.out.println("Jobs to do");
		
		for (Job x : jobs){
			System.out.println(i + ") " + x.toString());
			i++;
		}
		
		System.out.println("Selection:");
		choice = input.nextInt();
		
		while (choice < 1 || choice > jobs.size()){
			System.out.println("Option invlid, pick again ");
			choice = input.nextInt();
		}
		
		return jobs.get(choice - 1);
	}
	
	private boolean runOnTheGrid(int target_server, int possible_income){
	/*runOnTheGrid: will display the tools using the ToolKit class method 
	 * displayTools. Scan in the index of the tool (ERROR CHECK THE ENTERED INDEX). 
	 * Get the tool through the ToolKit class using getTool and decrement the player’s 
	 * money by the cost of the tool.If the run had a positive value returned add that to the player’s money and return true. If a negative value 
	 * decrement the player’s life by the returned value and return flse. Display the player’s info.
	 */
		//declare variables
		int toolChoice;
		int result = 0;
		
		//prompt user to pick a valid tool and check that user can afford it
		toolKit.displayTools();
		System.out.println("Pick your ice breaker: ");
		toolChoice = input.nextInt();
		while (toolChoice <= 0 || toolChoice > toolKit.getNumberOfTools()){
			System.out.println("Not a valid tool, enter your choice again: ");
			toolChoice = input.nextInt();
		}
		
		System.out.println();
		result = grid.attack(toolKit.getTool(toolChoice -1), target_server);
		System.out.println();
		
		//based on the outcome of the run on the grid update the players money if successful and update the players health if unsuccessful
		if (result < 0){
			player.updateHealth(result);
			return false;
		}
		
		else if (result > 0){
			player.updateMoney(result);
			return true;
		}
		else{
			System.out.println("Game Error");
			return false;
		}
	}
	
}

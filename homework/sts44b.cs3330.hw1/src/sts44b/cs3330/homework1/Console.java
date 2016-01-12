/*Name: Seanmichael Stanley
 * Lab:D
 * Homework 1
 * Date: 2/28/14
 * TA:Matt English
 */

package sts44b.cs3330.homework1;

import java.util.Random;
import java.util.Scanner;

//class to handle the game play
public class Console {
	
	//attributes for class Console
	private static final Scanner input = new Scanner(System.in);
	private Player player;
	private Grid grid;
	private ToolKit toolkit;
	
	public Console(Player player){
	/*Console constructor: will set the Player instance to the player 
	 * attribute and will call the init method. 
	 */
		setPlayer(player);
		init();
		
	}
	
	//method to create player
	private void setPlayer (Player player){
		this.player = player;
	}
	
	private void init(){
	/*init:  will instantiate a Grid object to the grid attribute, and will 
	instantiate a ToolKit object to the toolkit attribute.*/
		this.grid = new Grid();
		this.toolkit = new ToolKit();
	}
	
	public boolean use(){
	/*use: will instantiate a random generator to create random range 
	between the number of servers on the grid. The use method will 
	terminate when the player’s health is less or equal to zero.*/
		
		//keep going while player is still alive
		while (player.getHealth() > 0){
			
			//declare variables for this method
			int index = -1;
			String serv;
			String answer;
			
			//get a server to hack and check that it exists
			while (index == -1){
				displayRunOptions();
				answer = input.next();
				if (answer.toUpperCase().contains("Y")){
					System.out.println("Enter the address to server: ");
					serv = input.next();
					index = grid.search(serv);
					if (index == -1){
						System.out.println("Server not found!");
					}
				}
				//if server not found or if player doesnt want to enter one get a random server
				else{
					System.out.println("Pulling a random job");
					Random generator = new Random();
					index = generator.nextInt(grid.numberOfServers());
				}
			}
			
			//try to hack into the server
			runOnTheGrid(index);
		}
		
		//when player dies show that he has flatlined and return from use and console
		System.out.println(player.toString());
		return false;
	}
	
	private void updateToolKit(){
	/*updateToolKit: will call displayTools from the toolkit instance, 
	 * allowing the user to pick the tool to update (ERROR CHECK THE INDEX ENTERED). 
	 * Then ask the player how much to update (ERROR CHECK IF THE USER CAN UPDATE 
	 * THEIR TOOL WITH ENOUGH MONEY). Update the money of the player and update the tool.
	 */
		//declare variables for method
		int toolChoice;
		int upgrade;
		
		//show tools and prompt user to make a choice and check that choice is valid
		toolkit.displayTools();
		System.out.println("Pick your ice breaker: ");
		toolChoice = input.nextInt();
		while (toolChoice <= 0 && toolChoice > toolkit.getNumberOfTools()){
			System.out.println("Not a valid tool, enter your choice again: ");
			toolChoice = input.nextInt();
		}
		
		/*get a valid input from user on how much 
		to increase strength of a tool and make sure 
		the player can afford it and update the players money accordingly*/
		System.out.println();
		System.out.println("How much strength to add (each 1 additional cost 10,000 yen)?");
		upgrade = input.nextInt();
		
		while (upgrade <= 0){
			System.out.println("Enter a number greater that zero!");
			System.out.println("How much strength to add (each 1 additional cost 10,000 yen)?");
			upgrade = input.nextInt();
		}
		
		if (player.getMoney() > (upgrade*10000)){
			player.updateMoney(-(upgrade*10000));
			toolkit.updateTool(toolChoice - 1, upgrade);
		}
		else{
			System.out.println("Not enough funds");
			System.out.println();
		}
	}
	
	private void runOnTheGrid(int target_server){
	/*runOnTheGrid: will display the tools using the ToolKit class method 
	 * displayTools. Scan in the index of the tool (ERROR CHECK THE ENTERED INDEX). 
	 * Get the tool through the ToolKit class using getTool and decrement the player’s 
	 * money by the cost of the tool. (ERROR CHECK, IF THE UESER CAN USE A TOOL WITH HIS MONEY). 
	 * If the run had a positive value returned add that to the player’s money. If a negative value 
	 * is returned decrement the player’s life by the returned value. Display the player’s info.
	 */
		//declare variables
		int toolChoice;
		int cost;
		int result = 0;
		String answer = null;
		
		//prompt user to pick a valid tool and check that user can afford it
		toolkit.displayTools();
		System.out.println("Pick your ice breaker: ");
		toolChoice = input.nextInt();
		while (toolChoice <= 0 || toolChoice > toolkit.getNumberOfTools()){
			System.out.println("Not a valid tool, enter your choice again: ");
			toolChoice = input.nextInt();
		}
		
		cost = toolkit.getTool(toolChoice - 1).getCost();
		
		while (player.getMoney() < cost){
			System.out.println("Not enough funds!");
			
			System.out.println("Pick your ice breaker: ");
			toolChoice = input.nextInt();
			while (toolChoice < 0 || toolChoice > toolkit.getNumberOfTools()){
				System.out.println("Not a valid tool, enter your choice again: ");
				toolChoice = input.nextInt();
			}
			
			cost = toolkit.getTool(toolChoice - 1).getCost();
		}
		
		//update players money after buying tool
		player.updateMoney(-cost);
		
		System.out.println();
		result = grid.attack(toolkit.getTool(toolChoice -1), target_server);
		System.out.println();
		
		//based on the outcome of the run on the grid update the players money if successful and update the players health if unsuccessful
		if (result < 0){
			player.updateHealth(result);
		}
		
		else if (result > 0){
			player.updateMoney(result);
		}
		else{
			System.out.println("Game Error");
		}
		
		//only allow the player to update a tool if he has health and enough money
		if (player.getHealth() > 0 && player.getMoney() > 10000){
			System.out.println(player.toString());
			displayUpdateOptions();
			answer = input.next();
			
			if (answer.toUpperCase().contains("Y")){
				updateToolKit();
			}
		}	
	}
	
	private void displayRunOptions(){
	/*displayRunOptions: will display the following string to the player
	“Do you have a particular target server IP address to probe the grid? (yes/no): ”*/
		System.out.println("Do you have a particular target server IP address to probe the grid?(yes/no): ");
	}
	
	private void displayUpdateOptions(){
	/*displayUpdateOptions: will display the following string to the player
	“Would you like to update a tool in the toolkit? (yes/no): ”*/
		System.out.println("Would you like to update a tool in the toolkit? (yes/no): ");
	}
}

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
import java.util.Iterator;
import java.util.Scanner;

//class for buying new tools
public class BlackMarket extends Business{
	private ArrayList<Tool> tools;
	private static Scanner input;
	private Player buyer;
	
	
	//constructor to set the business attributes, player, and call load tools
	public BlackMarket(String name, String contact, Grid grid, Player buyer){
		super(name, contact, grid);
		this.setBuyer(buyer);
		this.loadTools();
	}
	
	//method to load the tools in the tools to buy file
	private void loadTools(){
		tools = new ArrayList<Tool>();
		String name;
		String type;
		int cost;
		int strength;
		
		try	{
			File	toolDataFile	=	new	File ("tools_to_buy.txt");
			input = new Scanner(toolDataFile);
			while (input.hasNextLine()){
				Scanner line = new Scanner(input.nextLine());
				line.useDelimiter(",");
				
				name = line.next();
				type = line.next();
				cost = Integer.parseInt(line.next());
				strength = Integer.parseInt(line.next());

			
				tools.add (new Tool(name, type, cost, strength));

				//close line scanner
				line.close();
			}
			
		}
		
		//if file was not found
		catch (FileNotFoundException e)	{	
			System.out.println("Error:	Tool file not found.");	
			System.exit(0); 
		 }	
	
	}
	
	
	//method to display the tools the user can buy
	public void viewToolsDatabase(){
		int i = 1;
		Iterator<Tool>	TIter = tools.iterator();
		while	(TIter.hasNext())	{
			Tool a = TIter.next();
			System.out.println("PN:"+ i + " " + "[" + a.toString() + "]");
			i++;
		}
	}
	
	
	//method to handle the buying a tool transaction
	public Tool buyATool(){
		int choice = 0;
		int numToolsBought = 0;
		
		this.viewToolsDatabase();
		
			Scanner scanner = new Scanner(System.in);
			
			//prompt user to enter a tool choice
			System.out.println("To cancel purchase enter -1");
			System.out.println("Selection: ");
			choice = Integer.parseInt(scanner.next());
			
			while (numToolsBought == 0){
				while (choice <= 0 || choice > tools.size()){
					if (choice == -1){
						if (numToolsBought == 0){
							System.out.println("No tool bought");
						}	
						return null;
					}
					
					//check that a valid choice was made
					System.out.println("Invalid choice, try again: ");
					choice = Integer.parseInt(scanner.next());
				}	
				
				//exit if the user entered -1
				if (choice == -1){
					if (numToolsBought == 0){
						System.out.println("No tool bought");
					}	
					return null;
				}
			
				/*let user know if the dont have 
				enough money to buy the tool but still 
				allow them to attempt another purchase*/
				if (buyer.getMoney() < tools.get(choice - 1).getCost()){
					System.out.println("Not enough money to buy ice breaker.");
				}
				
				else{
					numToolsBought++;
					break;
				}
				
				System.out.println("Selection: ");
				choice = Integer.parseInt(scanner.next());		
			}
			
			//update buyers money after buying a tool
			buyer.updateMoney(-tools.get(choice - 1).getCost());
			
			//return the purchased tool
			return tools.get(choice - 1);			
	}
	
	//set the buyer 
	private void setBuyer(Player buyer){
		this.buyer = buyer;
	}
	
	//to string for the blackmarket guy
	@Override
	public String toString(){
		return this.getContact() + this.getName();
	}
}

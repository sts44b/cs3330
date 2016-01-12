/*Name: Seanmichael Stanley
 * Lab:D
 * Homework 1
 * Date: 2/28/14
 * TA:Matt English
 */

package sts44b.cs3330.homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Grid class creates an arraylist of 
 * servers and has methods for accessing information in that list
 */
public class Grid {
	private ArrayList<Server> servers;
	
	//Constructor loads calls the method loadServers 
	public Grid(){
		loadServers();
	}
	
	//method loadServers creates an arraylist of servers from a specified server
	private void loadServers(){
		this.servers = new ArrayList<Server>();
		File	serverDataFile	=	new	File ("servers.txt");
		String name;
		String type;
		int strength;
		Scanner dataScanner = null;
		
		try	{
			//break lines of file out into items to be stored in each element of the arraylist
			dataScanner = new Scanner(serverDataFile);
			while (dataScanner.hasNextLine()){
				Scanner line = new Scanner(dataScanner.nextLine());
				line.useDelimiter(",");
				
				name = line.next();
				type = line.next();
				strength = Integer.parseInt(line.next());

			
				servers.add (new Server(name, type, strength));

				//close line scanner
				line.close();
			}
			
		}
		
		//if file was not found quit program
		catch (FileNotFoundException e)	{	
			System.out.println("Error:	Server file not found.");	
			System.exit(0); 
		 }	
		
	}
	
	//method to return the location of a named server or returns -1 if the element was not found
	public int search(String name){
		int searchName = servers.size();
		for (int i = 0; i < searchName; i++){
			if (servers.get(i).getName().equals(name)){
				return i;
			}
		}
		return -1;
	}
	
	//method to provide the number of servers in the arraylist
	public int numberOfServers(){
		return servers.size();
	}
	
	/*method to handle the attack on a server and return the proper outcome.
	 * successful runs return a monetary value to add to players money.
	 * failed runs return an amount to be deducted from a players health.
	 * each time a server is attacked its strength is updated to +3.
	*/
	public int attack(Tool tool, int server){
		
		System.out.println("ICE ENCOUTERED, ATTEMPTING TO BREAK IN...");
		
		if (tool.getType().equals("BASHER") && servers.get(server).getType().equals("UNENCRYPTED")){
			if(tool.getStrength() > servers.get(server).getStrength()){
				System.out.println(servers.get(server).toString());
				servers.get(server).updateStrength(3);
				System.out.println("RUN SUCCESSFUL");
				return 10000;
			}
			else{
				System.out.println(servers.get(server).toString());
				servers.get(server).updateStrength(3);
				System.out.println("RUN FAILURE");
				return -10;
			}
		}
		
		else if (tool.getType().equals("DECRYPTOR") && servers.get(server).getType().equals("ENCRYPTED")){
			if(tool.getStrength() > servers.get(server).getStrength()){
				System.out.println(servers.get(server).toString());
				servers.get(server).updateStrength(3);
				System.out.println("RUN SUCCESSFUL");
				return 25000;
			}
			else{
				System.out.println(servers.get(server).toString());
				servers.get(server).updateStrength(3);
				System.out.println("RUN FAILURE");
				return -20;
			}
		}
		
		else if (tool.getType().equals("DECRYPTOR") && servers.get(server).getType().equals("UNENCRYPTED")){
			System.out.println(servers.get(server).toString());
			servers.get(server).updateStrength(3);
			System.out.println("RUN FAILURE");
			return -30;
		}
		
		else if (tool.getType().equals("BASHER") && servers.get(server).getType().equals("ENCRYPTED")){
			System.out.println(servers.get(server).toString());
			servers.get(server).updateStrength(3);
			System.out.println("RUN FAILURE");
			return -30;
		}
		
		else{
			System.out.println("Unable to compare tool to server.");
			return 0;
		}
	}

}

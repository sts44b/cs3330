/*
 * Name: Seanmichael Stanley
 * Lab: Lab 3
 * Submission Code: put submission code in all classes
 * Date: 2/19/2014
 * TA: Matt English 
 */


package sts44b.cs3330.extLab3;

//class libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


//driver to run mortal kombat fight
public class MKDriver {
	public static void main(String[] args) {
		
		//declare variables for driver
		String name = null;
		int healthPoints = 0;
		Random generator = new Random();
		int hit;
		int distance;
		
		//print welcome
		System.out.println("!!!!!Welcome to Mortal Kombat!!!!!");
		System.out.println();
		
		//instantiate	Fighters.data FILE
		File	playerDataFile	=	new	File ("Fighters.data");
		
		Scanner	dataScanner	=	null;	
		
		//Instantiate an ArrayList object and store info in it:	
		ArrayList <Fighter> fighterList	=	new	ArrayList<Fighter>();	

		//display that fighter info is being loaded
		System.out.println("Loading Data...");
		
		try	{
			//scanner to read in data from file until all data has been loaded into the arraylist
			dataScanner = new Scanner(playerDataFile);
			while (dataScanner.hasNextLine()){
				
				Scanner line = new Scanner(dataScanner.nextLine());
				line.useDelimiter(",");
				
				
				name = line.next();
				healthPoints = Integer.parseInt(line.next());
	

			
				fighterList.add (new Fighter(name, healthPoints));

				//close line scanner
				line.close();
			}
			
		}
		
		//if file was not found
		catch (FileNotFoundException e)	{	
			System.out.println("Error:	Fighter	file not found.");	
			System.exit(0); 
		 }	
		
		//close dataScanner
		dataScanner.close();
		
		//print that loading was completed
		System.out.println("Loading Completed!!!!!");
		
		System.out.println();
		
		//print the list of arrays using an iterator:	
		Iterator<Fighter>	FIter = fighterList.iterator();
		System.out.println("Here's the list of Fighters: ");
		while	(FIter.hasNext())	{
			Fighter a = FIter.next();
			System.out.println(a.toString());	
		}
		
		//show that fight is about to begin
		System.out.println();
		System.out.println("3...2...1...Fight!!!");
		
		
		//loop to randomly deal out hits to fighters until one dies
		while (fighterList.size() == 2){
			
			System.out.println();
			
			hit = generator.nextInt(2);
			distance = (1 + generator.nextInt(10));
	
			fighterList.get(hit).beingHit(distance);
			
			if (fighterList.get(hit).isAlive == false){
				fighterList.remove(hit);
			}
		}
	
		//print the winner
		System.out.println();
		System.out.println("Round over...");
		System.out.println(fighterList.get(0).getName() + " has won!");
	
	//exit program
	System.exit(1);

	}
}
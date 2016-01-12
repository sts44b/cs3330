/*
 * Name: Seanmichael Stanley
 * Lab: Lab 3
 * Submission Code: 
 * Date: 2/17/2014
 * TA: Matt English 
 */

package sts44b.cs3330.lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner; 

public class CSGODriver {

	public static void main(String[] args) {
		String name = null;
		int health = 0;
		String weapon = null;
		String playerType = null;
		
		//instantiate	Players.data FILE
		File	playerDataFile	=	new	File ("Players.data");
		
		Scanner	dataScanner	=	null;	
		
		//Instantiate an ArrayList object and store info in it:	
		ArrayList <CounterTerrorist> counterTerrorList	=	new	ArrayList<CounterTerrorist>();	
		ArrayList <Terrorist> TerrorList	=	new	ArrayList<Terrorist>();	

		System.out.println("Loading Data...");
		
		try	{
			dataScanner = new Scanner(playerDataFile);
			while (dataScanner.hasNextLine()){
				
				Scanner line = new Scanner(dataScanner.nextLine());
				line.useDelimiter(",");
				
				
				name = line.next();
				health = Integer.parseInt(line.next());
				playerType = line.next();
				weapon = line.next();

				if (playerType.equals("Counter-Terrorist")){
					counterTerrorList.add (new CounterTerrorist (name, health, weapon));
				}

				else if (playerType.equals("Terrorist")){
					TerrorList.add (new Terrorist (name, health, weapon));
				}

				line.close();
			}
			
		}
		
		catch (FileNotFoundException e)	{	
			System.out.println("Error:	Player	stats	file	not	found.");	
			System.exit(0); 
		 }	
		
		dataScanner.close();
		
		System.out.println("Loading Completed!!!!!");
		
		System.out.println();
		
		//print the list of arrays using an iterator:	
		Iterator<CounterTerrorist>	CTIter = counterTerrorList.iterator();
		System.out.println("Here's the list of Counter-Terrorists: ");
		while	(CTIter.hasNext())	{
			CounterTerrorist a = CTIter.next();
			System.out.println(a.toString());	
		}
		
		System.out.println();
		
		Iterator<Terrorist>	TIter = TerrorList.iterator();
		System.out.println("Here's the list of Terrorists: ");
		while	(TIter.hasNext())	{
			Terrorist a = TIter.next();
			System.out.println(a.toString());
		}
		
	}

}

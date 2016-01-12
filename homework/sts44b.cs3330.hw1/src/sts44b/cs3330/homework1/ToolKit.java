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
import java.util.Iterator;
import java.util.Scanner;

/*
 * Class to handle arraylist of servers
 */
public class ToolKit{
	private ArrayList<Tool> tools;
	
	/*
	 * declare variables
	 */
	
	File	toolDataFile	=	new	File ("tools.txt");
	String name;
	String type;
	int cost;
	int strength;
	
	//call loadTools to populate the arraylis
	public ToolKit(){
		loadTools();
	}
	
	//fill arraylist with the various tools lited in a file
	private void loadTools(){
		Scanner dataScanner = null;
		this.tools = new ArrayList<Tool>();
		try	{
			dataScanner = new Scanner(toolDataFile);
			while (dataScanner.hasNextLine()){
				Scanner line = new Scanner(dataScanner.nextLine());
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
	
	//method to iterate through an arraylist and display the tools in it
	public void displayTools(){
		int i = 1;
		Iterator<Tool>	TIter = tools.iterator();
		while	(TIter.hasNext())	{
			Tool a = TIter.next();
			System.out.println(i + ") " + a.toString());
			i++;
		}
	}
	
	//method to return a tool at a specified index
	public Tool getTool(int tool_index){
		return tools.get(tool_index);
	}
	
	//method to return the number of tools in the arraylist
	public int getNumberOfTools(){
		return tools.size();
	}
	
	//method to update the strength of a tool
	public void updateTool(int tool_index, int additional_strength){
		tools.get(tool_index).updateStrength(additional_strength);
	}
}
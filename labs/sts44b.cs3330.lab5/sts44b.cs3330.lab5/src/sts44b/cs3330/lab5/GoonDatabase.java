/*
 * Name: Seanmichael Stanley 
 * Lab: Lab 5
 * Submission Code: Ukraine Civil War
 * Date: 3/6/2014
 * TA: Matt English 
 */

package sts44b.cs3330.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * This class handles most of the programs functions. This class includes a Constructor and functions to 
 * import the contents of a file and load the information into
 * a TreeMap, another function to prompt the user to enter a search query,
 * another function to search the TreeMap and return an arraylist of matching elements.
 */
public class GoonDatabase {
	
	/*TreeMap to hold information imported from a CSV file*/
	private TreeMap<String,Goon> goonDB = new TreeMap<String,Goon>();
	
	/*Constructor for GoonDatabase, takes in a filename and and passes it to the importFile function to 
	 * load its contents into the TreeMap.
	 */
	public GoonDatabase(String filename) {
		importFile(filename);
	}

	/*
	 * This function takes in a filename and fills a TreeMap with its contents or notifies the user
	 * that the file is empty.
	 */
	protected void importFile(String filename){
		
		/*
		 * Declared variables to accept values read from the file.
		 */
		String goon;
		String name;
		String DOB;
		String mobName;
		int netWorth;
		String skill;
		String sector;
		
		
		/*
		 * File received from the driver is assigned to a file variable
		 */
		File goonFile = new File (filename);
		
		Scanner	dataScanner	=	null;
	
		
		
	
		try	{
			//scanner to read in data from file until all data has been loaded into the TreeMap
			dataScanner = new Scanner(goonFile);
		
			//check to be sure that the file possesses information
			if (dataScanner.hasNextLine() == false){
				System.out.println("There is no record in your file!");
				System.exit(0);
			}
		
			//If the file has contents the information will be read in while there is still information to be read
			else{
				while (dataScanner.hasNextLine()){
			
					//New scanner to dissect each line that is read in
					Scanner line = new Scanner(dataScanner.nextLine());
					line.useDelimiter(",");
					
					//Assign information read in each line to variables
					goon = line.next();
					name = line.next();
					DOB = line.next();

					//If the line has information regarding a Don, create a new Don element
					if (goon.equals("Don")){
						mobName = line.next();
						netWorth = Integer.parseInt(line.next());
						goonDB.put(goon + name, new Don(name, DOB, mobName, netWorth));
					}
			
					//If the line has information regarding a Talent, create a new Talent element
					else if (goon.equals("Talent")){
						skill = line.next();
						goonDB.put(goon + name, new Talent(name, DOB, skill));

					}
			
					//If the line has information regarding an Overseer, create a new Overseer element
					else if (goon.equals("Overseer")){
						sector = line.next();
						goonDB.put(goon + name, new Overseer(name, DOB, sector));
					}
			
					//If the information is not formatted as anticipated then inform the user that it cannot be added.
					else{
						System.out.println("Unable to add goon.");
					}
			
					//close line scanner
					line.close();
				}
		
			}
		
		}
	
		//if file was not found
		catch (FileNotFoundException e)	{	
			System.out.println("Error shape	file not found.");	
			System.exit(0); 
		}
		
		//Inform the user that the file's contents were imported
		System.out.println("Import Complete.");
		System.out.println();
		dataScanner.close();
	}
	
	/*Function to prompt user to enter a search query and return results. 
	 * Keep prompting the user for a new query until the user decides to quit.
	 */
	public void searchMenu(){
		//initialize the query so that it can enter the while loop
		String query = "a";
		//scanner to read input from user
		Scanner scanner = new Scanner(System.in);
		//arraylist to accept the arraylist returned by the searchDatabase function
		ArrayList<Goon> searchResults = new ArrayList<Goon>();

		
		//loop to keep accepting new search queries until user quits
		while (!query.toUpperCase().equals("Q")){
			
			//ask user to enter a search query
			System.out.println("Please enter your query (q to exit):");
			query = scanner.next();
			
			if (!query.toUpperCase().equals("Q")){ 
				searchResults = searchDatabase(query);
				
				//inform user if there were no results matching the search query
				if(searchResults.size() == 0){
					System.out.println("No results found...");
					System.out.println();
				}
				
				//display results of the search query by displaying the names of the entries added to the arraylist
				else if(searchResults.size() >= 1){
					System.out.println("Results:");
					int i = 1;
					Iterator<Goon> SIter = searchResults.iterator();
					while	(SIter.hasNext())	{
						Goon a = SIter.next();
						System.out.println(i + " - " + a.getName());
						i++;
					}
					System.out.println();
				}	
			}
		}
		//close input scanner
		scanner.close();
	}
	
	
	

	/*
	 * function to take in a search query and look through the TreeMap for matches.
	 * If a matching entry is found, add it to an arraylist
	 */
	protected ArrayList<Goon> searchDatabase(String query){
		ArrayList<Goon> searchResults = new ArrayList<Goon>();
		for(Map.Entry<String,Goon> entry : goonDB.entrySet()) {
			if (entry.getKey().toUpperCase().contains(query.toUpperCase())){
				searchResults.add(entry.getValue());
			}
		}
		//return the arraylist
		return searchResults;
	}	
}

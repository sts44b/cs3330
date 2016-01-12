/*
 * Name: Seanmichael Stanley
 * TA: matt English
 * section D
 * 3/17/14
 * labcode: Bioprocess
 */


package sts44b.cs3330.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Database {
	private Employee[] empDB;
	private int counter;
	private static Scanner userInput;
	
	public Database (String inputFile){
		userInput = new Scanner(System.in);
		int counter = 0;
		importFile(inputFile);
	}
	
	protected void importFile(String inputFile){
		/*
		 * Declared variables to accept values read from the file.
		 */
		String empType;
		String name;
		int SSN;
		String department;
		int netWorth;
		String langOfProf;
		String sector;
		
		
		/*
		 * File received from the driver is assigned to a file variable
		 */
		File employeeData = new File (inputFile);
		
		Scanner	dataScanner	=	null;
	
		
		
	
		try	{
			//scanner to read in data from file until all data has been loaded into the TreeMap
			dataScanner = new Scanner(inputFile);
		
			//check to be sure that the file possesses information
			if (dataScanner.hasNextLine() == false){
				System.out.println("There is no record in your file!");
				System.exit(0);
			}
		
			//If the file has contents the information will be read in while there is still information to be read
			else{
				for(counter = 0; counter < 10; counter++){
			
					//New scanner to dissect each line that is read in
					Scanner line = new Scanner(dataScanner.nextLine());
					line.useDelimiter(",");
					
					//Assign information read in each line to variables
					empType = line.next();
					name = line.next();
					SSN = Integer.parseInt(line.next());

					//If the line has information regarding a Don, create a new Don element
					if (empType.equals("CEO")){
						/*mobName = line.next();
						netWorth = Integer.parseInt(line.next());
						goonDB.put(goon + name, new Don(name, DOB, mobName, netWorth));
					*/}
			
					//If the line has information regarding a Talent, create a new Talent element
					else if (empType.equals("Manager")){
						/*skill = line.next();
						goonDB.put(goon + name, new Talent(name, DOB, skill));

					*/}
			
					//If the line has information regarding an Overseer, create a new Overseer element
					else if (empType.equals("Developer")){
					/*	sector = line.next();
						goonDB.put(goon + name, new Overseer(name, DOB, sector));
					*/}
			
					//If the information is not formatted as anticipated then inform the user that it cannot be added.
					else{
						System.out.println("Unable to add goon.");
					}
			
					//close line scanner
					line.close();
				}
		
			}
		
		
	}
	
	public void searchMenu(){
		
	}
	
	protected Employee[] searchDatabase(String){
		
	}
}

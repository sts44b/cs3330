/*
 * Name: Seanmichael Stanley
 * Lead TA: Matt English
 * Lab Section: D
 * Date: 3/31/14
 * Lab 7
 * Labcode: Opening Day
 */

package sts44b.cs3330.lab7;



import java.util.ArrayList;
import java.util.Scanner;

/*
 * Driver class to handle user inputs and check for errors
 */
public class Driver {
	public static void main(String[] args) {
		//Declare variables for this method
		Scanner scanner = new Scanner(System.in);
		ArrayList<Person> people = new ArrayList<Person>();
		String name = null;
		String age = null;
		String bankAccountBalance = null;
		
		//Keep executing code until user decides to quit
		while (true) {
			
			//Try to execute code and catch errors
			try{
				//prompt user for a person's name
				System.out.println("Enter person info or q to quit");
				System.out.println("Please enter the name of this person: ");
				name = scanner.nextLine();
			
				//if the user enters q exit while loop and end program
				if (name.equals("q")) {
					break;
				}
			
				//check that name is valid with isName() method
				isName(name);
				
				//prompt user for the person's age
				System.out.println("Please enter an age for this person: ");
				age = scanner.nextLine();
				
				//check that the user entered a valid age with the isValidAge() method
				isValidAge(String.valueOf(age));
				
				//prompt the user for the person's bank account balance
				System.out.println("Please enter a bank account balance for this person: ");
				bankAccountBalance = scanner.nextLine();
				
				//check that the user entered a valid balance with the isBalance() method
				isBalance(bankAccountBalance);
				
				//add a person object to the ArrayList
				people.add(new Person(name, Integer.parseInt(age), Double.parseDouble(bankAccountBalance)));
			} 
				
			//catch an invalid name
			catch (InvalidNameException e) {
				System.out.println(e);
				continue;
			}
			
			//catch an invalid age
			catch (InvalidAgeException e) {
				System.out.println(e);
				continue;
			}
			
			//catch an invalid balance
			catch (InvalidBalanceException e) {
				System.out.println(e);
				continue;
			}
			
		
		}	
		
		//print the ArrayList when the user exits
		for (Person p : people)
		{
			System.out.println();
			System.out.println(p.toString());
	
		}
		
		//close scanner and end program
		scanner.close();
		System.exit(0);
	}

	
	
	public static void isBalance(String input) throws InvalidBalanceException{
	/*This method will additionally check to make sure that 
	 * the string passed to this function is indeed a double. 
	 * This will necessitate a try-catch inside of this method. 
	 * Remember that you can run any arbitrary code in a catch block. 
	 */
		//if the user does not enter a value throw an error
		if (input.isEmpty()){
			throw new InvalidBalanceException ("You did not enter a balance.");
		}
		
		try{
			Double.parseDouble(input);
		}
		
		//if the user did not enter an integer throw an error
		catch (NumberFormatException e) {
			throw new InvalidBalanceException ("You did not enter a double.");
		}
		
			
		
	}
	
	public static void isValidAge(String input) throws InvalidAgeException{
	/*This method will additionally check to make sure that the 
	 * age is not <=0 OR >= 150. If so, you should throw the exception 
	 * with two different messages alerting the user to which check they 
	 * failed. Check the sample output to understand this. 
	 */
		//if the user did not enter a value throw an error
		if (input.isEmpty()){
			throw new InvalidAgeException ("You did not enter an age.");
		}
		
		try{
			int x = 0;
			x = Integer.parseInt(input);
			
			//if the user enters an integer less than or equal to 0 throw an error
			if (x <= 0){
				throw new InvalidAgeException ("You cannot be 0 or negative.");
			}
			
			//if the user enters a value greater than or equal to 150 throw an error
			if (x >= 150){
				throw new InvalidAgeException ("You cannot be equal to or greater than 150");
			}
		}
		
		//if the user did not enter an integer throw an error
		catch (NumberFormatException e){
			throw new InvalidAgeException ("You did not enter a valid age.");
		}
	}
	
	
	public static void isName(String input) throws InvalidNameException{
	/*This method will additionally check to make sure that 
	 * the string inputted by the user is a valid name. Names 
	 * CAN contain spaces but should NOT contain anything else 
	 * that is not a letter. For the purposes of this lab assume 
	 * that we will only test English letters. 
	 */
		//if the user did not enter a name throw an error
		if (input.isEmpty()){
			throw new InvalidNameException ("You did not enter a name.");
		}
		
		//if the user enters anything other than a letter or space throw an error
		String[] arr=input.split(" ");
		for(int i=0;i<arr.length;i++){
			char[] temp=arr[i].toCharArray();
			for(int j=0;j<temp.length;j++){
				if(Character.isDigit(temp[j]) || !Character.isLetter(temp[j])){
					throw new InvalidNameException("You entered an invalid name.");
				}
				
			}
		}
		
	}

}	


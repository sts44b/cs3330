package sts44b.cs3330.lab2;

import java.util.Scanner; 
 
public class Lab2Driver { 
 public static void main(String[] args) { 
 Scanner scanner = new Scanner(System.in); 
 System.out.println("How many people?"); 
 int entries = Integer.parseInt(scanner.nextLine()); 
 int smith = 0;
 
 //Create an array of objects of type Person. 
 Person[] people = new Person[entries]; 
 
 /* 
 Loop to gather input and instantiate 
 Person objects depending on what the user inputs. 
 */ 
 
 	for(int i = 1; i <= entries; i++){
 		
 		//Prompt user for a name
 		System.out.println("Enter the name of Person " + i + ": ");
 		String name = scanner.nextLine();
 	
 		//crate new array element with the information gathered
 		people[i-1] = new Person(name); 
 		
 		//count the number of smiths
 		if(people[i-1].getName().endsWith("Smith")){
 			++smith;
 		}
 	}
 	
 	for (int i = 0; i < entries; i++){
 		if(people[i].getName().startsWith("Dr.")){
 			System.out.println("Hello " + people[i].getName() + ", congratulations on the Ph.D!");
 		}
 		else if (people[i].getName().startsWith("Mr.")){
 			System.out.println(people[i].getName() + " begins with Mr.");
 		}
 		else if (people[i].getName().startsWith("Ms.")){
 			System.out.println(people[i].getName() + " begins with Ms.");
 		}
 		else if (people[i].getName().startsWith("Mrs.")){
 			System.out.println(people[i].getName() + " begins with Mrs.");
 		}
 		else{
 			System.out.println("Hello " + people[i].getName());
 		}
 		
 		if (people[i].getName().length() > 15){
 			System.out.println("You have a long name " + people[i].getName());
 		}
 		
 		if (people[i].getName().length() < 5){
 			System.out.println("You have a short name " + people[i].getName());
 		}
 	}
 	
 	
 		
	//print the number of smiths	
	System.out.println("There were " + smith + " Smiths in this array.");

	
 scanner.close(); 
 System.exit(0); 
 }
} 
/*************************************	
	* Name:	Seanmichael Stanley
	* Lab: 4
	* Section: 1D	
	* Date:	2/24/14	
	* Description:
	* Submission	Code:	Russia won the olympics :(	
	**************************************/
package sts44b.cs3330.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyShapeDriver{	
	public static void main(String[] args){
	
		String shapeName;
		double majorAxis;
		double minorAxis;
		double length;
		double width;
		double radius;
		int key = 1;
	
		File	shapeDataFile	= new File ("shapes.csv");
	
		Scanner	dataScanner	=	null;
	
		HashMap<Integer,Shape> shapeMap = new HashMap<Integer,Shape>();
	
	
		try	{
			//scanner to read in data from file until all data has been loaded into the arraylist
			dataScanner = new Scanner(shapeDataFile);
		
			if (dataScanner.hasNextLine() == false){
				System.out.println("There is no record in your csv file!");
				System.exit(0);
			}
		
			else{
				while (dataScanner.hasNextLine() && key <= 10){
			
			
					Scanner line = new Scanner(dataScanner.nextLine());
					line.useDelimiter(",");
							
					shapeName = line.next();

			
					if (shapeName.equals("Ellipse")){
						System.out.println("Storing Ellipse in the Hashmap at position: " + key);
						majorAxis = Double.parseDouble(line.next());
						minorAxis = Double.parseDouble(line.next());

						shapeMap.put (key, new Ellipse(majorAxis, minorAxis));
					}
			
					else if (shapeName.equals("Circle")){
						System.out.println("Storing Circle in the Hashmap at position: " + key);
						radius = Double.parseDouble(line.next());
	
						shapeMap.put (key, new Circle(radius));			
					}
			
					else if (shapeName.equals("Rectangle")){
						System.out.println("Storing Rectangle in the Hashmap at position: " + key);
						length = Double.parseDouble(line.next());
						width = Double.parseDouble(line.next());
				
						shapeMap.put (key, new Rectangle(length, width));
					}
			
					else if (shapeName.equals("Square")){
						System.out.println("Storing Square in the Hashmap at position: " + key);
						length = Double.parseDouble(line.next());
					
						shapeMap.put(key, new Square(length));
					}
			
					else{
						System.out.println("Unable to add shape to hash map.");
					}
			
					key++;
					if(key == 11){
						System.out.println();
						System.out.println("There are more shapes in the file, but it skips the rest since hashmap is full!");
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
		System.out.println();
		
		System.out.println("**************************************");
		System.out.println("Your shape hasmap contains:");
		
		for (Map.Entry<Integer,Shape> entry : shapeMap.entrySet()){
			System.out.println();
			System.out.println("Shape " + entry.getKey() + " is: " + entry.getValue());
		}
		System.exit(0);
	}
}
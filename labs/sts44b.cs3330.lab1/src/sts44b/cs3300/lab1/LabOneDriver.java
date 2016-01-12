package sts44b.cs3300.lab1;

/*
 * @author Seanmichael Stanley
 * LAB: D
 * Date: 2/3/14
 * Code: Pratfall
 */

import java.util.Scanner;


public class LabOneDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter number one:  ");
		
		double num_1 = input.nextDouble();
	
		System.out.println("Enter number two:  ");
		
		double num_2 = input.nextDouble();
		
		SimpleCalc a = new SimpleCalc(num_1, num_2);
		
		double sum = a.addNumbers();
		
		double diff = a.subtractNumbers();
		
		double product = a.multiplyNumbers();
		
		double quotient = a.divideNumbers();
		
		System.out.println("The addition of these two numbers is " + sum);
		System.out.println("The subtraction of these two numbers is " + diff);
		System.out.println("The product of these two numbers is " + product);
		System.out.println("The division of these two numbers is " + quotient);
		
		System.out.println("Program finished");
		
		input.close();
		
		System.exit(0);
	}
		

}

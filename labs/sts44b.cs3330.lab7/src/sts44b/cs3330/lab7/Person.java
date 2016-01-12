/*
 * Name: Seanmichael Stanley
 * Lead TA: Matt English
 * Lab Section: D
 * Date: 3/31/14
 * Lab 7
 * Labcode: Opening Day
 */

package sts44b.cs3330.lab7;

//Class to create Person objects
public class Person {
	//declare variables for Person class
	private String name;
	private int age;
	private double bankAccountBalance;
	
	//constructor sets name, age, and bankAccountBalance
	public Person(String name, int age, double bankAccountBalance){
		this.setName(name);
		this.setAge(age);
		this.setBankAccountBalance(bankAccountBalance);
	}
	
	//Setters and Getters for Person class name, age, and bankAccountBalance
	private void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	private void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return this.age;
	}
	
	private void setBankAccountBalance(double bankAccountBalance){
		this.bankAccountBalance = bankAccountBalance;
	}
	
	
	//Overridden toString() method to display Person objects
	@Override
	public String toString(){
		return "Name: " + name + "\nBank Balance: " + bankAccountBalance + "\nAge: " + age;
	}

}

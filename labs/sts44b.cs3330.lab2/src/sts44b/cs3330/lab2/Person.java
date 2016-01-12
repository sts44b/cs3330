package sts44b.cs3330.lab2;

public class Person {
	private String name;
	
	public Person(String name){
		setName(name);
	}
	
	public String getName(){
		return this.name;
	}
	
	private void setName(String name){
		this.name = name;
	}
	

}

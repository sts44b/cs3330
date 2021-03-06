/*Name: Seanmichael Stanley 
 * Lab:D
 * Homework 1
 * Date: 2/28/14
 * TA:Matt English
 */



package sts44b.cs3330.homework1;

import java.util.Scanner;

/*
 * Program driver for a game to hack into servers with tools
 */
public class CyberPunk {

	public static void main(String[] args) {
		//declare variables for class
		String name;
		Scanner scanner = new Scanner(System.in);
		
		//prompt user to enter name
		System.out.println("Enter your Name: ");
		name = scanner.nextLine();
		
		//Create a player
		Player p = new Player(name);
		
		//Display that game is starting and show players status
		System.out.println("The year is 2077");
		System.out.println(p.toString());
		System.out.println("Starting Console");
		
		//begin game by  Console 
		Console c = new Console(p);
		
		
		//when players health reaches 0 game is over
		if (c.use() == false){
			System.out.println("GAME OVER");
		}
		
		//close scanner and exit
		scanner.close();
		System.exit(0);
	}

}

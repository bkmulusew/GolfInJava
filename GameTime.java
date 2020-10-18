/*
 * Name: Beakal Lemeneh
 * Net ID: 31390484
 * Project Number: 02
 * Lab section: Mon/Wed 4:50 pm-6:05 pm
 * I did not collaborate with anyone on this project.

*/

import java.util.*;
public class GameTime {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);

		int continueOrNot = 1;
		
		while (continueOrNot == 1) {
			
			// A variable with a class of GeneseeValleyCourse declared.
			GeneseeValleyCourse gValley = new GeneseeValleyCourse();
			
			// A variable with a class of StAndrewsOldCourse declared.
			StAndrewsOldCourse stAndrew = new StAndrewsOldCourse();
			
			// Welcomes to the game and asks the player in what course he/she wants to play.
			System.out.println("Welcome to TTY Golf!");
			System.out.print("\nPlease select a course: \n1. Genesee Valley Park North Course \n2. The Old Course at St. Andrews \nYour choice [1-2]: ");
			int inputNum = scnr.nextInt();
			
			// If input = 1, then the player plays in Genesee Valley Park North Course.
			if (inputNum == 1) {
				gValley.gameGenesee();
			
			}
			// If input = 2, then the player plays in The Old Course at St. Andrews.
			else if (inputNum == 2) {
				stAndrew.gameAndrew();
			
			}
			// Else, it prints an error statement.
			else {
				System.out.println("\nERROR!!! WRONG INPUT!!!");
			
			}
			// Asks if the user wants to play a new round.
			// If yes, then the program continues looping till the user quits.
			System.out.print("\nWould you like to start a new round? Press 1 if yes: ");
			continueOrNot = scnr.nextInt();
			
		}
		// Printed when the user quits the game.
		System.out.println("\nTHANK YOU FOR PLAYING THE GAME!!!");

	}

}

/*
 * Name: Beakal Lemeneh
 * Net ID: 31390484
 * Project Number: 02
 * Lab section: Mon/Wed 4:50 pm-6:05 pm
 * I did not collaborate with anyone on this project.

*/
import java.util.*;

// A class that defines The Old Course at St. Andrews.
public class StAndrewsOldCourse {
	
	// Hole numbers in The Old Course at St. Andrews in the form of an array.
	static int[] holeAndrew = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
	
	// Distance of the tee from the each hole in yards in The Old Course at St. Andrews in the form of an array.
	static int[] yardsAndrew = {376, 453, 397, 480, 568, 412, 371, 175, 352, 386, 174, 348, 465, 618, 455, 423, 495, 357};
	
	// Max number of pars allowed to put ball into the each hole in The Old Course at St. Andrews in the form of an array.
	static int[] parAndrew = {4, 4, 4, 4, 5, 4, 4, 3, 4, 4, 3, 4, 4, 5, 4, 4, 4, 4};
			
		// A variable of class Clubs declared.
		static Clubs a = new Clubs();
		
		// A variable of class PuttPower declared.
		static PuttPower b = new PuttPower();
		
		static Scanner scan = new Scanner(System.in);
		static Random random = new Random();
		static int i = 0; // Index number. Corresponds to the number of holes.
		static int stroke = 1; // Used to store the number of shots made to put the ball in each hole. 
		static int totalStroke = 0; // Used to store the score for the round. 
		
		// Variable tempYard assigned with the value of the distance of the tee from each hole in yards in The Old Course at St. Andrews using an index from the array.
		static int tempYard = yardsAndrew[i]; 
		
		
		// A method called gameAndrew defined.
		public static void gameAndrew() {
			
			// Lets the player know that they are in The Old Course at St. Andrews.
			System.out.println("\nYou are playing at The Old Course at St. Andrews.");		
			i = 0;
			totalStroke = 0;
			
			outerloop:
			// i < 18, because there are only 18 holes in a round.
			while (i < 18) {
				
				stroke = 1;
				tempYard = yardsAndrew[i];
				System.out.print("\nYou're on tee number " + holeAndrew[i] + ". ");
				System.out.println("" + tempYard + " yards, " + " par " + parAndrew[i]);
				
				
				innerloop:
				while (true) {
					
					System.out.println("\nShot number " + stroke); // Lets the player know the number of shots made.
					System.out.println("You are " + tempYard + " yards away from the hole."); // Lets the player how far he/she is from the hole.
					
					// Lets the player choose their club and power number.
					System.out.print("Choose your club [1-10]: ");
					int choiceClub = scan.nextInt();
					System.out.print("Power [1-10]: ");
					int choicePow = scan.nextInt(); 
					
					// Calculates the amount of distance the ball went in yards.
					int mean = a.clubMeanYards[choiceClub - 1];
					int stddev = a.clubStdDevYards[choiceClub - 1];
					double mean_adj = mean * choicePow / 10.0;
					double stddev_adj = stddev * choicePow / 10.0;
					double val = Math.abs(random.nextGaussian() * stddev_adj + mean_adj);
					val = (int) val;
					
					System.out.println("\nYou hit the ball " + val + " yards."); // Lets the user know how far the ball went.
					
					// Calculates the remaining distance left to score the ball.
					tempYard -= val;
					tempYard = Math.abs(tempYard);
					
					// Checks if the remaining distance is less than 20 yards.
					// If so, calls another method called Putter().
					if (tempYard < 20) {
						stroke++; // Increases the shot number by one.
						tempYard *= 3; // Changes the remaining distance left to score the ball from yards into feet.
						System.out.println("You are on the green."); // Notifies the user that there on a place called green, which is very close to the hole.
						Putter();
						
						// Calculates the amount of par by comparing the max number of pars allowed to put ball into the hole using index i to the shots made.
						// Then notifies the user the par by printing it on the screen and updates the variable totalStroke, which the stores the total score for the round.
						if (stroke > parAndrew[i]) {
							System.out.println("\nYou made " + (stroke - parAndrew[i]) + " over par on this hole.");
							totalStroke += (stroke - parAndrew[i]);
							
						}
						else if (stroke == parAndrew[i]) {
							System.out.println("\nYou made a over par on this hole.");
							
						}
						else {
							System.out.println("\nYou made " + (parAndrew[i] - stroke) + " under par on this hole.");
							totalStroke -= (parAndrew[i] - stroke);
							
						}
						
						// Asks the user if he/she wants to continue the game once the user score the ball.
						System.out.print("Do you want to continue to the next hole? Press 1 if yes: ");
						int userResp = scan.nextInt();
						
						// Continues the game if the player presses 1 and quits the game if the player presses any other character.
						if (userResp == 1) {
							break innerloop;
							
						}
						else{
							break outerloop;
							
						}
				
					}
					
					// If the remaining distance isn't less than 20 yards, then it continues till the remaining distance is 20 yards using the while loop;
					else {
						stroke++; // Increases the shot number by one.
						continue;
					
					}

				}
				++i; // Increases the index number for every loop.
			
			}
			// The player know that they've completed the round if i = 17, since it corresponds to the last hole.
			if (i == 17) {
				System.out.println("\nYou have completed the round.");
				
				// Lets the user know the total par for the round.
				if (totalStroke < 0) {
					System.out.println("\nYour final score for the round is: " + Math.abs(totalStroke) + " under. Good job!");
					
				}
				else if (totalStroke > 0){
					System.out.println("\nYour final score for the round is: " + totalStroke + " over.");
					
				}
				else {
					System.out.println("\nYour final score for the round is: a par. Good job!");
					
				}			
			
			}
		
		}
		
		// A method called Putter defined.
		// Determines the behaviour of the games once the ball is less than 20 yards from the hole.
		public static void Putter() {
			while (true) {
				System.out.println("\nShot number " + stroke); // Shows the shot number.
				System.out.println("You are " + tempYard + " feet away from the hole."); // Lets the user know how far he/she is from the hole.
				
				// Lets the player choose the power used to put the ball into the put.
				System.out.print("Choose your putt power [1-10]: ");
				int putPow = scan.nextInt();
				
				// Calculates the amount of distance the ball went in feet.
				double puttMean = b.putPowMeanFt[putPow - 1];
				double puttStddev = b.putPowStdDevFt[putPow - 1];
				double puttMean_adj = puttMean * putPow / 10.0;
				double puttMtddev_adj = puttStddev * putPow / 10.0;
				double puttVal = Math.abs(random.nextGaussian() * puttMtddev_adj + puttMean_adj);
				puttVal = (int) puttVal;
				
				System.out.println("\nYou hit the ball " + puttVal + " feet."); // Lets the user know far the ball went in ft.
				
				// Limits the distance that the ball goes to 60 ft.
				if (puttVal > 60) {
					puttVal = 60;
					
				}
				
				// Calculates the remaining distance left to score the ball.
				tempYard -= puttVal;
				tempYard = Math.abs(tempYard);
				
				// If the remaining distance is less than or equal to 1 ft, then the ball is in the hole.
				if (tempYard <= 1) {
					System.out.println("It’s in the hole!");
					break;
					
				}
				// If the remaining distance is not less than or equal to 1 ft, then it continues the game till remaining distance is less than or equal to 1 ft using the while loop..
				else {
					stroke++;
					continue;
					
				}
			}
		}
	
}

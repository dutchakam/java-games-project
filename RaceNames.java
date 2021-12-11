import java.util.Scanner;
public class RaceNames
{
	// global variables can easily be used in any method:
	private static String name1 = "Alex";
	private static String name2 = "Adam";
	private static String name3 = "Mike";
	private static String spaces = "                     ";
	//*** this Scanner can be used throughout the class.
	private static Scanner scan = new  Scanner(System.in);
	//*** This method controls two while loops. The outer loop allows the game to 
	//*** be played repeatedly.  The inner loop is the game.
	public static void raceNames() throws InterruptedException
	{
		// main method
		int introSelection;
		
		introSelection = introduction();
		
		while (introSelection != 2)
		{
			announceTheWinner();
			introSelection = playAgain();
			
			name1 = "Alex";
			name2 = "Adam";
			name3 = "Mike";
		}
	}
	private static int introduction()
	{
		// introduction method. Describes the game and prompts user to start the game
		int introSelection;
		System.out.println(spaces + "Thanks for choosing to play the Names Race!");
		System.out.println(spaces + "This game races 3 names. The random number generator\n" 
				+ spaces + "from the Math class repeatedly gives each name a random number\n" 
				+ spaces + "between 1 and 5. As the names move these random distances\n" 
				+ spaces + "we see which name gets to the finish line first.");
		System.out.println(spaces + "Enter 1 to start the race or 2 to exit the game.\n");
		introSelection = scan.nextInt();
		while (introSelection != 1 && introSelection != 2)
		{
			System.out.println(spaces + "Invalid selection. Enter 1 to start the race or 2 to exit the game.\n");
			introSelection = scan.nextInt();
		}
		return introSelection;
	}
	private static int diceRoll()
	{
		// simple method to return an integer for a die roll
		int numRolled = (int)((Math.random() * 5) + 1);
		return numRolled;
	}
	private static void raceTheNames() throws InterruptedException
	{
		// more complex method for actually playing the game
		int numMoves1, numMoves2, numMoves3;
		
		// create the race track
		String finish1 = "                                                                                      " + 
				"                                           |      ";
		String finish2 = "                                                                                      " + 
				"                                           |      ";
		String finish3 = "                                                                                      " + 
				"                                           |      ";
		
		// set index for ending the race
		int stopTheRace = finish1.length() - 2;
		
		// print the field
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("          " + "The race begins!\n");
		System.out.println("          " + name1 + finish1);
		System.out.println("          " + name2 + finish2);
		System.out.println("          " + name3 + finish3);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		Thread.sleep(1000);
		
		// algorithm for the race
		// while the index of each name is less than the index of the end of the race: play the game
		while (name1.length() < stopTheRace && name2.length() < stopTheRace && name3.length() < stopTheRace)
		{
			int numberRolled1 = diceRoll();
			int numberRolled2 = diceRoll();
			int numberRolled3 = diceRoll();
			
			// for loops to add spaces according the number rolled on the die
			for (numMoves1 = 0; numMoves1 <= numberRolled1; numMoves1 ++)
			{
				name1 = " " + name1;
			}
			for (numMoves2 = 0; numMoves2 <= numberRolled2; numMoves2 ++)
			{
				name2 = " " + name2;
			}
			for (numMoves3 = 0; numMoves3 <= numberRolled3; numMoves3 ++)
			{
				name3 = " " + name3;
			}
			// re-adjust the remainder of the race track
			finish1 = finish1.substring(0 + numberRolled1 + 1, finish1.length());
			finish2 = finish2.substring(0 + numberRolled2 + 1, finish2.length());
			finish3 = finish3.substring(0 + numberRolled3 + 1, finish3.length());
			
			// print the field
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("          " + "The race continues!\n");
			System.out.println("          " + name1 + finish1);
			System.out.println("          " + name2 + finish2);
			System.out.println("          " + name3 + finish3);
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
			Thread.sleep(1000);
		}
	}
	private static void announceTheWinner() throws InterruptedException
	{
		// method for deciding the winner of the race
		// first, run the race:
		raceTheNames();
		
		// if else statement to measure the distance traveled by each name and decide winner
		if (name1.length() > name2.length() && name1.length() > name3.length())
		{
			System.out.println("          " + name1.replace(" ", "") + " is the winner!\n\n");
		}
		else if (name2.length() > name1.length() && name2.length() > name3.length())
		{
			System.out.println("          " + name2.replace(" ", "") + " is the winner!\n\n");
		}
		else if (name3.length() > name1.length() && name3.length() > name2.length())
		{
			System.out.println("          " + name3.replace(" ", "") + " is the winner!\n\n");
		}
		else if (name1.length() > name3.length() && name2.length() > name3.length() && name1.length() == name2.length())
		{
			System.out.println("          The race is a tie between " + name1.replace(" ", "") + " and " + name2.replace(" ", "") + "\n\n");
		}
		else if (name2.length() > name1.length() && name3.length() > name1.length() && name2.length() == name3.length())
		{
			System.out.println("          The race is a tie between " + name2.replace(" ", "") + " and " + name3.replace(" ", "") + "\n\n");
		}
		else if (name1.length() > name2.length() && name3.length() > name2.length() && name1.length() == name3.length())
		{
			System.out.println("          The race is a tie between " + name1.replace(" ", "") + " and " + name3.replace(" ", "") + "\n\n");
		}
		else
		{
			System.out.println("          Unable to declare a winner.\n\n");
		}
	}
	private static int playAgain()
	{
		// simple method to prompt user to play the game again
		int playAgain;
		System.out.println(spaces + "Enter 1 to race the names again, or 2 to quit playing.\n");
		playAgain = scan.nextInt();
		while (playAgain != 1 && playAgain != 2)
		{
			System.out.println(spaces + "Invalid selection. Enter 1 to race again or 2 to quit playing.\n");
			playAgain = scan.nextInt();
		}
		return playAgain;
	}
}
















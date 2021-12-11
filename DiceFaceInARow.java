import java.text.NumberFormat;
import java.util.Scanner;
public class DiceFaceInARow
{
	//*** These variables can be seen throughout the class.
	//*** They can be very useful when you need the same value
	//*** in several places.
	private static String spaces = "                     ";
	//*** this Scanner can be used throughout the class.
	private static NumberFormat format = NumberFormat.getInstance();
	private static Scanner scan = new  Scanner(System.in);
	//*** This method controls two while loops. The outer loop allows the game to 
	//*** be played repeatedly.  The inner loop is the game.
	public static void diceFaceInARow() throws InterruptedException
	{
		int introSelection, playOption;
		
		introSelection = introduction();
		
		while (introSelection != 2)
		{
			playOption = howToPlay();
			
			switch (playOption)
			{
			case 1:
				traceTheGame();
				break;
			case 2:
				showAnswerOnly();
				break;
			default:
				System.out.println(spaces + "Invalid Entry. Please Try Again: \n");
				break;
			}
			introSelection = playAgain();
			
		}
		System.out.println(spaces + spaces + "GAME OVER\n\n\n\n");
	}
	
	private static int introduction()
	{
		int introSelection;
		System.out.println(spaces + "Welcome to the game 'Dice Face In A Row!'\n\n");
		System.out.println(spaces + "In this game you will choose a face number \n" +
				spaces + "that you would like to see.");
		System.out.println(spaces + "You will then choose how many times in a row \n" + 
				spaces + "you would like to see it appear.");
		System.out.println(spaces + "Enter 1 to play the game or 2 to quit: \n");
		introSelection = scan.nextInt();
		while (introSelection != 1 && introSelection != 2)
		{
			System.out.println(spaces + "Invalid Entry. Enter 1 to play the game or 2 to quit: \n");
			introSelection = scan.nextInt();
		}
		return introSelection;
	}
	
	private static int readInput1()
	{
		int dieFaceNumber;
		System.out.println(spaces + "Choose a face number from 1 - 6 inclusive: \n");
		dieFaceNumber = scan.nextInt();
		while (dieFaceNumber < 1 || dieFaceNumber > 6)
		{
			System.out.println(spaces + "Your choice must be from 1 - 6 inclusive.\n" + 
					spaces + "Please try again: \n");
			dieFaceNumber = scan.nextInt();
		}
		return dieFaceNumber;
	}
	
	private static int readInput2()
	{
		int userNumInARow;
		System.out.println(spaces + "How many times in a row would you like to see your number appear?\n");
		userNumInARow = scan.nextInt();
		while (userNumInARow < 2)
		{
			System.out.println(spaces + "Choosing anything less than 2 defeats\n" 
					+ spaces + "the purpose" 
					+ " of this game. Please choose a higher number: \n");
			userNumInARow = scan.nextInt();
		}
		return userNumInARow;
	}
	
	private static int howToPlay()
	{
		int playOption;
		System.out.println(spaces + "Please enter the method you prefer: \n");
		System.out.println(spaces + "    1) Trace the game.\n" + spaces 
				+ "    2) Just show the answer.\n");
		playOption = scan.nextInt();
		while (playOption != 1 && playOption != 2)
		{
			System.out.println(spaces + "You must choose either option 1 or option 2.\n");
			playOption = scan.nextInt();
		}
		return playOption;
	}
	
	private static int playAgain()
	{
		int introSelection;
		System.out.println(spaces + "Would you like to play again?\n" + spaces +
				"    1) Yes\n" + spaces + "    2) No\n");
		introSelection = scan.nextInt();
		while (introSelection != 1 && introSelection != 2)
		{
			System.out.println(spaces + "Invalid Entry. Enter 1 to play the game or 2 to quit: \n");
			introSelection = scan.nextInt();
		}
		return introSelection;
	}
	
	private static void traceTheGame()
	{
		int dieRoll, numInARow = 0, count = 0;
		int dieFaceNumber = readInput1();
		int userNumInARow = readInput2();
		while (numInARow < userNumInARow)
		{
			dieRoll = (int)((Math.random() * 6) + 1);
			System.out.println(spaces + "You rolled a " + dieRoll);
			if (dieRoll == dieFaceNumber)
			{
				numInARow ++;
			}
			else
			{
				numInARow = 0;
			}
			count ++;
			System.out.println(spaces + "Number of times in a row so far: " + numInARow);
			System.out.println(spaces + "Total number of rolls: " + format.format(count) + "\n");
		}
		System.out.println(spaces + "It took " + format.format(count) + " rolls to get " 
				+ "the number " + dieFaceNumber + " to appear " + 
				userNumInARow + " times in a row.\n\n");
	}
	
	private static void showAnswerOnly()
	{
		int dieRoll, numInARow = 0, count = 0;
		int dieFaceNumber = readInput1();
		int userNumInARow = readInput2();
		while (numInARow < userNumInARow)
		{
			dieRoll = (int)((Math.random() * 6) + 1);
			if (dieRoll == dieFaceNumber)
			{
				numInARow ++;
			}
			else
			{
				numInARow = 0;
			}
			count ++;
		}
		System.out.println(spaces + "It took " + format.format(count) + " rolls to get " 
				+ "the number " + dieFaceNumber + " to appear " + 
				userNumInARow + " times in a row.\n\n");
	}
	
}
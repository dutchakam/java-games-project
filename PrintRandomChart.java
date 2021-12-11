import java.util.Scanner;
public class PrintRandomChart
{
	private static String spaces = "                     ";
	private static Scanner scan = new  Scanner(System.in);
	//*** This method controls two while loops. The outer loop allows the game to 
	//*** be played repeatedly.  The inner loop is the game.
	public static void printRandomChart() throws InterruptedException
	{
		int numberOfRolls, playTheGame, rollTheDie, count = 0;
		
		introduction();
		playTheGame = playAgain();
		
		while (playTheGame == 1)
		{
			String rolled1 = "Dice number 1: ";
			String rolled2 = "Dice number 2: ";
			String rolled3 = "Dice number 3: ";
			String rolled4 = "Dice number 4: ";
			String rolled5 = "Dice number 5: ";
			String rolled6 = "Dice number 6: ";
			
			numberOfRolls = numRolls();
			while (count < numberOfRolls)
			{	
				rollTheDie = rollTheDie();
				if (rollTheDie == 1)
				{
					rolled1 += "*";
				}
				else if (rollTheDie == 2)
				{
					rolled2 += "*";
				}
				else if (rollTheDie == 3)
				{
					rolled3 += "*";
				}
				else if (rollTheDie == 4)
				{
					rolled4 += "*";
				}
				else if (rollTheDie == 5)
				{
					rolled5 += "*";
				}
				else
				{
					rolled6 += "*";
				}
				count ++;
			}
			System.out.println(spaces + "      After " + count + " rolls of the die,");
			System.out.println(spaces + "      the Random Chart appears as follows: \n\n");
			System.out.println(spaces + rolled1);
			System.out.println(spaces + rolled2);
			System.out.println(spaces + rolled3);
			System.out.println(spaces + rolled4);
			System.out.println(spaces + rolled5);
			System.out.println(spaces + rolled6 + "\n\n\n");
			
			System.out.println(spaces + "Would you like to play again? (yes or no)\n");
			playTheGame = playAgain();
			count = 0;
		}
		System.out.println(spaces + "You have chosen to exit the game. Farewell!!!\n\n");
	}
	private static void introduction()
	{
		System.out.println("\n\n\n" + spaces + "Welcome to the Print Random Chart game!!\n\n");
		System.out.println(spaces + "This game requests a number from the player.");
		System.out.println(spaces + "The game then throws the dice that number of times.");
		System.out.println(spaces + "The game then displays a chart showing the number of \n" + 
				spaces + "times the six dice faces appeared given \n" + spaces + 
				"the number of throws.\n\n");
		System.out.println(spaces + "Would you like to get started? (yes or no)");
	}
	private static int playAgain()
	{
		int selection = 0;
		String playTheGame;
		playTheGame = scan.next().toLowerCase();
		if (playTheGame.equals("yes"))
		{
			selection = 1;
		}
		else if (playTheGame.equals("no"))
		{
			selection = 2;
		}
		else
		{
			System.out.println(spaces + "Invalid Selection. Please try again.\n");
			playAgain();
		}
		return selection;
	}
	private static int numRolls()
	{
		int numberOfRolls = 0;
		System.out.println(spaces + "How many times would you like to roll the die?\n");
		numberOfRolls = scan.nextInt();
		return numberOfRolls;
	}
	private static int rollTheDie()
	{
		int faceNumber = (int)((Math.random() * 6) + 1);
		return faceNumber;
		
	}
}

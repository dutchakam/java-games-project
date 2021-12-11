import java.text.NumberFormat;
import java.util.Scanner;
public class PatternOfSix
{
	private static String spaces = "                     ";
	//*** this Scanner can be used throughout the class.
	private static NumberFormat format = NumberFormat.getInstance();
	private static Scanner scan = new  Scanner(System.in);
	//*** This method controls two while loops. The outer loop allows the game to 
	//*** be played repeatedly.  The inner loop is the game.
	public static void patternOfSix() throws InterruptedException
	{
		int introSelection = introduction();
		
		while (introSelection != 2)
		{
			runTheGame();
			introSelection = playAgain();
		}
		
		
	}
	private static int introduction()
	{
		int introSelection;
		System.out.println(spaces + "Welcome to the game 'Pattern Of Six!'\n\n");
		System.out.println(spaces + "In this game you will choose a pattern of \n" + 
				spaces + "6 consecutive face numbers that you would like to see.");
		System.out.println(spaces + "The die will then be rolled until that pattern appears!");
		System.out.println(spaces + "Enter 1 to play the game or 2 to quit: \n");
		introSelection = scan.nextInt();
		while (introSelection != 1 && introSelection != 2)
		{
			System.out.println(spaces + "Invalid Entry. Enter 1 to play the game or 2 to quit: \n");
			introSelection = scan.nextInt();
		}
		return introSelection;
	}
	private static String readPattern()
	{
		String pattern;
		System.out.println(spaces + "Please enter the 6 number pattern you would \n" + 
				spaces + "you would like the computer to throw separated by spaces.\n");
		scan.nextLine();
		pattern = scan.nextLine();
		while (pattern.length() != 11)
		{
			System.out.println(spaces + "Your input was invalid. Please enter only 6 numbers\n" 
					+ spaces + "and be sure they are separated by spaces.");
			pattern = scan.nextLine();
		}
		return pattern;
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
	private static void runTheGame()
	{
		int count = 0, numInARow = 0;
		String pattern = readPattern();
		
		while (numInARow < 6)
		{
			int index = 0;
			while (index < 10)
			{
				int patternSub = Integer.parseInt(pattern.substring(index, index + 1));
				int diceRoll = (int)((Math.random() * 6) + 1);
				count ++;
				
				if (diceRoll == patternSub)
				{
					numInARow ++;
					index += 2;
				}
				else
				{
					numInARow = 0;
					index = 0;
				}
				//System.out.println(patternSub + ", " + diceRoll + ", " + count);
			}
			
		}
		System.out.println(spaces + "It took " + format.format(count) + " throws to get the pattern " 
				+ pattern);
	}
	
}
		
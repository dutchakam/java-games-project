import java.util.Scanner;
public class MenuClass
{

	static int endGame;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException
	{
		int userChoice = 0;
		endGame = 7;
		menuIntroduction();
		while (userChoice != endGame)
		{
			presentMenu();
			userChoice = readSelection();
			switch (userChoice)
			{
			case 1:
				PrintRandomChart.printRandomChart();
				break;
			case 2:
				DiceFaceInARow.diceFaceInARow();
				break;
			case 3:
				PatternOfSix.patternOfSix();
				break;
			case 4:
				RaceNames.raceNames();
				break;
			case 5:
				ComputeGeometricShapes.computeGeometricShapes();
				break;
			case 6:
				TicTacToe.ticTacToe();
				break;
			case 7:
				System.out.println("\n\n                You have chosen to exit the menu."
						+ " Goodbye!\n");
				userChoice = endGame;
				break;
			default:
				System.out.println("\n\n                Invalid Selection."
						+ " Please try again.\n");
				break;
			}
		}
		

	}
	private static void menuIntroduction()
	{
		System.out.println("\n\n                Welcome to the Games Mothership!\n");
		System.out.println("                From this hub you can choose between "
				+ "6 different games.\n\n");
		
	}
	private static void presentMenu()
	{
		System.out.println("\n\n                Their are 6 games available for play:\n\n");
		System.out.println("                Enter the number of the game you wish to play.\n");
		System.out.println("                1. Print Random Chart");
		System.out.println("                2. Dice Face In A Row");
		System.out.println("                3. Pattern Of Six");
		System.out.println("                4. Race Names");
		System.out.println("                5. Compute Geometric Shapes");
		System.out.println("                6. Tic Tac Toe");
		System.out.println("                7. Exit The Game Menu");
	}
	private static int readSelection()
	{
		int choiceNumber;
		choiceNumber = scan.nextInt();
		while (choiceNumber < 1 || choiceNumber > endGame)
		{
			System.out.println("\n\n                Entry must be a number from 1 to 6."
					+ " Please try again:\n");
			choiceNumber = scan.nextInt();
		}
		return choiceNumber;
	}

}

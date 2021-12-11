import java.util.Scanner;
public class TicTacToe
{
	private static int firstPlay = 0;
	private static String boardColumns = "  1   2   3 ";
	private static String boardTopRows = "A___|___|___";
	private static String boardMidRows = "B___|___|___";
	private static String boardBottoms = "C___|___|___";
	private static String spaces = "                     ";
	//*** this Scanner can be used throughout the class.
	private static Scanner scan = new  Scanner(System.in);
	//*** This method controls two while loops. The outer loop allows the game to 
	//*** be played repeatedly.  The inner loop is the game.
	public static void ticTacToe() throws InterruptedException
	{
		// main method. Resets the board at the end
		String playAgain = "yes";
		
		introduction();
		
		while (playAgain.equalsIgnoreCase("yes"))
		{
			printBoard();
			Thread.sleep(1000);
			
			gamePlay();
			
			playAgain = playAgain();
			
			boardColumns = "  1   2   3 ";
			boardTopRows = "A___|___|___";
			boardMidRows = "B___|___|___";
			boardBottoms = "C___|___|___";
		}
	}
	private static void introduction()
	{
		// basic introduction method with no prompt
		System.out.println("\n\n\n" + spaces + "           Tic Tac Toe Game\n");
		System.out.println(spaces + "This game is played between you and the computer.");
		System.out.println(spaces + "You move first and the computer will then move.");
		System.out.println(spaces + "Play continues until you or the computer wins or");
		System.out.println(spaces + "it is a 'cat's' game.\n");
	}
	private static String playAgain()
	{
		// prompt user to play the game again 
		String playAgain;
		System.out.println(spaces + "Would you like to play Tic Tac Toe again?\n" + spaces + "          (yes/no)\n");
		playAgain = scan.nextLine();
		while (!playAgain.equalsIgnoreCase("yes") && !playAgain.equalsIgnoreCase("no"))
		{
			System.out.println(spaces + "Invalid Selection. Please enter yes or no.\n");
			playAgain = scan.nextLine();
		}
		return playAgain;
	}
	private static void printBoard()
	{
		// print the board. Having a separate method for this makes life easier
		System.out.println(spaces + boardColumns);
		System.out.println(spaces + boardTopRows);
		System.out.println(spaces + boardMidRows);
		System.out.println(spaces + boardBottoms.replace("_", " ") + "\n\n\n"); // to make the board look right
		
	}
	private static void gamePlay() throws InterruptedException
	{
		// main method for game play
		if (firstPlay % 2 == 0) // if statement to decide who starts the game based on even/odd numbers
		{
			boolean itIsMyTurn = true; // boolean decides whose turn it is
			
			while ((!isThereAWinner()) && (!checkDraw())) // while game is not over
			{
				if (itIsMyTurn) // my turn
				{
					iChooseAMove();
					printBoard();
					itIsMyTurn = false;
					Thread.sleep(1000);
				}
				else // computer's turn
				{
					computerChoosesAMove();
					printBoard();
					itIsMyTurn = true;
					Thread.sleep(1000);
				}
			}
			if (isThereAWinner()) // checking for a winner
			{
				if (!itIsMyTurn)
				{
					System.out.println(spaces + "The Player is the winner!\n\n");
				}
				else
				{
					System.out.println(spaces + "The Computer is the winner!\n\n");
				}
			}
			else if (checkDraw()) // checking for a draw
			{
				System.out.println(spaces + "No winner, it is a Cat's game.\n\n");
			}
			firstPlay ++; // incrementing our variable so that the program knows to let the next player start the game
		}
		else // now since firstPlay is odd, it is the computer's turn to START the game
		{
			boolean itIsMyTurn = false;
			
			while ((!isThereAWinner()) && (!checkDraw()))
			{
				if (itIsMyTurn)
				{
					iChooseAMove();
					printBoard();
					itIsMyTurn = false;
					Thread.sleep(1000);
				}
				else
				{
					computerChoosesAMove();
					printBoard();
					itIsMyTurn = true;
					Thread.sleep(1000);
				}
			}
			if (isThereAWinner())
			{
				if (!itIsMyTurn)
				{
					System.out.println(spaces + "The Player is the winner!\n\n");
				}
				else
				{
					System.out.println(spaces + "The Computer is the winner!\n\n");
				}
			}
			else if (checkDraw())
			{
				System.out.println(spaces + "No winner, it is a Cat's game.\n\n");
			}
			firstPlay ++;
		}
	}
	private static void iChooseAMove()
	{
		// method for letting the player choose a move
		String myMove;
		System.out.println(spaces + "Please enter your move.\n");
		myMove = scan.nextLine();
		
		while (!myMove.equalsIgnoreCase("a1") && 
			   !myMove.equalsIgnoreCase("a2") && 
			   !myMove.equalsIgnoreCase("a3") && 
			   !myMove.equalsIgnoreCase("b1") && 
			   !myMove.equalsIgnoreCase("b2") && 
			   !myMove.equalsIgnoreCase("b3") && 
			   !myMove.equalsIgnoreCase("c1") && 
			   !myMove.equalsIgnoreCase("c2") && 
			   !myMove.equalsIgnoreCase("c3"))
		{
			System.out.println(spaces + "Invalid selection. Please try again.\n");
			myMove = scan.nextLine();
		}
		switch (myMove) // switch statement decides which square to play in based on user input
		{
		// use substring String method to recreate the board with the appropriate character
		case "a1":
			boardTopRows = boardTopRows.substring(0,2) + "X" + boardTopRows.substring(3);
			break;
		case "a2":
			boardTopRows = boardTopRows.substring(0,6) + "X" + boardTopRows.substring(7);
			break;
		case "a3":
			boardTopRows = boardTopRows.substring(0,10) + "X" + boardTopRows.substring(11);
			break;
		case "b1":
			boardMidRows = boardMidRows.substring(0,2) + "X" + boardMidRows.substring(3);
			break;
		case "b2":
			boardMidRows = boardMidRows.substring(0,6) + "X" + boardMidRows.substring(7);
			break;
		case "b3":
			boardMidRows = boardMidRows.substring(0,10) + "X" + boardMidRows.substring(11);
			break;
		case "c1":
			boardBottoms = boardBottoms.substring(0,2) + "X" + boardBottoms.substring(3);
			break;
		case "c2":
			boardBottoms = boardBottoms.substring(0,6) + "X" + boardBottoms.substring(7);
			break;
		case "c3":
			boardBottoms = boardBottoms.substring(0,10) + "X" + boardBottoms.substring(11);
			break;
		}
	}
	private static void computerChoosesAMove()
	{
		// method for letting the computer make a move
		System.out.println(spaces + "It's the computer's move.\n");
		
		// if else statement allows the computer to check if it can win or if the player is about to win
		// then it can make a SMART play
		if (checkNearDiagonalWin("O"))
		{
			blockDiagonalWin("O");
		}
		else if (checkNearHorizontalWin("O"))
		{
			blockHorizontalWin("O");
		}
		else if (checkNearVerticalWin("O"))
		{
			blockVerticalWin("O");
		}
		else if (checkNearDiagonalWin("X"))
		{
			blockDiagonalWin("X");
		}
		else if (checkNearHorizontalWin("X"))
		{
			blockHorizontalWin("X");
		}
		else if (checkNearVerticalWin("X"))
		{
			blockVerticalWin("X");
		}
		else
		{
			randomMove();
		}
	}
	private static void randomMove()
	{
		// method for allowing the computer to make a random move. Is only used in the first 1 or 2 plays
		// this method is long, but based on simple logic
		boolean isValid = true;
		
		while (isValid) // checking to see if the move is valid (doesn't overlap)
		{
			int computerMoveRow = (int)((Math.random() * 3) + 1); // generate random numbers between 1 and 3
			int computerMoveCol = (int)((Math.random() * 3) + 1);
			
			if (computerMoveRow == 1) // if row 1, switch statement for columns
			{
				switch (computerMoveCol)
				{
				case 1:
					if (boardTopRows.substring(2,3).equals("_"))
					{
						boardTopRows = boardTopRows.substring(0,2) + "O" + boardTopRows.substring(3);
						isValid = false;
					}
					else
					{
						isValid = true;
					}
					break;
				case 2:
					if (boardTopRows.substring(6,7).equals("_"))
					{
						boardTopRows = boardTopRows.substring(0,6) + "O" + boardTopRows.substring(7);
						isValid = false;
					}
					else
					{
						isValid = true;
					}
					break;
				case 3:
					if (boardTopRows.substring(10,11).equals("_"))
					{
						boardTopRows = boardTopRows.substring(0,10) + "O" + boardTopRows.substring(11);
						isValid = false;
					}
					else
					{
						isValid = true;
					}
					break;
				}
			}
			else if (computerMoveRow == 2) // if row 2, switch statement for columns
			{
				switch (computerMoveCol)
				{
				case 1:
					if (boardMidRows.substring(2,3).equals("_"))
					{
						boardMidRows = boardMidRows.substring(0,2) + "O" + boardMidRows.substring(3);
						isValid = false;
					}
					else
					{
						isValid = true;
					}
					break;
				case 2:
					if (boardMidRows.substring(6,7).equals("_"))
					{
						boardMidRows = boardMidRows.substring(0,6) + "O" + boardMidRows.substring(7);
						isValid = false;
					}
					else
					{
						isValid = true;
					}
					break;
				case 3:
					if (boardMidRows.substring(10,11).equals("_"))
					{
						boardMidRows = boardMidRows.substring(0,10) + "O" + boardMidRows.substring(11);
						isValid = false;
					}
					else
					{
						isValid = true;
					}
					break;
				}
			}
			else // if row 3, switch statement for columns
			{
				switch (computerMoveCol)
				{
				case 1:
					if (boardBottoms.substring(2,3).equals("_"))
					{
						boardBottoms = boardBottoms.substring(0,2) + "O" + boardBottoms.substring(3);
						isValid = false;
					}
					else
					{
						isValid = true;
					}
					break;
				case 2:
					if (boardBottoms.substring(6,7).equals("_"))
					{
						boardBottoms = boardBottoms.substring(0,6) + "O" + boardBottoms.substring(7);
						isValid = false;
					}
					else
					{
						isValid = true;
					}
					break;
				case 3:
					if (boardBottoms.substring(10,11).equals("_"))
					{
						boardBottoms = boardBottoms.substring(0,10) + "O" + boardBottoms.substring(11);
						isValid = false;
					}
					else
					{
						isValid = true;
					}
					break;
				}
			}
		}
	}
	private static boolean checkNearDiagonalWin(String play) // smart PC code
	{
		// checking for 2 in a row diagonally
		String topLeft = boardTopRows.substring(2,3);
		String topRight = boardTopRows.substring(10,11);
		String middle = boardMidRows.substring(6,7);
		String bottomLeft = boardBottoms.substring(2,3);
		String bottomRight = boardBottoms.substring(10,11);
		
		// long, encompassing boolean statements make this code frustrating
		if (((topLeft.equals(play)) && (middle.equals(play)) && (bottomRight.equals("_"))) || 
				((bottomRight.equals(play)) && (middle.equals(play)) && (topLeft.equals("_"))) ||
				((topLeft.equals(play)) && (bottomRight.equals(play)) && (middle.equals("_"))))
		{
			return true;
		}
		else if (((topRight.equals(play)) && (middle.equals(play)) && (bottomLeft.equals("_"))) || 
					((bottomLeft.equals(play)) && (middle.equals(play)) && (topRight.equals("_"))) ||
					((topRight.equals(play)) && (bottomLeft.equals(play)) && (middle.equals("_"))))
		{
			return true;
		}
		return false;
	}
	private static void blockDiagonalWin(String play) // smart PC code
	{
		// method to block or finish a diagonal win
		String topLeft = boardTopRows.substring(2,3);
		String topRight = boardTopRows.substring(10,11);
		String middle = boardMidRows.substring(6,7);
		String bottomLeft = boardBottoms.substring(2,3);
		String bottomRight = boardBottoms.substring(10,11);
		
		if (topLeft.equals(play) && middle.equals(play) && bottomRight.equals("_"))
		{
			boardBottoms = boardBottoms.substring(0,10) + "O" + boardBottoms.substring(11);
		}
		else if (topLeft.equals("_") && middle.equals(play) && bottomRight.equals(play))
		{
			boardTopRows = boardTopRows.substring(0,2) + "O" + boardTopRows.substring(3);
		}
		else if (topLeft.equals(play) && middle.equals("_") && bottomRight.equals(play))
		{
			boardMidRows = boardMidRows.substring(0,6) + "O" + boardMidRows.substring(7);
		}
		else if (topRight.equals(play) && middle.equals(play) && bottomLeft.equals("_"))
		{
			boardBottoms = boardBottoms.substring(0,2) + "O" + boardBottoms.substring(3);
		}
		else if (topRight.equals("_") && middle.equals(play) && bottomLeft.equals(play))
		{
			boardTopRows = boardTopRows.substring(0,10) + "O" + boardTopRows.substring(11);
		}
		else if (topRight.equals(play) && middle.equals("_") && bottomLeft.equals(play))
		{
			boardMidRows = boardMidRows.substring(0,6) + "O" + boardMidRows.substring(7);
		}
	}
	private static boolean checkNearHorizontalWin(String play) // smart PC code
	{
		// checking for 2 in a row horizontally
		String topLeft = boardTopRows.substring(2,3);
		String topMiddle = boardTopRows.substring(6,7);
		String topRight = boardTopRows.substring(10,11);
		String left = boardMidRows.substring(2,3);
		String middle = boardMidRows.substring(6,7);
		String right = boardMidRows.substring(10,11);
		String bottomLeft = boardBottoms.substring(2,3);
		String bottomMiddle = boardBottoms.substring(6,7);
		String bottomRight = boardBottoms.substring(10,11);
		
		if (((topLeft.equals(play)) && (topMiddle.equals(play)) && (topRight.equals("_"))) ||
				((topRight.equals(play)) && (topMiddle.equals(play)) && (topLeft.equals("_"))) ||
				((topLeft.equals(play)) && (topRight.equals(play)) && (topMiddle.equals("_"))))
		{
			return true;
		}
		else if (((left.equals(play)) && (middle.equals(play)) && (right.equals("_"))) ||
					((right.equals(play)) && (middle.equals(play)) && (left.equals("_"))) ||
					((left.equals(play)) && (right.equals(play)) && (middle.equals("_"))))
		{
			return true;
		}
		else if (((bottomLeft.equals(play)) && (bottomMiddle.equals(play)) && (bottomRight.equals("_"))) ||
					((bottomRight.equals(play)) && (bottomMiddle.equals(play)) && (bottomLeft.equals("_"))) ||
					((bottomLeft.equals(play)) && (bottomRight.equals(play)) && (bottomMiddle.equals("_"))))
		{
			return true;
		}
		return false;
	}
	private static void blockHorizontalWin(String play) // smart PC code
	{
		// block or finish a near horizontal win
		String topLeft = boardTopRows.substring(2,3);
		String topMiddle = boardTopRows.substring(6,7);
		String topRight = boardTopRows.substring(10,11);
		String left = boardMidRows.substring(2,3);
		String middle = boardMidRows.substring(6,7);
		String right = boardMidRows.substring(10,11);
		String bottomLeft = boardBottoms.substring(2,3);
		String bottomMiddle = boardBottoms.substring(6,7);
		String bottomRight = boardBottoms.substring(10,11);
		
		if (topLeft.equals(play) && topMiddle.equals(play) && topRight.equals("_"))
		{
			boardTopRows = boardTopRows.substring(0,10) + "O" + boardTopRows.substring(11);
		}
		else if (topLeft.equals("_") && topMiddle.equals(play) && topRight.equals(play))
		{
			boardTopRows = boardTopRows.substring(0,2) + "O" + boardTopRows.substring(3);
		}
		else if (topLeft.equals(play) && topMiddle.equals("_") && topRight.equals(play))
		{
			boardTopRows = boardTopRows.substring(0,6) + "O" + boardTopRows.substring(7);
		}
		else if (left.equals(play) && middle.equals(play) && right.equals("_"))
		{
			boardMidRows = boardMidRows.substring(0,10) + "O" + boardMidRows.substring(11);
		}
		else if (left.equals("_") && middle.equals(play) && right.equals(play))
		{
			boardMidRows = boardMidRows.substring(0,2) + "O" + boardMidRows.substring(3);
		}
		else if (left.equals(play) && middle.equals("_") && right.equals(play))
		{
			boardMidRows = boardMidRows.substring(0,6) + "O" + boardMidRows.substring(7);
		}
		else if (bottomLeft.equals(play) && bottomMiddle.equals(play) && bottomRight.equals("_"))
		{
			boardBottoms = boardBottoms.substring(0,10) + "O" + boardBottoms.substring(11);
		}
		else if (bottomLeft.equals("_") && bottomMiddle.equals(play) && bottomRight.equals(play))
		{
			boardBottoms = boardBottoms.substring(0,2) + "O" + boardBottoms.substring(3);
		}
		else if (bottomLeft.equals(play) && bottomMiddle.equals("_") && bottomRight.equals(play))
		{
			boardBottoms = boardBottoms.substring(0,6) + "O" + boardBottoms.substring(7);
		}
	}
	private static boolean checkNearVerticalWin(String play) // smart PC code
	{
		// method to check for 2 in a row vertically
		String topLeft = boardTopRows.substring(2,3);
		String topMiddle = boardTopRows.substring(6,7);
		String topRight = boardTopRows.substring(10,11);
		String left = boardMidRows.substring(2,3);
		String middle = boardMidRows.substring(6,7);
		String right = boardMidRows.substring(10,11);
		String bottomLeft = boardBottoms.substring(2,3);
		String bottomMiddle = boardBottoms.substring(6,7);
		String bottomRight = boardBottoms.substring(10,11);
		
		if (((topLeft.equals(play)) && (left.equals(play)) && (bottomLeft.equals("_"))) ||
				((bottomLeft.equals(play)) && (left.equals(play)) && (topLeft.equals("_"))) ||
				((topLeft.equals(play)) && (bottomLeft.equals(play)) && (left.equals("_"))))
		{
			return true;
		}
		else if (((topMiddle.equals(play)) && (middle.equals(play)) && (bottomMiddle.equals("_"))) ||
					((bottomMiddle.equals(play)) && (middle.equals(play)) && (topMiddle.equals("_"))) ||
					((topMiddle.equals(play)) && (bottomMiddle.equals(play)) && (middle.equals("_"))))
		{
			return true;
		}
		else if (((topRight.equals(play)) && (right.equals(play)) && (bottomRight.equals("_"))) ||
					((bottomRight.equals(right)) && (right.equals(play)) && (topRight.equals("_"))) ||
					((topRight.equals(play)) && (bottomRight.equals(play)) && (right.equals("_"))))
		{
			return true;
		}
		return false;
	}
	private static void blockVerticalWin(String play) // smart PC code
	{
		// method to block or finish a vertical win
		String topLeft = boardTopRows.substring(2,3);
		String topMiddle = boardTopRows.substring(6,7);
		String topRight = boardTopRows.substring(10,11);
		String left = boardMidRows.substring(2,3);
		String middle = boardMidRows.substring(6,7);
		String right = boardMidRows.substring(10,11);
		String bottomLeft = boardBottoms.substring(2,3);
		String bottomMiddle = boardBottoms.substring(6,7);
		String bottomRight = boardBottoms.substring(10,11);
		
		if (topLeft.equals(play) && left.equals(play) && bottomLeft.equals("_"))
		{
			boardBottoms = boardBottoms.substring(0,2) + "O" + boardBottoms.substring(3);
		}
		else if (topMiddle.equals(play) && middle.equals(play) && bottomMiddle.equals("_"))
		{
			boardBottoms = boardBottoms.substring(0,6) + "O" + boardBottoms.substring(7);
		}
		else if (topRight.equals(play) && right.equals(play) && bottomRight.equals("_"))
		{
			boardBottoms = boardBottoms.substring(0,10) + "O" + boardBottoms.substring(11);
		}
		else if (topLeft.equals("_") && left.equals(play) && bottomLeft.equals(play))
		{
			boardTopRows = boardTopRows.substring(0,2) + "O" + boardTopRows.substring(3);
		}
		else if (topMiddle.equals("_") && middle.equals(play) && bottomMiddle.equals(play))
		{
			boardTopRows = boardTopRows.substring(0,6) + "O" + boardTopRows.substring(7);
		}
		else if (topRight.equals("_") && right.equals(play) && bottomRight.equals(play))
		{
			boardTopRows = boardTopRows.substring(0,10) + "O" + boardTopRows.substring(11);
		}
		else if (topLeft.equals(play) && left.equals("_") && bottomLeft.equals(play))
		{
			boardMidRows = boardMidRows.substring(0,2) + "O" + boardMidRows.substring(3);
		}
		else if (topMiddle.equals(play) && middle.equals("_") && bottomMiddle.equals(play))
		{
			boardMidRows = boardMidRows.substring(0,6) + "O" + boardMidRows.substring(7);
		}
		else if (topRight.equals(play) && right.equals("_") && bottomRight.equals(play))
		{
			boardMidRows = boardMidRows.substring(0,10) + "O" + boardMidRows.substring(11);
		}
	}
	private static boolean isThereAWinner()
	{
		// boolean method to check for a winner
		// encompasses 3 additional methods:
		return (checkDiagonalWin() || checkHorizontalWin() || checkVerticalWin());
	}
	private static boolean checkDiagonalWin()
	{
		// separate method for checking a diagonal win
		String topLeft = boardTopRows.substring(2,3);
		String topRight = boardTopRows.substring(10,11);
		String middle = boardMidRows.substring(6,7);
		String bottomLeft = boardBottoms.substring(2,3);
		String bottomRight = boardBottoms.substring(10,11);
		
		if ((topLeft.equals(middle)) && (topLeft.equals(bottomRight)) && (!middle.equals("_")))
		{
			return true;
		}
		else if ((topRight.equals(middle)) && (topRight.equals(bottomLeft)) && (!middle.equals("_")))
		{
			return true;
		}
		return false;
		
	}
	private static boolean checkHorizontalWin()
	{
		// separate method for checking a horizontal win
		String topLeft = boardTopRows.substring(2,3);
		String topMiddle = boardTopRows.substring(6,7);
		String topRight = boardTopRows.substring(10,11);
		String left = boardMidRows.substring(2,3);
		String middle = boardMidRows.substring(6,7);
		String right = boardMidRows.substring(10,11);
		String bottomLeft = boardBottoms.substring(2,3);
		String bottomMiddle = boardBottoms.substring(6,7);
		String bottomRight = boardBottoms.substring(10,11);
		
		if ((topLeft.equals(topMiddle)) && (topLeft.equals(topRight)) && (!topMiddle.equals("_")))
		{
			return true;
		}
		else if ((left.equals(middle)) && (left.equals(right)) && (!middle.equals("_")))
		{
			return true;
		}
		else if ((bottomLeft.equals(bottomMiddle)) && (bottomLeft.equals(bottomRight)) && (!bottomMiddle.equals("_")))
		{
			return true;
		}
		return false;
	}
	private static boolean checkVerticalWin()
	{
		// separate method for checking a vertical win
		String topLeft = boardTopRows.substring(2,3);
		String topMiddle = boardTopRows.substring(6,7);
		String topRight = boardTopRows.substring(10,11);
		String left = boardMidRows.substring(2,3);
		String middle = boardMidRows.substring(6,7);
		String right = boardMidRows.substring(10,11);
		String bottomLeft = boardBottoms.substring(2,3);
		String bottomMiddle = boardBottoms.substring(6,7);
		String bottomRight = boardBottoms.substring(10,11);
		
		if ((topLeft.equals(left)) && (topLeft.equals(bottomLeft)) && (!left.equals("_")))
		{
			return true;
		}
		else if ((topMiddle.equals(middle)) && (topMiddle.equals(bottomMiddle)) && (!middle.equals("_")))
		{
			return true;
		}
		else if ((topRight.equals(right)) && (topRight.equals(bottomRight)) && (!right.equals("_")))
		{
			return true;
		}
		return false;
	}
	private static boolean checkDraw()
	{
		// separate method for checking if the game is a draw
		String topLeft = boardTopRows.substring(2,3);
		String topMiddle = boardTopRows.substring(6,7);
		String topRight = boardTopRows.substring(10,11);
		String left = boardMidRows.substring(2,3);
		String middle = boardMidRows.substring(6,7);
		String right = boardMidRows.substring(10,11);
		String bottomLeft = boardBottoms.substring(2,3);
		String bottomMiddle = boardBottoms.substring(6,7);
		String bottomRight = boardBottoms.substring(10,11);
		
		if (!topLeft.equals("_") && !topMiddle.equals("_") && !topRight.equals("_") &&
				!left.equals("_") && !middle.equals("_") && !right.equals("_") &&
				!bottomLeft.equals("_") && !bottomMiddle.equals("_") && !bottomRight.equals("_"))
		{
			return true;
		}
		return false;
	}
}




















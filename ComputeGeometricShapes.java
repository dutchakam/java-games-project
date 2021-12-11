import java.util.Scanner;
public class ComputeGeometricShapes
{
	private static double radius, circumferenceCircle, areaCircle, areaSphere, volumeSphere;
	private static String spaces = "                     ";
	//*** this Scanner can be used throughout the class.
	private static Scanner scan = new  Scanner(System.in);
	//*** This method controls two while loops. The outer loop allows the game to 
	//*** be played repeatedly.  The inner loop is the game.
	public static void computeGeometricShapes() throws InterruptedException
	{
		// main code block
		String playAgain = "yes";
		
		introduction();
		
		// while the user wants to play again:
		while (playAgain.equalsIgnoreCase("yes"))
		{
			int menuSelection = shapesMenu();
			
			// switch statement based on which calculation the user chose to run:
			switch (menuSelection)
			{
			case 1:
				startRadius();
				break;
			case 2:
				startCircumference();
				break;
			case 3:
				startAreaCircle();
				break;
			case 4:
				startAreaSphere();
				break;
			case 5:
				startVolumeSphere();
				break;
			default:
				System.out.println(spaces + "Invalid Selection. Please try again.\n");
				break;
			}
			playAgain = playAgain();
		}
		System.out.println(spaces + "Thanks for playing!!! Goodbye.\n\n");
	}
	private static void introduction()
	{
		System.out.println(spaces + "There are 5 circle or sphere values that this program calculates. The client\n" 
				+ spaces + "chooses one of the values and the program calculates the other 4 values.");
	}
	private static int shapesMenu()
	{
		// prints a menu of different shape calculations
		// prompts the user to choose which calculation to perform
		int menuSelection;
		System.out.println(spaces + "Which circle or sphere calculation would you like to start with?");
		System.out.println(spaces + "    1) Radius\n\n" + spaces + "    2) Circle Circumference\n\n" + spaces +
				"    3) Circle Area\n\n" + spaces + "    4) Sphere Area\n\n" + spaces + "    5) Sphere Volume\n\n");
		menuSelection = scan.nextInt();
		while (menuSelection < 1 || menuSelection > 5)
		{
			System.out.println(spaces + "Invalid Selection. You must choose between options 1 through 5 inclusive.\n");
			menuSelection = scan.nextInt();
		}
		return menuSelection;
	}
	private static String playAgain()
	{
		// method to prompt the user to play the game again. Returns a String
		String playAgain;
		System.out.println(spaces + "    Would you like to play again?\n" + spaces + "        Please enter (yes/no)\n");
		scan.nextLine();
		playAgain = scan.nextLine();
		while (!"yes".equalsIgnoreCase(playAgain) && !"no".equalsIgnoreCase(playAgain))
		{
			System.out.println(spaces + "Invalid Selection. Please enter (yes/no)\n");
			playAgain = scan.nextLine();
		}
		return playAgain;
	}
	private static void startRadius()
	{
		// this method does the calculations if the user chooses to start by providing a radius measurement
		System.out.println(spaces + "Please enter the radius: \n");
		radius = scan.nextDouble();
		while (radius <= 0.0)
		{
			System.out.println(spaces + "The radius must be greater than zero.\n");
			radius = scan.nextDouble();
		}
		circumferenceCircle = (radius * 2.0) * Math.PI;
		areaCircle = (Math.pow(circumferenceCircle, 2.0)) / (4.0 * Math.PI);
		areaSphere = 4.0 * Math.PI * (Math.pow(radius, 2.0));
		volumeSphere = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3.0);
		printResults();
	}
	private static void startCircumference()
	{
		// this method does the calculations if the user chooses to start by providing a circumference measurement
		System.out.println(spaces + "Please enter the circumference: \n");
		circumferenceCircle = scan.nextDouble();
		while (circumferenceCircle <= 0.0)
		{
			System.out.println(spaces + "The circumference must be greater than zero.\n");
			circumferenceCircle = scan.nextDouble();
		}
		radius = (circumferenceCircle / Math.PI) / 2.0;
		areaCircle = (Math.pow(circumferenceCircle, 2.0)) / (4.0 * Math.PI);
		areaSphere = 4.0 * Math.PI * (Math.pow(radius, 2.0));
		volumeSphere = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3.0);
		printResults();
	}
	private static void startAreaCircle()
	{
		// this method does the calculations if the user chooses to start by providing a circle area measurement
		System.out.println(spaces + "Please enter the area of the circle: \n");
		areaCircle = scan.nextDouble();
		while (areaCircle <= 0.0)
		{
			System.out.println(spaces + "The area must be greater than zero.\n");
			areaCircle = scan.nextDouble();
		}
		circumferenceCircle = 2.0 * (Math.sqrt(Math.PI * areaCircle));
		radius = (circumferenceCircle / Math.PI) / 2.0;
		areaSphere = 4.0 * Math.PI * (Math.pow(radius, 2.0));
		volumeSphere = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3.0);
		printResults();
	}
	private static void startAreaSphere()
	{
		// this method does the calculations if the user chooses to start by providing a sphere area measurement
		System.out.println(spaces + "Please enter the area of the sphere: \n");
		areaSphere = scan.nextDouble();
		while (areaSphere <= 0.0)
		{
			System.out.println(spaces + "The area must be greater than zero.\n");
			areaSphere = scan.nextDouble();
		}
		radius = Math.sqrt(areaSphere / (4.0 * Math.PI));
		circumferenceCircle = (radius * 2.0) * Math.PI;
		areaCircle = (Math.pow(circumferenceCircle, 2.0)) / (4.0 * Math.PI);
		volumeSphere = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3.0);
		printResults();
	}
	private static void startVolumeSphere()
	{
		// this method does the calculations if the user chooses to start by providing a volume measurement
		System.out.println(spaces + "Please enter the volume of the sphere: \n");
		volumeSphere = scan.nextDouble();
		while (volumeSphere <= 0.0)
		{
			System.out.println(spaces + "The volume must be greater than zero.\n");
			volumeSphere = scan.nextDouble();
		}
		radius = Math.cbrt(3.0 * volumeSphere / (4.0 * Math.PI));
		circumferenceCircle = (radius * 2.0) * Math.PI;
		areaCircle = (Math.pow(circumferenceCircle, 2.0)) / (4.0 * Math.PI);
		areaSphere = 4.0 * Math.PI * (Math.pow(radius, 2.0));
		printResults();
	}
	private static void printResults()
	{
		// simple method for printing the results of the calculation performed
		System.out.println(spaces + "The radius of the circle is " + radius + "\n");
		System.out.println(spaces + "The circumference of the circle is " + circumferenceCircle + "\n");
		System.out.println(spaces + "The area of the circle is " + areaCircle + "\n");
		System.out.println(spaces + "The area of the sphere is " + areaSphere + "\n");
		System.out.println(spaces + "The volume of the sphere is " + volumeSphere + "\n");
	}
}


















import java.util.*;
class Lab6
{
	static Scanner input = new Scanner(System.in);
	static boolean menu = false;
	
	public static void main(String [] args)	
	{
		while (!menu) {
			int game = getMenu();
	        selectGame(game);
	        if (!menu) {
	        	while (useAgain(game)) {
	        		selectGame(game);
	        	}
	        }
		}
	}
	
	public static int getMenu() {
		{
	       	System.out.println("Please select from the following options.");
	    	System.out.println("1. Guess my number.         2. TicTacToe.");
	       	System.out.println("3. Calculator.              4. Mad Lib");
	       	System.out.print("Enter any other value to exit: ");         	
	       	while(!input.hasNextInt())
	       	{  		
	       		input.next();
	       		System.out.println("Please use an integer value");
	       	}
    		int game = input.nextInt();
	       	return game;
	    }
	}
	public static void selectGame(int game) {
	switch(game)
		{
			case 1:
				Number.playerGuess();
				break;
			case 2:
				TicTacToe.ticTacToe();
				break;
			case 3:
				Calculator.calculate();
				break;
			case 4:
				MadLib.Fill_In();
				break;
			default:
				System.out.println("Goodbye!");
				menu = true;
				break;
		}
	}
	
	public static boolean useAgain(int game) {
		System.out.println("Want to use the app again? Enter Yes or No");
		char useAgain = input.next().toUpperCase().charAt(0);
		if (useAgain == 'Y') {
			return true;
		} else {
			return false;
		}
	}
}

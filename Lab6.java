class Lab6
{
	public static void main(String [] args)	
	{
        while (true)
        {
        	System.out.println("Please select from the following options.");
        	System.out.println("1. Guess my number.         2. TicTacToe.");
           	System.out.println("3. Calculator.              4. Story")
           	System.out.println("Enter any other value to exit.")
        	int game = input.nextInt();
        	switch(game)
        	{
        		case 1:
        			Number.playerGuess();
        			break;
        		case 2:
        			TicTacToe.game();
        			break;
        		case 3:
        			Calculator.calculate();
        			break;
        		case 4:
        			MadLibs.Fill_In();
        			break;
        		default:
        			System.out.println("Goodbye!");
        			break;
        	}
        }
	}
}

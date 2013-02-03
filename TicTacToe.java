package Lab6;
import java.util.*;
class TicTacToe
{
	private static String board[][];
	private static final int ROWS = 3;
	private static final int COLUMNS = 3;
	private static boolean gameOver = false;
	
	static Scanner input = new Scanner(System.in);
	
	public TicTacToe() 
	{
		board = new String[ROWS][COLUMNS];
		for (int i = 0; i < ROWS; i++) 
		{
			for (int j = 0; j < COLUMNS; j++) 
			{
				int value = (j * ROWS) + i + 1;
				board [i][j] = Integer.toString(value);
			}	
		}
	}
	
	public static void main(String [] args) {
		new TicTacToe();
		String numbersPlayed = ""; 
		int position = 0, compPosition = 0;
		System.out.println("Let's play Tic-Tac-Toe!");
		int c = 1;
		while (!gameOver ^ c > 9) {
			boolean playerDone = false;
			printBoard();
			
			//player's Turn
			while (!playerDone) {
				boolean valid = false;
				//make sure selection is valid
				while (!valid) {
					System.out.print("Choose a spot by typing in the number: ");
					while (!input.hasNextInt()) {
						input.next();
						System.out.print("Please use a number from the board: \n\r");
					}
					position = input.nextInt();
					//make sure input is in range
					if (position > 9 || position < 1) {
						System.out.print("Please use a number from the board: \n\r");
					} else {
						valid = true;
					}
				}
				playerDone = play(position, true);
				System.out.println("You played: " + position);
				numbersPlayed += position + ", ";
				System.out.println("Numbers played: " + numbersPlayed);
				
			}
			
			//test for victory
			if(scanBoardWin("X")){
				break; //break while loop so computer doesn't play.
			}
			
			//computer's turn
			boolean compValid = false;
			int d = 1;
			while (!compValid ^ d > 5) {
				compPosition = compScan();
				System.out.printf("Computer picked %d. \r" , compPosition);
				compValid = play(compPosition, false);
				numbersPlayed += compPosition + ", ";
				System.out.println("Numbers played: " + numbersPlayed);
				d++;
			}
			scanBoardWin("O");
			c++;
		}
		
	}
		
	/**From stackoverflow.com, a method to try and catch to check to see if an int appears in the string.
	 * if that is the case, then the spot is open to use for either the computer or player. 
	 */
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}

	/**From Charity's original post, just tweaked a bit to work with ints instead and use the function to 
	 * check the square. 
	 */
	public static boolean play(int pos, boolean x) //X is the player, O is the AI
	{
		pos = pos - 1; //Subtract one so we can use the natural 1-9 for the player instead of 0 indexed
		if (!(isInteger(board[pos%3][pos/3]))) //Fail to play if a square is already used.
		{
				System.out.printf("Spot %d is taken! Try another!\r", pos + 1);
				return false;
		} else {
			
			if (x) //Set the position in the array to X or O depending on the player then return successful play.
			{
				board[pos%3][pos/3] = "X";
			} else {
				board[pos%3][pos/3] = "O";
			}
			return true;
		}
	}

	
	public static void printBoard()
	{
		for (int i = 0; i < 3; i++)
		{
			if (i%2 == 1) {
				System.out.print("--------------\r");
			}
			for (int j = 0; j < 3; j++)
			{
				if (j%2 == 1) {
					System.out.print("  |  ");
				}
				System.out.print(board[j][i]);
				if (j%2 == 1) {
					System.out.print("  |  ");
				}
			}
			if (i%2 == 1) {
				System.out.print("\r--------------\r");
			} else {
			System.out.print("\r");
			}
		}
	}
	
	/* Method to scan the board to see if a victory is achieved.  It goes through the 8 possible victory scenarios, starting with the diagonals
	 * then the rows, and then columns.
	 */
	public static boolean scanBoardWin(String mark) {
		boolean win = false;
		//Checks the diagonal for victory
		if (board[0][0].equals(mark) && (board[1][1].equals(mark) && board[2][2].equals(mark)) || 
										(board[2][0].equals(mark) && board[0][2].equals(mark)) ) {
				win = true;
		//if diagonals didn't win, now to check the other 6 possibilities
		} else {
			if (	(board[0][0].equals(mark) && board[1][0].equals(mark) && board[2][0].equals(mark)) || 	//row 1
					(board[0][1].equals(mark) && board[1][1].equals(mark) && board[2][1].equals(mark)) || 	//row 2
					(board[0][2].equals(mark) && board[1][2].equals(mark) && board[2][2].equals(mark)) ||  	//row 3
					(board[0][0].equals(mark) && board[0][1].equals(mark) && board[0][2].equals(mark)) ||	//col 1
					(board[1][0].equals(mark) && board[1][1].equals(mark) && board[1][2].equals(mark)) ||	//col 2
					(board[2][0].equals(mark) && board[2][1].equals(mark) && board[2][2].equals(mark)) 		//col 3
				) 
			{
				win = true;
			}
		}
		if (win && mark.equals("X")) {
			gameOver = true;
			printBoard();
			System.out.println("You win, good job!");
		}
		
		if (win && mark.equals("O")) {
			gameOver = true;
			printBoard();
			System.out.println("You loose, good game!");
		}
		return win;
		
	}
	
	/* Method to represent Computer's AI; a feeble attempt.
	 * It will check various conditions outlined in the method and 
	 * play the best move based on conditions. 
	 */

	public static int compScan() {
		int pos = 0;
		//Check for doubles
		//Diagonals first
		if (board[1][1].equals("X")) 
		{
			//Check 3 & 7 for doubles but not already occupied
			if ((board[0][2].equals("X") || board[2][0].equals("X")) && ((isInteger(board[0][2])) ^ (isInteger(board[2][0])))) 
			{
				System.out.println("X is in 5");
				//3 or 7 detected, play other side if available.
				if (board[2][0].equals("X")) {
					pos = 7;
				} else if (board[0][2].equals("X")) {
					pos = 3;
				} else {
					System.out.println("ERROR: DIAG 3-7; LN: 191");
				}
				
			}//Check 1 & 9 for doubles but not already occupied
			else if ((board[0][0].equals("X") || board[2][2].equals("X")) && ((isInteger(board[0][0])) ^ (isInteger(board[2][2])))) 
			{
				//1 or 9 detected, play other side if available.
				if (board[0][0].equals("X")) 
				{
					pos = 9;
				}
				else if (board[2][2].equals("X")) 
				{
					pos = 1;
				}
				else
				{
					System.out.println("ERROR: DIAG 1-9; LN: 202");
				}
				
			}//Now check 4 or 6; row 
			else if (board[1][0].equals("X") || board[1][2].equals("X") && ((isInteger(board[1][0])) ^ (isInteger(board[1][2])))) 
			{ 
				//check which side has mark, then play the opposite
				if (board[1][0].equals("X")) {
					pos = 6;
				} else if (board[1][2].equals("X")) {
					pos = 4;
				} else {
					System.out.println("ERROR: Row 2; LN: 219");
				}
				
			}
			
			//Check column with 2 and 8
			else if (board[0][1].equals("X") || board[2][1].equals("X") && ((isInteger(board[0][1])) ^ (isInteger(board[2][1])))) 
			{ 
				//check which side has mark, then play the opposite
				if (board[0][1].equals("X")) {
					pos = 8;
				} else if (board[2][1].equals("X")) {
					pos = 2;
				} else {
					System.out.println("ERROR: Column 2; LN: 233");
				}
			} else {
				//No doubles detected,
				pos = (int)((Math.random()*8+1));
			}
			
			
			
		} else
		{
			//Check center
			if (isInteger(board[1][1])) {
				pos = 5;
			//if all else is exhausted, have fun AI, have fun.
			} else {
				pos = (int)((Math.random()*8+1));
			}
		}//end double check
		return pos;
	}
}

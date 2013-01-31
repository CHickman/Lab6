class TicTacToe
{
	private static char board[][] = new char[3][3];

	public boolean play(int pos, boolean x) //X is the player, O is the AI
	{
		--pos; //Subtract one so we can use the natural 1-9 for the player instead of 0 indexed
		if (board[pos/3][pos%3] != null) //Fail to play if a square is already used.
		{
				return false;
		}
		if (x) //Set the position in the array to X or O depending on the player then return successful play.
		{
			board[pos/3][pos%3] = 'X';
		}
		else
		{
			board[pos/3][pos%3] = 'O';
		}
		return true;
	}

	public static void printBoard()
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				System.out.print(board[j][i]);
			}
			System.out.println();
		}
	}

	public static void ai() //This is a horrible AI, it pretty much just prioritizes cells without regards to what's there. I'll work on it more later just wanted to get it started.
	{
		if (board[1][1] == null)
		{
			play(4, false);
		}
		else if (board[0][0] == null)
		{
			play(0, false);
		}
		else if (board[0][2] == null)
		{
			play(2, false);
		}
		else if (board[2][0] == null)
		{
			play(6, false);
		}
		else if (board[2][2] == null)
		{
			play(8, false);
		}
		else if (board[0][1] == null)
		{
			play(1, false);
		}
		else if (board[1][0] == null)
		{
			play(3, false);
		}
		else if (board[2][1] == null)
		{
			play(7, false);
		}
		else if (board[1][2] == null)
		{
			play(5, false);
		}
		else
		{
			System.out.println("Game over!");
		}
}

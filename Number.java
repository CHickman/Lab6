class Number
{
  public static void playerGuess()
    {
        int value, guess, range_max = 52, range_min = 1;
        value = (int)(Math.random() * 52 + 1);
        
    	for (int i = 5; i >= 1;)
    	{
            System.out.println();
            System.out.println("You have " + i + " guess(es) remaining.");
            System.out.print("Please enter a guess between " + range_min + " and " + range_max + " inclusive : ");
            
            guess = Lab6.input.nextInt();
            
            if (guess > range_max || guess < range_min)
            {
            	System.out.println("Your guess of " + guess + " is outside of the accepted range. Please try again.");
            	continue;
            }
            else if (guess == value)
            {
                System.out.print("You have guessed correctly! ");
                break;
            }
            else if (guess > value)
            {
                System.out.println("Your input value of " + guess + " is too high.");
                range_max = guess - 1;
            }
            else if (guess < value)
            {
                System.out.println("Your input value of " + guess + " is too low.");
                range_min = guess + 1;
            }
            --i;
        }
        System.out.println("The number was " + value + ". Thanks for playing.");
    }
}

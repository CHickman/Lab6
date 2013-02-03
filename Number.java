class Number
{
  public static void playerGuess()
    {
        int value, guess, rangeMax = 52, rangeMin = 1;
        value = (int)(Math.random() * 52 + 1);
        
      for (int i = 5; i >= 1; i--)
    	{
            System.out.println();
            System.out.println("You have " + i + " guess(es) remaining.");
            System.out.print("Please enter a guess between " + rangeMin + " and " + rangeMax + " inclusive : ");
            //validate user input for integer value
            while (!(Lab6.input.hasNextInt())) {
                Lab6.input.next();
      			    System.out.println("Your guess needs to be a whole number between " + rangeMin + " and " + rangeMax + "!");
    				    System.out.print("Guess again: ");
            }
            guess = Lab6.input.nextInt();
            //once valid, data is compared to computer guess
            if (guess > rangeMax || guess < rangeMin)
            {
            	System.out.println("Your guess of " + guess + " is outside of the accepted range. Please try again.");
            	i++;
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
                rangeMax = guess - 1;
            }
            else if (guess < value)
            {
                System.out.println("Your input value of " + guess + " is too low.");
                rangeMin = guess + 1;
            }
            
        }
        System.out.println("The number was " + value + ". Thanks for playing.");
    }
}

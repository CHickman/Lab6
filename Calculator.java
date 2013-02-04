import java.util.Scanner;

public class Calculator 
{

  public static void calculate() 
	{
	
		//initialize variables
		int operator = 1;	
		//initialize scanner
		Scanner input = new Scanner(System.in);
		
			//user interface
			System.out.println("This is a simple calculator.");
			System.out.println("[1] To perform addition, press 1.");
			System.out.println("[2] To perform subtraction, press 2.");
			System.out.println("[3] To perform multiplication, press 3.");
			System.out.println("[4] To perform division, press 4.");
		
			//put scanner input into operator variable
			operator = input.nextInt();
			if (operator<1 || operator>5)
			{
				System.out.println("Please select from choices 1 through 5");
			}
			if (operator==1)
			{
				Addition();
			}
			if (operator==2)
			{
				Subtraction();
			}
			if (operator==3)
			{
				Multiplication();
			}
			if (operator==4)
			{
				Division();
			}
	}

	public static void Addition()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the first number: ");
		double firstNum = input.nextDouble();
		
		System.out.println("Please enter the second number: ");
		double secondNum = input.nextDouble();
		
		double answer = firstNum + secondNum;
		System.out.println(firstNum + " added to " + secondNum + " equals " + answer);
	}
	
	public static void Subtraction()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the first number: ");
		double firstNum = input.nextDouble();
		
		System.out.println("Please enter the second number: ");
		double secondNum = input.nextDouble();
		
		double answer = firstNum - secondNum;
		System.out.println(firstNum + " subtracted from " + secondNum + " equals " + answer);
	}
	
	public static void Multiplication ()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the first number: ");
		double firstNum = input.nextDouble();
		
		System.out.println("Please enter the second number: ");
		double secondNum = input.nextDouble();
		
		double answer = firstNum * secondNum;
		System.out.println(firstNum + " multiplied by " + secondNum + " equals " + answer);
	}
	public static void Division()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the first number: ");
		double firstNum = input.nextDouble();
		
		System.out.println("Please enter the second number: ");
		double secondNum = input.nextDouble();
		
		double answer = firstNum / secondNum;
		System.out.println(firstNum + " divided by " + secondNum + " equals " + answer);
	}
	
}

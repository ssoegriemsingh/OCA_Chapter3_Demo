// Imports:
import java.util.*;

// Start of class
public class Demo 
{
	// Global vars:
	static String playername;
	int dealerHand = 0;
	int playerHand = 0;
	int hit = 0;
	
	boolean done = false;
	
	Random r = new Random();
	Scanner scanner = new Scanner(System.in);
	
	private static final int NUMBER_OF_CARDS_IN_SUIT = 12;
	
	private static final int NAME_OF_THE_GAME = 21;
	
	// Main:
	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			playername = "Player One";
		}
		else 
		{
			playername = args[0];
		}

		Demo d = new Demo();
	}
	
	// Constructor:
	public Demo()
	{
		Greeting();
		Startgame();
	}
	
	// Function to display a greeting:
	public void Greeting()
	{
		String greeting = playername + ", lets play Black Jack!";
		System.out.println(greeting);
	}
	
	// Function to start the game:
	public void Startgame()
	{
		DealDealer();
		Showing();
		DealPlayer();
		CalcWinner();
	}
	
	private void log(String s) {
		System.out.println(s);
	}
	
	// Function to deal to dealer and show:
	public void DealDealer()
	{
		while(dealerHand < NAME_OF_THE_GAME)
		{
			log("Debug 1 - Dealer hand: " + dealerHand);
			
			hit = r.nextInt(NUMBER_OF_CARDS_IN_SUIT) + 1;
			dealerHand += hit;
			
			log("Debug 2 - Hit: " + hit);
		}
		
		if (dealerHand > NAME_OF_THE_GAME)
		{
			dealerHand -= hit;
		}
	}
	
	public void Showing()
	{
		int showing = dealerHand % 10;
		System.out.println("Dealer is showing: " + showing);
	}
	
	// Function to deal to player:
	public void DealPlayer()
	{
		playerHand += r.nextInt(NUMBER_OF_CARDS_IN_SUIT) + 1;
		System.out.println(playername + " has: " + playerHand);
		do {
			if(playerHand > NAME_OF_THE_GAME)
			{
				System.out.println(playerHand + " BUSTED!");
				done = true;
			}
			else
			{
				HitOrStand();
			}
		} while (!done);
	}
	
	// Function to hit or stand:
	public void HitOrStand()
	{
		System.out.println("Hit (h) or Stand (s)?");
		String input = scanner.next();
		
		if(input.equals("h"))
		{
			DealPlayer();
		}
		else if(input.equals("s"))
		{
			DealDealer();
			done = true;
		}
		else
		{
			System.out.println("Please enter a valid command.");
		}
	}
	
	public void CalcWinner()
	{
		System.out.println("Dealer has: " + dealerHand);
		System.out.println("Player has: " + playerHand);
		
		if (playerHand > NAME_OF_THE_GAME)
		{
			System.out.println("To bad, you lost!");
		}
		else if(playerHand > dealerHand)
		{
			System.out.println("Congratulations, you've won!");
		}
		else
		{
			System.out.println("To bad, you lost!");
		}
	}
}
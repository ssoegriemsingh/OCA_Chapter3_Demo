// Imports:
import java.util.*;

// Start of class
public class Demo
{
	// Global vars:
	static String playername;
	int playerHand = 0;
	
	Random r = new Random();
	Scanner scanner = new Scanner(System.in);
	
	// Main:
	public static void main(String[] args)
	{
		playername = args[0];
		
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
		DealPlayer();
		HitOrStand();
	}
	
	// Function to deal dealerhand and show:
	public void DealDealer()
	{
		int dealerHand = r.nextInt(13) + 1;
		int hit = r.nextInt(13);
		
		while(dealerHand < 21)
		{
			dealerHand += hit;
			//System.out.println("After hit dealer hand: " + dealerHand);
		}
		
		if (dealerHand > 21)
		{
			dealerHand -= hit;
		}
		
		int showing = dealerHand % 10;
		
		System.out.println("Dealer is showing: " + showing);
		//System.out.println("Dealer has: " + dealerHand);
	}
	
	// Function to deal playerhand:
	public void DealPlayer()
	{
		playerHand += r.nextInt(13) + 1;
		System.out.println(playername + " has: " + playerHand);
	}
	
	// Function to hit or stand:
	public void HitOrStand()
	{
		System.out.println("Hit (h) or Stand (s)?");
		String input = scanner.next();
		
		//System.out.println(input);
		
		if(input.equals("h"))
		{
			DealPlayer();
			HitOrStand();
		}
		else if(input.equals("s"))
		{
			//Stand();
		}
		else
		{
			System.out.println("Please enter a valid command.");
			HitOrStand();
		}
	}
}
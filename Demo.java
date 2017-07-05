// Imports:
import java.util.Random;

// Start of class
public class Demo
{
	// Global vars:
	static String playername;
	
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
	
	public void Greeting()
	{
		String greeting = playername + ", lets play Black Jack!";
		System.out.println(greeting);
	}
	
	public void Startgame()
	{
		Random r = new Random();
		
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
}
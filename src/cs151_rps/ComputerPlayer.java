package cs151_rps;

import java.util.Random;

public class ComputerPlayer extends Player
{
	
	/**
	 * Finds out a computer's choice. A random decision.
	 */
	@Override
	GameObject queryThrow() throws Exception
	{
		Random rand = new Random();
		int choice = rand.nextInt();
		choice = choice%3;
		
		if(choice == 1)
		{
			return GameObject.ROCK;
		}
		else if(choice == 2)
		{
			return GameObject.PAPER;
		}
		else 
		{
			return GameObject.SCISSORS;
		}
			
		
	}	//end of queryThrow
        
        ComputerPlayer( String name, Scorecard score )
        {
            super( name, score );
        }

	
}	//end of ComputerPlayer

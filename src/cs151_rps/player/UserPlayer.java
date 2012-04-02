package cs151_rps.player;

import cs151_rps.GameObject;
import cs151_rps.io.UIO;



public class UserPlayer extends Player 
{
	
    public UserPlayer( String name, UIO endpoint ) 
    {
        super(name,endpoint);
    }
        
    /**
     * Finds out user's choice and returns it
     * 
     * @throws Exception for aborting the match
     */
    @Override
    public GameObject queryThrow() throws Exception 
    {
        // query for throw, loop until player chooses
        while (true) {

            //Prompt for the user's choice
            endpoint.displayUserPrompt( name );
            int choice = endpoint.getThrow();
            
            switch (choice) {
                case 1: // ROCK
                    return GameObject.ROCK;
                case 2: // PAPER
                    return GameObject.PAPER;
                case 3: // SCISSORS
                    return GameObject.SCISSORS;
                case 5: // SCORE
                	throw new Exception("score");
                case 6: // QUIT
                    throw new Exception("user abort");
                default: // INVALID INPUT
                    endpoint.displayUserInputError();                        
                case 4: // HELP (default)
                    endpoint.displayHelp();
                    break;
            }
        }		
    }	//end of queryThrow

}	//end of UserPlayer
